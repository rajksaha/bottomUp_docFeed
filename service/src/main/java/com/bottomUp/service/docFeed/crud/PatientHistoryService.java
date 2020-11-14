package com.bottomUp.service.docFeed.crud;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.AppointmentTypeData;
import com.bottomUp.domain.PatientHistoryData;
import com.bottomUp.myBatis.persistence.AppointmentTypeMapper;
import com.bottomUp.myBatis.persistence.PatientHistoryMapper;
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
public class PatientHistoryService {

    @Autowired
    private PatientHistoryMapper patientHistoryMapper;

    public void create(PatientHistoryData data) throws BottomUpException {
        patientHistoryMapper.create(data);
    }

    public void update(PatientHistoryData data) throws BottomUpException {
        patientHistoryMapper.update(data);
    }

    public PatientHistoryData getByID(Long ID)throws BottomUpException {
        return this. patientHistoryMapper.getByID(ID);
    }

    public List<PatientHistoryData> getByParam(Map<String, Object> param) throws BottomUpException {
        return this. patientHistoryMapper.getByParam(param);
    }

    public void delete (Map<String,Object> param) throws BottomUpException {
        this. patientHistoryMapper.delete(param);
    }
}
