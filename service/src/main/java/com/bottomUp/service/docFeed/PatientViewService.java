package com.bottomUp.service.docFeed;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.PatientData;
import com.bottomUp.domain.common.user.UserData;
import com.bottomUp.domain.common.user.UserProfileData;
import com.bottomUp.model.PatientViewData;
import com.bottomUp.myBatis.persistence.PatientMapper;
import com.bottomUp.myBatis.persistence.UserMapper;
import com.bottomUp.service.common.user.UserService;
import org.apache.commons.beanutils.BeanUtils;
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
public class PatientViewService
{

    private static final Logger LOGGER = LoggerFactory.getLogger(PatientViewService.class);

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PatientMapper patientMapper;



    public PatientData createNewPatient(PatientViewData patientViewData, Long companyID) throws BottomUpException{
        PatientData patientData = new PatientData();
        try {
            UserData userData = userMapper.getUserByUserName(patientViewData.getContactNo());
            if(userData != null){
                throw new BottomUpException("Phone Number Already in use with another Patient");
            }
            UserProfileData profileData = new UserProfileData();
            ModelMapper modelMapper = new ModelMapper();
            modelMapper.getConfiguration().setSkipNullEnabled(true).setMatchingStrategy(MatchingStrategies.STRICT);
            modelMapper.map(profileData, patientViewData);
            profileData.setUserName(patientViewData.getContactNo());
            userData = userService.createUserProfile(profileData, companyID);
            modelMapper.map(patientData, patientViewData);
            patientData.setUserID(userData.getUserID());
            patientMapper.create(patientData);
        }catch (Exception ex){
            LOGGER.error(ex.getMessage());
        }
        return patientData;
    }

    public PatientViewData updatePatient(PatientViewData patientViewData) throws BottomUpException{

        try {
            UserData userData = userMapper.getUserByUserName(patientViewData.getContactNo());
            if(userData != null){
                throw new BottomUpException("Phone Number Already in use with another Patient");
            }
            UserProfileData profileData = new UserProfileData();
            ModelMapper modelMapper = new ModelMapper();
            modelMapper.getConfiguration().setSkipNullEnabled(true).setMatchingStrategy(MatchingStrategies.STRICT);
            modelMapper.map(profileData, patientViewData);
            userService.updateUserProfile(profileData);
            PatientData patientData = new PatientData();
            modelMapper.map(patientData, patientViewData);
            patientMapper.update(patientData);
        }catch (Exception ex){
            LOGGER.error(ex.getMessage());
        }
        return patientViewData;
    }
}
