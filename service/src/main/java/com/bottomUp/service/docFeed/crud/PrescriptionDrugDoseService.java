package com.bottomUp.service.docFeed.crud;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.AppointmentTypeData;
import com.bottomUp.domain.PrescriptionDrugDoseData;
import com.bottomUp.myBatis.persistence.AppointmentTypeMapper;
import com.bottomUp.myBatis.persistence.PrescriptionDrugDoseMapper;
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
public class PrescriptionDrugDoseService {

    @Autowired
    private PrescriptionDrugDoseMapper prescriptionDrugDoseMapper;

    public void create(PrescriptionDrugDoseData data) throws BottomUpException {
        prescriptionDrugDoseMapper.create(data);
    }

    public void update(PrescriptionDrugDoseData data) throws BottomUpException {
        prescriptionDrugDoseMapper.update(data);
    }

    public PrescriptionDrugDoseData getByID(Long ID)throws BottomUpException {
        return this.prescriptionDrugDoseMapper.getByID(ID);
    }

    public List<PrescriptionDrugDoseData> getByParam(Map<String, Object> param) throws BottomUpException {
        return this.prescriptionDrugDoseMapper.getByParam(param);
    }

    public void delete (Map<String,Object> param) throws BottomUpException {
        this.prescriptionDrugDoseMapper.delete(param);
    }
}
