package com.bottomUp.myBatis.persistence;


import com.bottomUp.common.exception.BottomUpException;

import com.bottomUp.domain.PatientFamilyHistoryData;

import java.util.List;
import java.util.Map;

/**
 * Created by raj on 09/08/2020.
 */
public interface PatientFamilyHistoryMapper {

    public void create(PatientFamilyHistoryData data) throws BottomUpException;

    public void update(PatientFamilyHistoryData data) throws BottomUpException;

    public PatientFamilyHistoryData getByID(Long ID) throws BottomUpException;

    public List<PatientFamilyHistoryData> getByParam(Map<String, Object> param) throws BottomUpException;

    public void delete(Map<String, Object> param) throws BottomUpException;
}
