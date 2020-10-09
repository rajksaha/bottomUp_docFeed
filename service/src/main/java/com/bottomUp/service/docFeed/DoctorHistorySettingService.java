package com.bottomUp.service.docFeed;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.AppointmentTypeData;
import com.bottomUp.domain.DoctorHistorySettingData;
import com.bottomUp.myBatis.persistence.AppointmentTypeMapper;
import com.bottomUp.myBatis.persistence.DoctorHistorySettingMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by raj on 09/08/2020.
 */

@Service
public class DoctorHistorySettingService {

    @Autowired
    private DoctorHistorySettingMapper doctorHistorySettingMapper;

    public DoctorHistorySettingData create(DoctorHistorySettingData data) throws BottomUpException {
        return this.doctorHistorySettingMapper.create(data);
    }

    public DoctorHistorySettingData update(DoctorHistorySettingData data) throws BottomUpException {
        return this.doctorHistorySettingMapper.update(data);
    }

    public DoctorHistorySettingData getByID(Long ID)throws BottomUpException {
        return this.doctorHistorySettingMapper.getByID(ID);
    }

    public List<DoctorHistorySettingData> getByParam(Map<String, Object> param) throws BottomUpException {
        return this.doctorHistorySettingMapper.getByParam(param);
    }

    public void delete (Map<String,Object> param) throws BottomUpException {
        this.doctorHistorySettingMapper.delete(param);
    }
}
