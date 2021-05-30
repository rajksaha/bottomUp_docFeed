package com.bottomUp.service.docFeed.crud;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.DoseData;
import com.bottomUp.domain.DrugDefaultSetupData;
import com.bottomUp.myBatis.persistence.DoctorDrugSettingMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import utility.JsonConverter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by raj on 09/08/2020.
 */

@Service
@Transactional
public class DoctorDrugSettingService {

    @Autowired
    private DoctorDrugSettingMapper doctorDrugSettingMapper;

    public void create(DrugDefaultSetupData data) throws BottomUpException {
        if(data.getPeriodList() != null){
            data.setDoseString(JsonConverter.convertListToJson(data.getPeriodList(), false));
        }
        doctorDrugSettingMapper.create(data);
    }

    public void update(DrugDefaultSetupData data) throws BottomUpException {
        if(data.getPeriodList() != null){
            data.setDoseString(JsonConverter.convertListToJson(data.getPeriodList(), false));
        }
        doctorDrugSettingMapper.update(data);
    }

    public DrugDefaultSetupData getByID(String ID)throws BottomUpException {
        return this.doctorDrugSettingMapper.getByID(ID);
    }

    public DrugDefaultSetupData getByDrugID(Long drugID)throws BottomUpException {
        return this.doctorDrugSettingMapper.getByDrugID(drugID);
    }

    public Integer getDoctorDrugCount(Long doctorID, Long drugID)throws BottomUpException {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("doctorID", doctorID);
        param.put("doctorID", drugID);
        return this.doctorDrugSettingMapper.getDoctorDrugCount(param);
    }

    public DrugDefaultSetupData getByDoctorAndDrug(Map<String, Object> param) throws BottomUpException{
        return this.doctorDrugSettingMapper.getByDoctorAndDrug(param);
    }

    public DrugDefaultSetupData getDoctorDrug(Long doctorID, Long drugID)throws BottomUpException {
        DrugDefaultSetupData doctorDrugSettingData = null;
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("doctorID", doctorID);
        param.put("drugID", drugID);

        List<DrugDefaultSetupData> doctorDrugSettingList =  this.doctorDrugSettingMapper.getByParam(param);
        if(doctorDrugSettingList != null && doctorDrugSettingList.size() > 0){
            doctorDrugSettingData = doctorDrugSettingList.get(0);
            doctorDrugSettingData.setPeriodList(JsonConverter.convertJsonToList(doctorDrugSettingData.getDoseString(),DoseData.class));
        }
        return doctorDrugSettingData;
    }

    public List<DrugDefaultSetupData> getByParam(Map<String, Object> param) throws BottomUpException {
        return this.doctorDrugSettingMapper.getByParam(param);
    }

    public void delete (Map<String,Object> param) throws BottomUpException {
        this.doctorDrugSettingMapper.delete(param);
    }
    public DrugDefaultSetupData getDrugDefaultSetup(Long doctorID, Long drugID)throws BottomUpException {
        DrugDefaultSetupData doctorDrugSettingData = this.getDoctorDrug(doctorID, drugID);
        if(doctorDrugSettingData == null){
            doctorDrugSettingData = this.doctorDrugSettingMapper.getByDrugID(drugID);
            if(doctorDrugSettingData != null){
                doctorDrugSettingData.setPeriodList(JsonConverter.convertJsonToList(doctorDrugSettingData.getDoseString(),DoseData.class));
            }
        }
        return doctorDrugSettingData;
    }
}
