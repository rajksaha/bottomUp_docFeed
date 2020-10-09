package com.bottomUp.service.docFeed;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.AppointmentTypeData;
import com.bottomUp.domain.DoctorFollowUpSettingData;
import com.bottomUp.myBatis.persistence.AppointmentTypeMapper;
import com.bottomUp.myBatis.persistence.DoctorFollowUpSettingMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by raj on 09/08/2020.
 */

@Service
public class DoctorFollowUpSettingService {

    @Autowired
    private DoctorFollowUpSettingMapper doctorFollowUpSettingMapper;

    public DoctorFollowUpSettingData create(DoctorFollowUpSettingData data) throws BottomUpException {
        return this.doctorFollowUpSettingMapper.create(data);
    }

    public DoctorFollowUpSettingData update(DoctorFollowUpSettingData data) throws BottomUpException {
        return this.doctorFollowUpSettingMapper.update(data);
    }

    public DoctorFollowUpSettingData getByID(Long ID)throws BottomUpException {
        return this.doctorFollowUpSettingMapper.getByID(ID);
    }

    public List<DoctorFollowUpSettingData> getByParam(Map<String, Object> param) throws BottomUpException {
        return this.doctorFollowUpSettingMapper.getByParam(param);
    }

    public void delete (Map<String,Object> param) throws BottomUpException {
        this.doctorFollowUpSettingMapper.delete(param);
    }
}
