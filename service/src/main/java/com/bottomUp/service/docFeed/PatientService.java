package com.bottomUp.service.docFeed;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.AppointmentTypeData;
import com.bottomUp.domain.PatientData;
import com.bottomUp.myBatis.persistence.AppointmentTypeMapper;
import com.bottomUp.myBatis.persistence.PatientMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by raj on 09/08/2020.
 */

@Service
public class PatientService {

    @Autowired
    private PatientMapper patientMapper;

    public PatientData create(PatientData data) throws BottomUpException {
        return this.patientMapper.create(data);
    }

    public PatientData update(PatientData data) throws BottomUpException {
        return this.patientMapper.update(data);
    }

    public PatientData getByID(Long ID)throws BottomUpException {
        return this.patientMapper.getByID(ID);
    }

    public List<PatientData> getByParam(Map<String, Object> param) throws BottomUpException {
        return this.patientMapper.getByParam(param);
    }

    public void delete (Map<String,Object> param) throws BottomUpException {
        this.patientMapper.delete(param);
    }
}
