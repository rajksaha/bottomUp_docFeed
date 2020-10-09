package com.bottomUp.service.docFeed;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.AppointmentTypeData;
import com.bottomUp.domain.PatientPastDiseaseData;
import com.bottomUp.myBatis.persistence.AppointmentTypeMapper;
import com.bottomUp.myBatis.persistence.PatientPastDiseaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by raj on 09/08/2020.
 */

@Service
public class PatientPastDiseaseService {

    @Autowired
    private PatientPastDiseaseMapper patientPastDiseaseMapper;

    public PatientPastDiseaseData create(PatientPastDiseaseData data) throws BottomUpException {
        return this.patientPastDiseaseMapper.create(data);
    }

    public PatientPastDiseaseData update(PatientPastDiseaseData data) throws BottomUpException {
        return this.patientPastDiseaseMapper.update(data);
    }

    public PatientPastDiseaseData getByID(Long ID)throws BottomUpException {
        return this.patientPastDiseaseMapper.getByID(ID);
    }

    public List<PatientPastDiseaseData> getByParam(Map<String, Object> param) throws BottomUpException {
        return this.patientPastDiseaseMapper.getByParam(param);
    }

    public void delete (Map<String,Object> param) throws BottomUpException {
        this.patientPastDiseaseMapper.delete(param);
    }
}
