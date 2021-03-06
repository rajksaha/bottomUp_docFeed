package com.bottomUp.myBatis.persistence;


import com.bottomUp.common.exception.BottomUpException;

import com.bottomUp.domain.DoctorSettingData;

import java.util.List;
import java.util.Map;

/**
 * Created by raj on 09/08/2020.
 */
public interface DoctorSettingMapper {

    public void create(DoctorSettingData data) throws BottomUpException;

    public void update(DoctorSettingData data) throws BottomUpException;

    public DoctorSettingData getByID(Long ID) throws BottomUpException;

    public DoctorSettingData getByDoctorID(String doctorID) throws BottomUpException;

    public List<DoctorSettingData> getByParam(Map<String, Object> param) throws BottomUpException;

    public void delete(Map<String, Object> param) throws BottomUpException;
}
