package com.bottomUp.service.docFeed.crud;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.AppointmentTypeData;
import com.bottomUp.domain.PatientDrugHistoryData;
import com.bottomUp.myBatis.persistence.AppointmentTypeMapper;
import com.bottomUp.myBatis.persistence.PatientDrugHistoryMapper;
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
public class PatientDrugHistoryService {

    @Autowired
    private PatientDrugHistoryMapper patientDrugHistoryMapper;

    public void create(PatientDrugHistoryData data) throws BottomUpException {
        patientDrugHistoryMapper.create(data);
    }

    public void update(PatientDrugHistoryData data) throws BottomUpException {
        patientDrugHistoryMapper.update(data);
    }

    public PatientDrugHistoryData getByID(String ID)throws BottomUpException {
        return this.patientDrugHistoryMapper.getByID(ID);
    }

    public List<PatientDrugHistoryData> getByParam(Map<String, Object> param) throws BottomUpException {
        return this.patientDrugHistoryMapper.getByParam(param);
    }

    public void delete (Map<String,Object> param) throws BottomUpException {
        this.patientDrugHistoryMapper.delete(param);
    }
}
