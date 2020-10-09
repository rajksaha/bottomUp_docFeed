package com.bottomUp.service.docFeed;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.AppointmentTypeData;
import com.bottomUp.domain.PrescriptionNextVisitData;
import com.bottomUp.myBatis.persistence.AppointmentTypeMapper;
import com.bottomUp.myBatis.persistence.PrescriptionNextVisitMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by raj on 09/08/2020.
 */

@Service
public class PrescriptionNextVisitService {

    @Autowired
    private PrescriptionNextVisitMapper prescriptionNextVisitMapper;

    public PrescriptionNextVisitData create(PrescriptionNextVisitData data) throws BottomUpException {
        return this.prescriptionNextVisitMapper.create(data);
    }

    public PrescriptionNextVisitData update(PrescriptionNextVisitData data) throws BottomUpException {
        return this.prescriptionNextVisitMapper.update(data);
    }

    public PrescriptionNextVisitData getByID(Long ID)throws BottomUpException {
        return this.prescriptionNextVisitMapper.getByID(ID);
    }

    public List<PrescriptionNextVisitData> getByParam(Map<String, Object> param) throws BottomUpException {
        return this.prescriptionNextVisitMapper.getByParam(param);
    }

    public void delete (Map<String,Object> param) throws BottomUpException {
        this.prescriptionNextVisitMapper.delete(param);
    }
}
