package com.bottomUp.myBatis.persistence;


import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.AppointmentData;
import com.bottomUp.domain.DoctorHistorySettingData;

import java.util.List;
import java.util.Map;

/**
 * Created by raj on 09/08/2020.
 */
public interface DoctorHistorySettingMapper {

    public void create(DoctorHistorySettingData data) throws BottomUpException;

    public void update(DoctorHistorySettingData data) throws BottomUpException;

    public DoctorHistorySettingData getByID(String ID) throws BottomUpException;

    public List<DoctorHistorySettingData> getByParam(Map<String, Object> param) throws BottomUpException;

    public void delete(Map<String, Object> param) throws BottomUpException;
}
