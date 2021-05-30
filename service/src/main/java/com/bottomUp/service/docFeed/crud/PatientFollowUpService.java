package com.bottomUp.service.docFeed.crud;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.AppointmentTypeData;
import com.bottomUp.domain.PatientFollowUpData;
import com.bottomUp.myBatis.persistence.AppointmentTypeMapper;
import com.bottomUp.myBatis.persistence.PatientFollowUpMapper;
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
public class PatientFollowUpService {

    @Autowired
    private PatientFollowUpMapper patientFollowUpMapper;

    public void create(PatientFollowUpData data) throws BottomUpException {
        patientFollowUpMapper.create(data);
    }

    public void update(PatientFollowUpData data) throws BottomUpException {
        patientFollowUpMapper.update(data);
    }

    public PatientFollowUpData getByID(String ID)throws BottomUpException {
        return this.patientFollowUpMapper.getByID(ID);
    }

    public List<PatientFollowUpData> getByParam(Map<String, Object> param) throws BottomUpException {
        return this.patientFollowUpMapper.getByParam(param);
    }

    public void delete (Map<String,Object> param) throws BottomUpException {
        this.patientFollowUpMapper.delete(param);
    }
}
