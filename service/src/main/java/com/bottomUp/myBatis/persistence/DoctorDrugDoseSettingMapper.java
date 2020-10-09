package com.bottomUp.myBatis.persistence;


import com.bottomUp.common.exception.BottomUpException;

import com.bottomUp.domain.DoctorDrugDoseSettingData;

import java.util.List;
import java.util.Map;

/**
 * Created by raj on 09/08/2020.
 */
public interface DoctorDrugDoseSettingMapper {

    public DoctorDrugDoseSettingData create(DoctorDrugDoseSettingData data) throws BottomUpException;

    public DoctorDrugDoseSettingData update(DoctorDrugDoseSettingData data) throws BottomUpException;

    public DoctorDrugDoseSettingData getByID(Long ID) throws BottomUpException;

    public List<DoctorDrugDoseSettingData> getByParam(Map<String, Object> param) throws BottomUpException;

    public void delete(Map<String, Object> param) throws BottomUpException;
}
