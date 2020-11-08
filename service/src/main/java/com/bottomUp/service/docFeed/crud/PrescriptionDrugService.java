package com.bottomUp.service.docFeed.crud;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.AppointmentTypeData;
import com.bottomUp.domain.PrescriptionDrugData;
import com.bottomUp.myBatis.persistence.AppointmentTypeMapper;
import com.bottomUp.myBatis.persistence.PrescriptionDrugDoseMapper;
import com.bottomUp.myBatis.persistence.PrescriptionDrugMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by raj on 09/08/2020.
 */

@Service
public class PrescriptionDrugService {

    @Autowired
    private PrescriptionDrugMapper prescriptionDrugMapper;

    @Autowired
    private PrescriptionDrugDoseMapper prescriptionDrugDoseMapper;

    public void create(PrescriptionDrugData data) throws BottomUpException {
        prescriptionDrugMapper.create(data);
    }

    public void update(PrescriptionDrugData data) throws BottomUpException {
        prescriptionDrugMapper.update(data);
    }

    public PrescriptionDrugData getByID(Long ID)throws BottomUpException {
        PrescriptionDrugData drugData = this.prescriptionDrugMapper.getByID(ID);
        if(drugData != null){
            Map<String, Object> param = new HashMap<String, Object>();
            param.put("presDrugID", drugData.getPresDrugID());
            drugData.setDoseList(prescriptionDrugDoseMapper.getByParam(param));
        }
        return drugData;
    }

    public List<PrescriptionDrugData> getByParam(Map<String, Object> param) throws BottomUpException {
        List<PrescriptionDrugData> presDrugList = this.prescriptionDrugMapper.getByParam(param);
        for(PrescriptionDrugData presDrug : presDrugList){
            if(presDrug != null){
                Map<String, Object> innerParam = new HashMap<String, Object>();
                param.put("presDrugID", presDrug.getPresDrugID());
                presDrug.setDoseList(prescriptionDrugDoseMapper.getByParam(innerParam));
            }
        }
        return presDrugList;
    }

    public void delete (Map<String,Object> param) throws BottomUpException {
        this.prescriptionDrugMapper.delete(param);
    }
}
