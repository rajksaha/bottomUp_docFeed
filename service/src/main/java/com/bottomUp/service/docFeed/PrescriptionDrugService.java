package com.bottomUp.service.docFeed;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.AppointmentTypeData;
import com.bottomUp.domain.PrescriptionDrugData;
import com.bottomUp.myBatis.persistence.AppointmentTypeMapper;
import com.bottomUp.myBatis.persistence.PrescriptionDrugMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by raj on 09/08/2020.
 */

@Service
public class PrescriptionDrugService {

    @Autowired
    private PrescriptionDrugMapper prescriptionDrugMapper;

    public void create(PrescriptionDrugData data) throws BottomUpException {
        prescriptionDrugMapper.create(data);
    }

    public void update(PrescriptionDrugData data) throws BottomUpException {
        prescriptionDrugMapper.update(data);
    }

    public PrescriptionDrugData getByID(Long ID)throws BottomUpException {
        return this.prescriptionDrugMapper.getByID(ID);
    }

    public List<PrescriptionDrugData> getByParam(Map<String, Object> param) throws BottomUpException {
        return this.prescriptionDrugMapper.getByParam(param);
    }

    public void delete (Map<String,Object> param) throws BottomUpException {
        this.prescriptionDrugMapper.delete(param);
    }
}
