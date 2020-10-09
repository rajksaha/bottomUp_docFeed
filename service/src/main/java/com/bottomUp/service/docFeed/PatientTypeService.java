package com.bottomUp.service.docFeed;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.AppointmentTypeData;
import com.bottomUp.domain.PatientTypeData;
import com.bottomUp.myBatis.persistence.AppointmentTypeMapper;
import com.bottomUp.myBatis.persistence.PatientTypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by raj on 09/08/2020.
 */

@Service
public class PatientTypeService {

    @Autowired
    private PatientTypeMapper patientTypeMapper;

    public PatientTypeData create(PatientTypeData data) throws BottomUpException {
        return this.patientTypeMapper.create(data);
    }

    public PatientTypeData update(PatientTypeData data) throws BottomUpException {
        return this.patientTypeMapper.update(data);
    }

    public PatientTypeData getByID(Long ID)throws BottomUpException {
        return this.patientTypeMapper.getByID(ID);
    }

    public List<PatientTypeData> getByParam(Map<String, Object> param) throws BottomUpException {
        return this.patientTypeMapper.getByParam(param);
    }

    public void delete (Map<String,Object> param) throws BottomUpException {
        this.patientTypeMapper.delete(param);
    }
}
