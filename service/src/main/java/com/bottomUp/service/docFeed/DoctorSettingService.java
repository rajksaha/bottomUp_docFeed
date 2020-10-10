package com.bottomUp.service.docFeed;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.AppointmentTypeData;
import com.bottomUp.domain.DoctorSettingData;
import com.bottomUp.myBatis.persistence.AppointmentTypeMapper;
import com.bottomUp.myBatis.persistence.DoctorSettingMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by raj on 09/08/2020.
 */

@Service
public class DoctorSettingService {

    @Autowired
    private DoctorSettingMapper doctorSettingMapper;

    public void create(DoctorSettingData data) throws BottomUpException {
        doctorSettingMapper.create(data);
    }

    public void update(DoctorSettingData  data) throws BottomUpException {
        doctorSettingMapper.update(data);
    }

    public DoctorSettingData  getByID(Long ID)throws BottomUpException {
        return this.doctorSettingMapper.getByID(ID);
    }

    public List<DoctorSettingData > getByParam(Map<String, Object> param) throws BottomUpException {
        return this.doctorSettingMapper.getByParam(param);
    }

    public void delete (Map<String,Object> param) throws BottomUpException {
        this.doctorSettingMapper.delete(param);
    }
}
