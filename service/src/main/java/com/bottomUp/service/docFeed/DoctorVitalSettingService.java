package com.bottomUp.service.docFeed;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.AppointmentTypeData;
import com.bottomUp.domain.DoctorVitalSettingData;
import com.bottomUp.myBatis.persistence.AppointmentTypeMapper;
import com.bottomUp.myBatis.persistence.DoctorVitalSettingMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by raj on 09/08/2020.
 */

@Service
public class DoctorVitalSettingService {

    @Autowired
    private DoctorVitalSettingMapper doctorVitalSettingMapper;

    public void create(DoctorVitalSettingData data) throws BottomUpException {
        doctorVitalSettingMapper.create(data);
    }

    public void update(DoctorVitalSettingData data) throws BottomUpException {
        doctorVitalSettingMapper.update(data);
    }

    public DoctorVitalSettingData getByID(Long ID)throws BottomUpException {
        return this.doctorVitalSettingMapper.getByID(ID);
    }

    public List<DoctorVitalSettingData> getByParam(Map<String, Object> param) throws BottomUpException {
        return this.doctorVitalSettingMapper.getByParam(param);
    }

    public void delete (Map<String,Object> param) throws BottomUpException {
        this.doctorVitalSettingMapper.delete(param);
    }
}
