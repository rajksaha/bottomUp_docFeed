package com.bottomUp.service.docFeed.crud;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.*;
import com.bottomUp.myBatis.persistence.*;
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
public class DrugDefaultSetupService {

    @Autowired
    private DrugDefaultSetupMapper drugDefaultSetupMapper;

    @Autowired
    private DoctorDrugSettingMapper doctorDrugSettingMapper;

    public void create(DrugDefaultSetupData data) throws BottomUpException {
        if(data.getPeriodList() != null){
            data.setDoseString(JsonConverter.convertListToJson(data.getPeriodList(), false));
        }
        if(data.getDoctorID() == null){
            Boolean isUpdate = true;
            if(data.getEntryType().equalsIgnoreCase("REG")&& data.getGenericID() != null){
                data.setDrugID(data.getGenericID());
                isUpdate = false;
            }
            this.processGeneric(data, isUpdate);

        }else if(data.getDoctorID() != null){
            if(data.getEntryType().equalsIgnoreCase("REG")){
                if(data.getGenericID() == null){
                    data.setDrugID(data.getGenericID());
                    drugDefaultSetupMapper.create(data);
                    this.processGeneric(data, false);
                }else{
                    doctorDrugSettingMapper.create(data);
                }
            }else{
                drugDefaultSetupMapper.create(data);
                this.processGeneric(data, false);
            }
        }
    }

    private void processGeneric(DrugDefaultSetupData data, Boolean isUpdate) throws BottomUpException{
        if(data.getDrugID() == null){
            return;
        }
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("drugID", data.getDrugID());
        DrugDefaultSetupData setup = drugDefaultSetupMapper.getSingleByParam(params);
        if(setup == null){
            data.setDrugSettingID(null);
            data.setDoctorID(null);
            drugDefaultSetupMapper.create(data);
        }else if(isUpdate){
            setup.setDoseTypeCode(data.getDoseTypeCode());
            setup.setDrugDoseUnit(data.getDrugDoseUnit());
            setup.setDrugWhenID(data.getDrugWhenID());
            setup.setDrugAdviceID(data.getDrugAdviceID());
            setup.setDoseString(data.getDoseString());
            drugDefaultSetupMapper.update(setup);
        }
    }

    public void update(DrugDefaultSetupData data) throws BottomUpException {
        if(data.getPeriodList() != null){
            data.setDoseString(JsonConverter.convertListToJson(data.getPeriodList(), false));
        }
        if(data.getDoctorID() == null){
            Boolean isUpdate = true;
            if(data.getEntryType().equalsIgnoreCase("REG")&& data.getGenericID() != null){
                data.setDrugID(data.getGenericID());
                isUpdate = false;
            }
            this.processGeneric(data, isUpdate);

        }else if(data.getDoctorID() != null){
            if(data.getEntryType().equalsIgnoreCase("REG")){
                if(data.getGenericID() == null){
                    data.setDrugID(data.getGenericID());
                    drugDefaultSetupMapper.update(data);
                    this.processGeneric(data, false);
                }else{
                    doctorDrugSettingMapper.update(data);
                }
            }else{
                drugDefaultSetupMapper.update(data);
                this.processGeneric(data, false);
            }
        }
    }

    public DrugDefaultSetupData getDrugDefaultSetup(Long doctorID, Long drugID, Long genericID)throws BottomUpException {
        DrugDefaultSetupData setup = null;
        Map<String, Object> params = new HashMap<String, Object>();
        if(doctorID != null && drugID != null){
            params.put("doctorID", doctorID);
            params.put("drugID", drugID);
            setup =  doctorDrugSettingMapper.getByDoctorAndDrug(params);
        }
        if(setup == null && genericID != null){
            params.put("doctorID", doctorID);
            params.put("drugID", genericID);
            setup = drugDefaultSetupMapper.getSingleByParam(params);
        }
        if(setup != null && setup.getDoseString() != null){
            setup.setPeriodList(JsonConverter.convertJsonToList(setup.getDoseString(),DoseData.class));
            setup.setGenericID(genericID);
        }
        return setup;
    }

    public DrugDefaultSetupData getGenericDefaultSetup(Long doctorID, Long genericID)throws BottomUpException {
        DrugDefaultSetupData setup = null;
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("doctorID", doctorID);
        params.put("drugID", genericID);
        setup = drugDefaultSetupMapper.getSingleByParam(params);
        if(setup != null && setup.getDoseString() != null){
            setup.setPeriodList(JsonConverter.convertJsonToList(setup.getDoseString(),DoseData.class));
            setup.setGenericID(genericID);
        }
        return setup;
    }

    public DrugDefaultSetupData getByID(Long ID)throws BottomUpException {
        return drugDefaultSetupMapper.getByID(ID);
    }


    public List<DrugDefaultSetupData> getByParam(Map<String, Object> param) throws BottomUpException {
        List<DrugDefaultSetupData> setupList = drugDefaultSetupMapper.getByParam(param);
        for (DrugDefaultSetupData setup : setupList){
            setup.setPeriodList(JsonConverter.convertJsonToList(setup.getDoseString(),DoseData.class));
        }
        return setupList;
    }

    public void delete (Map<String,Object> param) throws BottomUpException {
        this.drugDefaultSetupMapper.delete(param);
    }

    public Map<String,Object> getReqContent() throws BottomUpException {
        Map<String, Object> param = new HashMap<String, Object>();
        /*param.put("drugTypeList", contentDrugTypeMapper.getByParam(null));
        param.put("drugWhenTypeList", contentWhenTypeMapper.getByParam(null));
        param.put("drugAdviceTypeList", contentDrugAdviceMapper.getByParam(null));
        param.put("doseTypeList", contentDoseTypeMapper.getByParam(null));
        param.put("durationTypeList", contentDurationTypeMapper.getByParam(null));*/
        return param;
    }
}
