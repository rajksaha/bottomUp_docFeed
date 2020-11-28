package com.bottomUp.service.docFeed.crud;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.AppointmentTypeData;
import com.bottomUp.domain.DoctorDrugDoseSettingData;
import com.bottomUp.domain.DoctorDrugSettingData;
import com.bottomUp.myBatis.persistence.AppointmentTypeMapper;
import com.bottomUp.myBatis.persistence.DoctorDrugDoseSettingMapper;
import com.bottomUp.myBatis.persistence.DoctorDrugSettingMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Autowired
    private DoctorDrugDoseSettingMapper doctorDrugDoseSettingMapper;

    public void create(DoctorDrugSettingData data) throws BottomUpException {
        doctorDrugSettingMapper.create(data);
        if(data.getPeriodList() != null){
            this.createDrugDoseSetting(data);
        }
    }

    public void createDrugDoseSetting(DoctorDrugSettingData data) throws BottomUpException{
        for (DoctorDrugDoseSettingData period: data.getPeriodList()){
            period.setDrugSettingID(data.getDrugSettingID());
            doctorDrugDoseSettingMapper.create(period);
        }
    }

    public void update(DoctorDrugSettingData data) throws BottomUpException {
        doctorDrugSettingMapper.update(data);
        if(data.getPeriodList() != null){
            Map<String, Object> param = new HashMap<String, Object>();
            param.put("drugSettingID", data.getDrugSettingID());
            doctorDrugDoseSettingMapper.delete(param);
            this.createDrugDoseSetting(data);
        }
    }

    public DoctorDrugSettingData getByID(Long ID)throws BottomUpException {
        return this.doctorDrugSettingMapper.getByID(ID);
    }

    public DoctorDrugSettingData getByDrugID(Long drugID)throws BottomUpException {
        return this.doctorDrugSettingMapper.getByDrugID(drugID);
    }

    public Integer getDoctorDrugCount(Long doctorID, Long drugID)throws BottomUpException {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("doctorID", doctorID);
        param.put("doctorID", drugID);
        return this.doctorDrugSettingMapper.getDoctorDrugCount(param);
    }

    public DoctorDrugSettingData getDoctorDrug(Long doctorID, Long drugID)throws BottomUpException {
        DoctorDrugSettingData doctorDrugSettingData = null;
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("doctorID", doctorID);
        param.put("doctorID", drugID);

        List<DoctorDrugSettingData> doctorDrugSettingList =  this.doctorDrugSettingMapper.getByParam(param);
        if(doctorDrugSettingList != null && doctorDrugSettingList.size() > 0){
            doctorDrugSettingData = doctorDrugSettingList.get(0);
            param.clear();
            param.put("drugSettingID", doctorDrugSettingData.getDrugSettingID());
            doctorDrugSettingData.setPeriodList(doctorDrugDoseSettingMapper.getByParam(param));
        }
        return doctorDrugSettingData;
    }

    public List<DoctorDrugSettingData> getByParam(Map<String, Object> param) throws BottomUpException {
        return this.doctorDrugSettingMapper.getByParam(param);
    }

    public void delete (Map<String,Object> param) throws BottomUpException {
        this.doctorDrugSettingMapper.delete(param);
    }
    public DoctorDrugSettingData getDrugDefaultSetup(Long doctorID, Long drugID)throws BottomUpException {
        DoctorDrugSettingData doctorDrugSettingData = this.getDoctorDrug(doctorID, drugID);
        if(doctorDrugSettingData == null){
            doctorDrugSettingData = this.doctorDrugSettingMapper.getByDrugID(drugID);
            if(doctorDrugSettingData != null){
                Map<String, Object> param = new HashMap<String, Object>();
                param.clear();
                param.put("drugSettingID", doctorDrugSettingData.getDrugSettingID());
                doctorDrugSettingData.setPeriodList(doctorDrugDoseSettingMapper.getByParam(param));
            }
        }
        return doctorDrugSettingData;
    }
}
