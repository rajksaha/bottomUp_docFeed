package com.bottomUp.service.docFeed;

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

    public DoctorDrugDoseSettingData create(DoctorDrugDoseSettingData data) throws BottomUpException {
        return this.doctorDrugDoseSettingMapper.create(data);
    }

    public DoctorDrugDoseSettingData update(DoctorDrugDoseSettingData data) throws BottomUpException {
        return this.doctorDrugDoseSettingMapper.update(data);
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
