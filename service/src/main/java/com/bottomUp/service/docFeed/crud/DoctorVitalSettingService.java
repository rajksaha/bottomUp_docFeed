package com.bottomUp.service.docFeed.crud;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.AppointmentTypeData;
import com.bottomUp.domain.DoctorVitalSettingData;
import com.bottomUp.myBatis.persistence.AppointmentTypeMapper;
import com.bottomUp.myBatis.persistence.DoctorVitalSettingMapper;
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
public class DoctorVitalSettingService {

    @Autowired
    private DoctorVitalSettingMapper doctorVitalSettingMapper;

    @Autowired
    private ContentVitalService contentVitalService;

    public void create(DoctorVitalSettingData data) throws BottomUpException {
        if(data.getVitalID() == null){
            data.setVitalID(contentVitalService.getInsert(data));
        }
        doctorVitalSettingMapper.create(data);
    }

    public void update(DoctorVitalSettingData data) throws BottomUpException {
        doctorVitalSettingMapper.update(data);
    }

    public DoctorVitalSettingData getByID(String ID)throws BottomUpException {
        return this.doctorVitalSettingMapper.getByID(ID);
    }

    public List<DoctorVitalSettingData> getByParam(Map<String, Object> param) throws BottomUpException {
        return this.doctorVitalSettingMapper.getByParam(param);
    }

    public void delete (Map<String,Object> param) throws BottomUpException {
        this.doctorVitalSettingMapper.delete(param);
    }

    public List<DoctorVitalSettingData> getByDoctorParam(Map<String, Object> param) throws BottomUpException{
        return this.doctorVitalSettingMapper.getByDoctorParam(param);
    }
}
