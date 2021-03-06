package com.bottomUp.service.docFeed.crud;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.AppointmentTypeData;
import com.bottomUp.domain.PatientData;
import com.bottomUp.domain.common.user.UserData;
import com.bottomUp.domain.common.user.UserProfileData;
import com.bottomUp.model.PatientViewData;
import com.bottomUp.myBatis.persistence.AppointmentTypeMapper;
import com.bottomUp.myBatis.persistence.PatientMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * Created by raj on 09/08/2020.
 */

@Service
@Transactional
public class PatientService {

    @Autowired
    private PatientMapper patientMapper;

    public void create(PatientData data) throws BottomUpException {
        patientMapper.create(data);
    }

    public void update(PatientData data) throws BottomUpException {
        patientMapper.update(data);
    }

    public void updatePatientType(String patientID, Integer patientTypeID) throws BottomUpException {
        PatientData patientData = new PatientData();
        patientData.setPatientID(patientID);
        patientData.setPatientType(patientTypeID);
        patientMapper.updatePatientType(patientData);
    }

    public void updatePatientImage(String patientID, String contentUrl) throws BottomUpException {
        PatientData patientData = new PatientData();
        patientData.setPatientID(patientID);
        patientData.setImageURL(contentUrl);
        patientMapper.updatePatientImg(patientData);
    }


    public PatientViewData getByID(String ID)throws BottomUpException {
        return this.patientMapper.getByID(ID);
    }

    public List<PatientData> getByParam(Map<String, Object> param) throws BottomUpException {
        return this.patientMapper.getByParam(param);
    }

    public void delete (Map<String,Object> param) throws BottomUpException {
        this.patientMapper.delete(param);
    }

    public List<PatientViewData> patientSearch(Map<String, Object> param) throws BottomUpException{
        return this.patientMapper.patientSearch(param);
    }
}
