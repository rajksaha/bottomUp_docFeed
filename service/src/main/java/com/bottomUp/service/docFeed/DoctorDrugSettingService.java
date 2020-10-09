package com.bottomUp.service.docFeed;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.AppointmentTypeData;
import com.bottomUp.domain.DoctorDrugDoseSettingData;
import com.bottomUp.domain.DoctorDrugSettingData;
import com.bottomUp.myBatis.persistence.AppointmentTypeMapper;
import com.bottomUp.myBatis.persistence.DoctorDrugSettingMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by raj on 09/08/2020.
 */

@Service
public class DoctorDrugSettingService {

    @Autowired
    private DoctorDrugSettingMapper doctorDrugSettingMapper;

    public DoctorDrugSettingData create(DoctorDrugSettingData data) throws BottomUpException {
        return this.doctorDrugSettingMapper.create(data);
    }

    public DoctorDrugSettingData update(DoctorDrugSettingData data) throws BottomUpException {
        return this.doctorDrugSettingMapper.update(data);
    }

    public DoctorDrugSettingData getByID(Long ID)throws BottomUpException {
        return this.doctorDrugSettingMapper.getByID(ID);
    }

    public List<DoctorDrugSettingData> getByParam(Map<String, Object> param) throws BottomUpException {
        return this.doctorDrugSettingMapper.getByParam(param);
    }

    public void delete (Map<String,Object> param) throws BottomUpException {
        this.doctorDrugSettingMapper.delete(param);
    }
}
