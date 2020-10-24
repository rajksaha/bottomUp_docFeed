package com.bottomUp.service.docFeed.crud;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.AppointmentTypeData;
import com.bottomUp.domain.DoctorDrugDoseSettingData;
import com.bottomUp.myBatis.persistence.AppointmentTypeMapper;
import com.bottomUp.myBatis.persistence.DoctorDrugDoseSettingMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by raj on 09/08/2020.
 */

@Service
public class DoctorDrugDoseSettingService {

    @Autowired
    private DoctorDrugDoseSettingMapper doctorDrugDoseSettingMapper;

    public void create(DoctorDrugDoseSettingData data) throws BottomUpException {
        doctorDrugDoseSettingMapper.create(data);
    }

    public void update(DoctorDrugDoseSettingData data) throws BottomUpException {
        doctorDrugDoseSettingMapper.update(data);
    }

    public DoctorDrugDoseSettingData getByID(Long ID)throws BottomUpException {
        return this.doctorDrugDoseSettingMapper.getByID(ID);
    }

    public List<DoctorDrugDoseSettingData> getByParam(Map<String, Object> param) throws BottomUpException {
        return this.doctorDrugDoseSettingMapper.getByParam(param);
    }

    public void delete (Map<String,Object> param) throws BottomUpException {
        this.doctorDrugDoseSettingMapper.delete(param);
    }
}
