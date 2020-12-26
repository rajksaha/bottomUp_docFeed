package com.bottomUp.service.docFeed;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.PatientData;
import com.bottomUp.domain.common.user.UserData;
import com.bottomUp.domain.common.user.UserProfileData;
import com.bottomUp.model.PatientViewData;
import com.bottomUp.myBatis.persistence.AppointmentMapper;
import com.bottomUp.myBatis.persistence.PatientMapper;
import com.bottomUp.myBatis.persistence.UserMapper;
import com.bottomUp.service.common.user.UserService;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.collections.map.HashedMap;
import org.apache.commons.lang3.RandomStringUtils;
import org.joda.time.DateTime;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import utility.DateUtil;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


/**
 * Created by raj on 10/24/2020.
 */
@Service
@Transactional
public class PatientViewService
{

    private static final Logger LOGGER = LoggerFactory.getLogger(PatientViewService.class);

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PatientMapper patientMapper;

    @Autowired
    private AppointmentMapper appointmentMapper;

    public PatientData
    create(PatientViewData patientViewData, Long companyID) throws BottomUpException{
        PatientData patientData = new PatientData();
        try {
            UserProfileData profileData = new UserProfileData();
            ModelMapper modelMapper = new ModelMapper();
            modelMapper.getConfiguration().setSkipNullEnabled(true).setMatchingStrategy(MatchingStrategies.STRICT);
            modelMapper.map(patientViewData, profileData);
            if(patientViewData.getDateOfBirth() == null && patientViewData.getAge() != null){
                profileData.setDateOfBirth(DateUtil.addDays(new Date(), -(365*patientViewData.getAge())));
            }
            profileData.setUserName(createUserName(patientViewData.getFirstName()));
            UserData userData = userService.createUserProfile(profileData, null);
            modelMapper.map(patientViewData, patientData);
            patientData.setUserID(userData.getUserID());
            patientData.setPatientCode(this.createPatientCode());
            patientMapper.create(patientData);
        }catch (Exception ex){
            LOGGER.error(ex.getMessage());
        }
        return patientData;
    }

    public PatientViewData update(PatientViewData patientViewData) throws BottomUpException{

        try {
            UserData userData = userMapper.getUserByUserName(patientViewData.getContactNo());
            if(userData != null){
                throw new BottomUpException("Phone Number Already in use with another Patient");
            }
            UserProfileData profileData = new UserProfileData();
            ModelMapper modelMapper = new ModelMapper();
            modelMapper.getConfiguration().setSkipNullEnabled(true).setMatchingStrategy(MatchingStrategies.STRICT);
            modelMapper.map(patientViewData, profileData);
            userService.updateUserProfile(profileData);
            PatientData patientData = new PatientData();
            modelMapper.map(patientViewData, patientData);
            patientMapper.update(patientData);
        }catch (Exception ex){
            LOGGER.error(ex.getMessage());
        }
        return patientViewData;
    }

    private String createPatientCode() throws Exception{
        DateTime dateTime = new DateTime();
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("date", dateTime);
        Long numOfAppToday = appointmentMapper.getCountByParam(param);
        String padded = String.format("%04d", numOfAppToday);
        return "" + dateTime.getYear() + dateTime.getMonthOfYear() + dateTime.getDayOfMonth()+ padded;
    }

    private String createUserName(String firstName) throws Exception{
        return "" + firstName.substring(5) + RandomStringUtils.randomAlphanumeric(4).toUpperCase();
    }
    //TODO:getPatient Detail included userProfile
}
