package com.bottomUp.service.docFeed;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.DoctorData;
import com.bottomUp.domain.PatientData;
import com.bottomUp.domain.common.user.UserData;
import com.bottomUp.domain.common.user.UserProfileData;
import com.bottomUp.model.DoctorViewData;
import com.bottomUp.model.PatientViewData;
import com.bottomUp.myBatis.persistence.DoctorMapper;
import com.bottomUp.myBatis.persistence.PatientMapper;
import com.bottomUp.myBatis.persistence.UserMapper;
import com.bottomUp.myBatis.persistence.UserProfileMapper;
import com.bottomUp.service.common.user.UserService;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by raj on 10/24/2020.
 */
@Service
@Transactional
public class DoctorViewService
{

    private static final Logger LOGGER = LoggerFactory.getLogger(DoctorViewService.class);

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private DoctorMapper doctorMapper;

    @Autowired
    private UserProfileMapper userProfileMapper;



    public DoctorViewData create(DoctorViewData doctorViewData, String companyID) throws BottomUpException{
        DoctorData doctorData = new DoctorData();
        try {
            UserData userData = userMapper.getUserByUserName(doctorViewData.getDoctorCode());
            if(userData != null){
                throw new BottomUpException("Doctor Code Already in use with another Doctor");
            }
            UserProfileData profileData = new UserProfileData();
            ModelMapper modelMapper = new ModelMapper();
            modelMapper.getConfiguration().setSkipNullEnabled(true).setMatchingStrategy(MatchingStrategies.STRICT);
            modelMapper.map(profileData, doctorViewData);
            profileData.setUserName(doctorViewData.getContactNo());
            userData = userService.createUserProfile(profileData, companyID);
            modelMapper.map(doctorData, doctorViewData);
            doctorData.setUserID(userData.getUserID());
            doctorMapper.create(doctorData);
            profileData.setDoctorID(doctorData.getDoctorID());
            userProfileMapper.update(profileData);
        }catch (Exception ex){
            LOGGER.error(ex.getMessage());
        }
        return doctorViewData;
    }

    public DoctorViewData update(DoctorViewData doctorViewData) throws BottomUpException{

        try {
            UserData userData = userMapper.getUserByUserName(doctorViewData.getDoctorCode());
            if(userData != null){
                throw new BottomUpException("Doctor Code Already in use with another Doctor");
            }
            UserProfileData profileData = new UserProfileData();
            ModelMapper modelMapper = new ModelMapper();
            modelMapper.getConfiguration().setSkipNullEnabled(true).setMatchingStrategy(MatchingStrategies.STRICT);
            modelMapper.map(profileData, doctorViewData);
            userService.updateUserProfile(profileData);
            DoctorData doctorData = new DoctorData();
            modelMapper.map(doctorData, doctorViewData);
            doctorMapper.update(doctorData);
        }catch (Exception ex){
            LOGGER.error(ex.getMessage());
        }
        return doctorViewData;
    }
}
