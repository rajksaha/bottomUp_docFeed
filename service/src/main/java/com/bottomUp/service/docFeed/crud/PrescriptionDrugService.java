package com.bottomUp.service.docFeed.crud;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.*;
import com.bottomUp.myBatis.persistence.*;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
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
public class PrescriptionDrugService {

    @Autowired
    private PrescriptionDrugMapper prescriptionDrugMapper;

    @Autowired
    private ContentDrugTypeMapper contentDrugTypeMapper;

    @Autowired
    private ContentWhenTypeMapper contentWhenTypeMapper;

    @Autowired
    private ContentDoseTypeMapper contentDoseTypeMapper;

    @Autowired
    private ContentDrugAdviceMapper contentDrugAdviceMapper;

    @Autowired
    private ContentDurationTypeMapper contentDurationTypeMapper;

    @Autowired
    private DoctorDrugSettingMapper doctorDrugSettingMapper;

    public void save(PrescriptionDrugData drugData) throws BottomUpException {
        //TODO:Drug Name
        if(drugData.getPeriodList() != null){
            drugData.setDoseString(JsonConverter.convertListToJson(drugData.getPeriodList(), false));
        }
        //Save drug
        if(drugData.getPresDrugID() == null){
            prescriptionDrugMapper.create(drugData);
        }else{
            prescriptionDrugMapper.update(drugData);
        }

        if(drugData.getHasDefaultSetup() != null && drugData.getHasDefaultSetup().equals(0)){
            DrugDefaultSetupData drugDefaultSetupData = new DrugDefaultSetupData();
            ModelMapper modelMapper = new ModelMapper();
            modelMapper.getConfiguration().setSkipNullEnabled(true).setMatchingStrategy(MatchingStrategies.STRICT);
            modelMapper.map(drugData, drugDefaultSetupData);

            if(drugData.getGenericID() != null){
                //TODO://create in def setup
            }else{
                //TODO://create in doctor
            }
        }
    }

    public void create(PrescriptionDrugData data) throws BottomUpException {
        if(data.getPeriodList() != null){
            data.setDoseString(JsonConverter.convertListToJson(data.getPeriodList(), false));
        }
        prescriptionDrugMapper.create(data);
    }

    public void update(PrescriptionDrugData data) throws BottomUpException {
        if(data.getPeriodList() != null){
            data.setDoseString(JsonConverter.convertListToJson(data.getPeriodList(), false));
        }
        prescriptionDrugMapper.update(data);
    }

    public PrescriptionDrugData getByID(Long ID)throws BottomUpException {
        PrescriptionDrugData drugData = this.prescriptionDrugMapper.getByID(ID);
        if(drugData != null && drugData.getDoseString() != null){
            drugData.setPeriodList(JsonConverter.convertJsonToList(drugData.getDoseString(),DoseData.class));
        }
        return drugData;
    }

    public List<PrescriptionDrugData> getByParam(Map<String, Object> param) throws BottomUpException {
        List<PrescriptionDrugData> presDrugList = this.prescriptionDrugMapper.getByParam(param);
        for(PrescriptionDrugData presDrug : presDrugList){
            if(presDrug != null && presDrug.getDoseString() != null){
                presDrug.setPeriodList(JsonConverter.convertJsonToList(presDrug.getDoseString(),DoseData.class));
            }
        }
        return presDrugList;
    }

    public void delete (Map<String,Object> param) throws BottomUpException {
        this.prescriptionDrugMapper.delete(param);
    }

    public Map<String,Object> getReqContent() throws BottomUpException {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("drugTypeList", contentDrugTypeMapper.getByParam(null));
        param.put("drugWhenTypeList", contentWhenTypeMapper.getByParam(null));
        param.put("drugAdviceTypeList", contentDrugAdviceMapper.getByParam(null));
        param.put("doseTypeList", contentDoseTypeMapper.getByParam(null));
        param.put("durationTypeList", contentDurationTypeMapper.getByParam(null));
        return param;
    }
}
