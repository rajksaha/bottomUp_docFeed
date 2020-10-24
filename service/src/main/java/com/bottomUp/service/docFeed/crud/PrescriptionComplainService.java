package com.bottomUp.service.docFeed.crud;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.AppointmentTypeData;
import com.bottomUp.domain.PrescriptionComplainData;
import com.bottomUp.myBatis.persistence.AppointmentTypeMapper;
import com.bottomUp.myBatis.persistence.PrescriptionComplainMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by raj on 09/08/2020.
 */

@Service
public class PrescriptionComplainService {

    @Autowired
    private PrescriptionComplainMapper prescriptionComplainMapper;

    public void create(PrescriptionComplainData data) throws BottomUpException {
        prescriptionComplainMapper.create(data);
    }

    public void update(PrescriptionComplainData data) throws BottomUpException {
        prescriptionComplainMapper.update(data);
    }

    public PrescriptionComplainData getByID(Long ID)throws BottomUpException {
        return this.prescriptionComplainMapper.getByID(ID);
    }

    public List<PrescriptionComplainData> getByParam(Map<String, Object> param) throws BottomUpException {
        return this.prescriptionComplainMapper.getByParam(param);
    }

    public void delete (Map<String,Object> param) throws BottomUpException {
        this.prescriptionComplainMapper.delete(param);
    }
}
