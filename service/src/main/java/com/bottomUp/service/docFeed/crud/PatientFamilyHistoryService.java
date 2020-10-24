package com.bottomUp.service.docFeed.crud;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.AppointmentTypeData;
import com.bottomUp.domain.PatientFamilyHistoryData;
import com.bottomUp.myBatis.persistence.AppointmentTypeMapper;
import com.bottomUp.myBatis.persistence.PatientFamilyHistoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by raj on 09/08/2020.
 */

@Service
public class PatientFamilyHistoryService {

    @Autowired
    private PatientFamilyHistoryMapper patientFamilyHistoryMapper;

    public void create(PatientFamilyHistoryData data) throws BottomUpException {
        patientFamilyHistoryMapper.create(data);
    }

    public void update(PatientFamilyHistoryData data) throws BottomUpException {
        patientFamilyHistoryMapper.update(data);
    }

    public PatientFamilyHistoryData getByID(Long ID)throws BottomUpException {
        return this.patientFamilyHistoryMapper.getByID(ID);
    }

    public List<PatientFamilyHistoryData> getByParam(Map<String, Object> param) throws BottomUpException {
        return this.patientFamilyHistoryMapper.getByParam(param);
    }

    public void delete (Map<String,Object> param) throws BottomUpException {
        this.patientFamilyHistoryMapper.delete(param);
    }
}
