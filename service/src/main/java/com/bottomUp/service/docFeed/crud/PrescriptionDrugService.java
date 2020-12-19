package com.bottomUp.service.docFeed.crud;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.*;
import com.bottomUp.myBatis.persistence.*;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
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
    private PrescriptionDrugDoseMapper prescriptionDrugDoseMapper;

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

    @Autowired
    private DoctorDrugDoseSettingMapper doctorDrugDoseSettingMapper;

    public void save(PrescriptionDrugData drugData) throws BottomUpException {
        //TODO:Drug Name

        //Save drug
        if(drugData.getPresDrugID() == null){
            prescriptionDrugMapper.create(drugData);
        }else{
            prescriptionDrugMapper.update(drugData);
            Map<String, Object> param = new HashMap<String, Object>();
            param.put("presDrugID", drugData.getPresDrugID());
            prescriptionDrugDoseMapper.delete(param);
        }
        //save dose
        if(drugData.getPeriodList() != null){
            for (PrescriptionDrugDoseData period: drugData.getPeriodList()){
                period.setPresDrugID(drugData.getPresDrugID());
                prescriptionDrugDoseMapper.create(period);
            }
        }

        //TODO:create Async Service
        Map<String, Object> setupParam = new HashMap<String, Object>();
        setupParam.put("doctorID", drugData.getDoctorID());
        setupParam.put("doctorID", drugData.getDrugID());
        if(doctorDrugSettingMapper.getDoctorDrugCount(setupParam) == 0){
            DoctorDrugSettingData doctorDrugSettingData = new DoctorDrugSettingData();
            ModelMapper modelMapper = new ModelMapper();
            modelMapper.getConfiguration().setSkipNullEnabled(true).setMatchingStrategy(MatchingStrategies.STRICT);
            modelMapper.map(drugData, doctorDrugSettingData);
            doctorDrugSettingMapper.create(doctorDrugSettingData);
            for (PrescriptionDrugDoseData period: drugData.getPeriodList()){
                DoctorDrugDoseSettingData doseSettingData = new DoctorDrugDoseSettingData();
                modelMapper.map(period, doseSettingData);
                doseSettingData.setDrugSettingID(doctorDrugSettingData.getDrugSettingID());
                doctorDrugDoseSettingMapper.create(doseSettingData);
            }
        }
    }

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
            drugData.setPeriodList(prescriptionDrugDoseMapper.getByParam(param));
        }
        return drugData;
    }

    public List<PrescriptionDrugData> getByParam(Map<String, Object> param) throws BottomUpException {
        List<PrescriptionDrugData> presDrugList = this.prescriptionDrugMapper.getByParam(param);
        for(PrescriptionDrugData presDrug : presDrugList){
            if(presDrug != null){
                Map<String, Object> innerParam = new HashMap<String, Object>();
                innerParam.put("presDrugID", presDrug.getPresDrugID());
                presDrug.setPeriodList(prescriptionDrugDoseMapper.getByParam(innerParam));
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
