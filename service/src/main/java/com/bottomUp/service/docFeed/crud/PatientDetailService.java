package com.bottomUp.service.docFeed.crud;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.AppointmentTypeData;
import com.bottomUp.domain.PatientDetailData;
import com.bottomUp.myBatis.persistence.AppointmentTypeMapper;
import com.bottomUp.myBatis.persistence.PatientDetailMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by raj on 09/08/2020.
 */

@Service
public class PatientDetailService {

    @Autowired
    private PatientDetailMapper patientDetailMapper;

    public void create(PatientDetailData data) throws BottomUpException {
        patientDetailMapper.create(data);
    }

    public void update(PatientDetailData data) throws BottomUpException {
        patientDetailMapper.update(data);
    }

    public PatientDetailData getByID(Long ID)throws BottomUpException {
        return this.patientDetailMapper.getByID(ID);
    }

    public List<PatientDetailData> getByParam(Map<String, Object> param) throws BottomUpException {
        return this.patientDetailMapper.getByParam(param);
    }

    public void delete (Map<String,Object> param) throws BottomUpException {
        this.patientDetailMapper.delete(param);
    }
}
