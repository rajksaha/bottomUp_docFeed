package com.bottomUp.myBatis.persistence;


import com.bottomUp.common.exception.BottomUpException;

import com.bottomUp.domain.DrugDefaultSetupData;

import java.util.List;
import java.util.Map;

/**
 * Created by raj on 09/08/2020.
 */
public interface DoctorDrugSettingMapper {

    void create(DrugDefaultSetupData data) throws BottomUpException;

    void update(DrugDefaultSetupData data) throws BottomUpException;

    DrugDefaultSetupData getByID(Long ID) throws BottomUpException;

    DrugDefaultSetupData getByDoctorAndDrug(Map<String, Object> param) throws BottomUpException;

    List<DrugDefaultSetupData> getByParam(Map<String, Object> param)throws BottomUpException;

    void delete(Map<String, Object> param) throws BottomUpException;

    DrugDefaultSetupData getByDrugID(Long drugID) throws BottomUpException;

    Integer getDoctorDrugCount(Map<String, Object> param);
}
