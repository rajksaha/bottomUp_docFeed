package com.bottomUp.service.docFeed;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.AppointmentTypeData;
import com.bottomUp.domain.PrescriptionVitalData;
import com.bottomUp.myBatis.persistence.AppointmentTypeMapper;
import com.bottomUp.myBatis.persistence.PrescriptionVitalMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by raj on 09/08/2020.
 */

@Service
public class PrescriptionVitalService {

    @Autowired
    private PrescriptionVitalMapper prescriptionVitalMapper;

    public void create(PrescriptionVitalData data) throws BottomUpException {
        prescriptionVitalMapper.create(data);
    }

    public void update(PrescriptionVitalData data) throws BottomUpException {
        prescriptionVitalMapper.update(data);
    }

    public PrescriptionVitalData getByID(Long ID)throws BottomUpException {
        return this.prescriptionVitalMapper.getByID(ID);
    }

    public List<PrescriptionVitalData> getByParam(Map<String, Object> param) throws BottomUpException {
        return this.prescriptionVitalMapper.getByParam(param);
    }

    public void delete (Map<String,Object> param) throws BottomUpException {
        this.prescriptionVitalMapper.delete(param);
    }
}
