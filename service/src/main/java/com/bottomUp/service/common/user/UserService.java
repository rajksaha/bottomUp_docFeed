package com.bottomUp.service.common.user;

import com.bottomUp.common.config.QueueConfig;
import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.common.queue.QueueProducer;
import com.bottomUp.common.utility.EmailType;
import com.bottomUp.common.utility.PasswordEncryptor;
import com.bottomUp.domain.DoctorData;
import com.bottomUp.domain.DoctorDrugSettingData;
import com.bottomUp.domain.DoctorSettingData;
import com.bottomUp.domain.common.user.UserData;
import com.bottomUp.domain.common.user.UserGroupAssignmentData;
import com.bottomUp.domain.common.user.UserGroupData;
import com.bottomUp.domain.common.user.UserProfileData;
import com.bottomUp.myBatis.persistence.*;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.*;

/**
 * Created by raj on 4/20/2016.
 */

@Service
@Transactional(rollbackFor = BottomUpException.class)
public class UserService {


    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserProfileMapper userProfileMapper;

    @Autowired
    private UserGroupMapper userGroupMapper;

    @Autowired
    private QueueProducer queueProducer;

    @Autowired
    private UserGroupAssignmentMapper userGroupAssignmentMapper;

    @Autowired
    private DoctorMapper doctorMapper;

    @Autowired
    private DoctorSettingMapper doctorSettingMapper;


    public UserData getUserByUserName(String userName) throws BottomUpException {
        return this.userMapper.getUserByUserName(userName);
    }

    public void updatePassword(UserData userData) throws BottomUpException {
        PasswordEncryptor encryptor = new PasswordEncryptor();
        userData.setPassword(encryptor.encrypt(userData.getPassword()));
        this.userMapper.updatePassword(userData);
    }

    public void updateStatus(UserData userData) throws BottomUpException {
        this.userMapper.updateStatus(userData);
    }

    public void update(UserData userData) throws BottomUpException {
        this.userMapper.update(userData);
    }

    public void create(UserData userData) throws BottomUpException {
        this.userMapper.create(userData);
    }

    public UserProfileData getUserProfileByID(Long userID) throws BottomUpException {
        UserProfileData userProfileData = this.userProfileMapper.getUserProfileByID(userID);
        if(userProfileData.getDoctorID() != null){
            Map<String, Object> param = new HashMap<String, Object>();
            param.put("userID", userID);
            List<DoctorData> doctorDataList = doctorMapper.getByParam(param);
            if(doctorDataList != null && doctorDataList.size() > 0){
                userProfileData.setDoctorData(doctorDataList.get(0));
                userProfileData.setDocSettingData(doctorSettingMapper.getByDoctorID(userProfileData.getDoctorID()));
                userProfileData.setIsDoctor(1);
            }else{
                userProfileData.setIsDoctor(2);
            }
        }
        return userProfileData;
    }

    public UserData createUserProfile(UserProfileData userProfileData, Long companyID) throws BottomUpException {
        UserData userData = new UserData();
        userData.setUserName(userProfileData.getUserName());
        userData.setCompanyID(companyID);
        String defaultPassword = "123456";
        PasswordEncryptor encryptor = new PasswordEncryptor();
        userData.setPassword(encryptor.encrypt(defaultPassword));
        userData.setStatus(2);
        userData.setIsBlocked(false);
        this.create(userData);
        this.createDoctor(userProfileData, userData.getUserID());
        userProfileData.setUserID(userData.getUserID());
        this.userProfileMapper.create(userProfileData);

        if(userProfileData.getCompanyAdmin() != null && userProfileData.getCompanyAdmin() == 1){
            Map<String, Object> param = new HashMap<String, Object>();
            param.put("shortName", "COMPANY_ADMIN");
            param.put("companyID", companyID);
            UserGroupData groupData = userGroupMapper.getSingleByParam(param);
            if(groupData != null){
                UserGroupAssignmentData groupAssignmentData = new UserGroupAssignmentData();
                groupAssignmentData.setUserID(userData.getUserID());
                groupAssignmentData.setUserGroupID(groupData.getUserGroupID());
                userGroupAssignmentMapper.create(groupAssignmentData);
            }
        }
        return userData;
    }

    public void updateUserProfile(UserProfileData userProfileData) throws BottomUpException {
        this.userProfileMapper.update(userProfileData);
        this.updateDoctor(userProfileData);
        UserData userData = new UserData();
        userData.setStatus(userProfileData.getStatus());
        userData.setUserID(userProfileData.getUserID());
        this.userMapper.updateStatus(userData);
    }

    public List<UserProfileData> getUserProfileByParam(Map<String, Object> param) throws BottomUpException {
        return this.userProfileMapper.getUserProfileByParam(param);
    }

    public Integer getUserCountByParam(Map<String, Object> param) throws BottomUpException {
        return this.userProfileMapper.getUserCountByParam(param);
    }

    public Map<String, Object> requestForPasswordReset(String userName, String url) throws BottomUpException {


        Map<String, Object> result = new HashMap<String, Object>();
        result.put("hasError", false);
        result.put("message", "Password reset email send successfully, please check ur email");

        if (StringUtils.isNotBlank(userName)) {
            UserData userData = this.userMapper.getUserByUserName(userName);

            if (userData == null) {
                result.put("hasError", true);
                result.put("message", "No User exist with that username");
            } else {
                if(userData.getStatus() != null && userData.getStatus() == 1 || userData.getStatus() == 2){
                    sendResetPasswordEmail(userData,result,url);
                }else{
                    result.put("hasError", true);
                    result.put("message", "Your account is inactive.Please contact to System Admin.");
                }
            }
        }
        return result;
    }


    private Map<String, Object> sendResetPasswordEmail(UserData userData, Map<String, Object> result, String url)throws BottomUpException {

        UserProfileData userProfileData = this.userProfileMapper.getUserProfileByID(userData.getUserID());
        if(userProfileData.getEmailAddress() != null){

            String secretKey = UUID.randomUUID().toString();
            userData.setSecretKey(secretKey);
            userData.setSecretKeyCreatedOn(new Timestamp(new Date().getTime()));
            this.userMapper.update(userData);
            try{
                Map<String, Object> queueParam = new HashMap<>();
                queueParam.put("emailType", EmailType.PASSWORD_RESET.name());
                queueParam.put("username", userData.getUserName());
                queueParam.put("url", url);
                queueParam.put("email", userProfileData.getEmailAddress());
                //queueParam.put("email", "raj.gmk@gmail.com");
                queueProducer.sendObject(QueueConfig.EMAIL_QUEUE, queueParam);
            }catch (Exception e){
                result.put("hasError", true);
                result.put("message", "Profile has no email address.");
            }


        }else{
            result.put("hasError", true);
            result.put("message", "Profile has no email address.");
        }



        return result;
    }

    public Map<String, Object> requestForPasswordReset(UserData userData) throws BottomUpException {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("hasError", false);
        result.put("message", "Password reset email send successfully, please check ur email");

        Map<String, Object> queryParam = new HashMap<String, Object>();
        queryParam.put("secretKey", userData.getSecretKey());
        List<UserData> listUser = this.userMapper.getUserByParam(queryParam);
        if(CollectionUtils.isNotEmpty(listUser)){

            UserData dbUser = listUser.get(0);
            dbUser.setPassword(PasswordEncryptor.encrypt(userData.getPassword()));
            dbUser.setSecretKey(null);
            dbUser.setSecretKeyCreatedOn(null);
            this.userMapper.update(dbUser);

        }else{
            result.put("hasError", true);
            result.put("message", "This Password reset email has been expired, Please Try again");
        }
        return result;
    }

    public void createDoctor(UserProfileData userProfileData, Long userID)throws BottomUpException{
        if(userProfileData.getIsDoctor() != null && userProfileData.getIsDoctor() == 1){
            DoctorData doctorData = userProfileData.getDoctorData();
            doctorData.setUserID(userID);
            this.doctorMapper.create(doctorData);
            userProfileData.getDocSettingData().setDoctorID(doctorData.getDoctorID());
            this.doctorSettingMapper.create(userProfileData.getDocSettingData());
            userProfileData.setDoctorID(doctorData.getDoctorID());
        }
    }

    public void updateDoctor(UserProfileData userProfileData)throws BottomUpException{
        if(userProfileData.getIsDoctor() != null && userProfileData.getIsDoctor() == 1){
            this.doctorMapper.update(userProfileData.getDoctorData());
            this.doctorSettingMapper.update(userProfileData.getDocSettingData());
        }
    }
}
