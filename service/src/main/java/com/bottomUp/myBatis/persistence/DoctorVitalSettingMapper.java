package com.bottomUp.myBatis.persistence;


import com.bottomUp.common.exception.BottomUpException;

import com.bottomUp.domain.DoctorVitalSettingData;

import java.util.List;
import java.util.Map;

/**
 * Created by raj on 09/08/2020.
 */
public interface DoctorVitalSettingMapper {

    public DoctorVitalSettingData create(DoctorVitalSettingData data) throws BottomUpException;

    public DoctorVitalSettingData update(DoctorVitalSettingData data) throws BottomUpException;

    public DoctorVitalSettingData getByID(Long ID) throws BottomUpException;

    public List<DoctorVitalSettingData> getByParam(Map<String, Object> param) throws BottomUpException;

    public void delete(Map<String, Object> param) throws BottomUpException;
}
