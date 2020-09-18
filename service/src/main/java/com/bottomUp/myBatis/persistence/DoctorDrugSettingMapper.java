package com.bottomUp.myBatis.persistence;


import com.bottomUp.common.exception.BottomUpException;

import com.bottomUp.domain.DoctorDrugSettingData;

import java.util.List;
import java.util.Map;

/**
 * Created by raj on 09/08/2020.
 */
public interface DoctorDrugSettingMapper {

    public void create(DoctorDrugSettingData data) throws BottomUpException;

    public void update(DoctorDrugSettingData data) throws BottomUpException;

    public DoctorDrugSettingData getByID(Long ID) throws BottomUpException;

    public List<DoctorDrugSettingData> getByParam(Map<String, Object> param) throws BottomUpException;

    public void delete(Map<String, Object> param) throws BottomUpException;
}
