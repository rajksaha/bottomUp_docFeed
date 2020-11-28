package com.bottomUp.myBatis.persistence;


import com.bottomUp.common.exception.BottomUpException;

import com.bottomUp.domain.DoctorDrugSettingData;

import java.util.List;
import java.util.Map;

/**
 * Created by raj on 09/08/2020.
 */
public interface DoctorDrugSettingMapper {

    void create(DoctorDrugSettingData data) throws BottomUpException;

    void update(DoctorDrugSettingData data) throws BottomUpException;

    DoctorDrugSettingData getByID(Long ID) throws BottomUpException;

    List<DoctorDrugSettingData> getByParam(Map<String, Object> param)throws BottomUpException;

    void delete(Map<String, Object> param) throws BottomUpException;

    DoctorDrugSettingData getByDrugID(Long drugID) throws BottomUpException;

    Integer getDoctorDrugCount(Map<String, Object> param);
}
