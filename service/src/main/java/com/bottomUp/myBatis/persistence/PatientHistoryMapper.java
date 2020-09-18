package com.bottomUp.myBatis.persistence;


import com.bottomUp.common.exception.BottomUpException;

import com.bottomUp.domain.PatientHistoryData;

import java.util.List;
import java.util.Map;

/**
 * Created by raj on 09/08/2020.
 */
public interface PatientHistoryMapper {

    public void create(PatientHistoryData data) throws BottomUpException;

    public void update(PatientHistoryData data) throws BottomUpException;

    public PatientHistoryData getByID(Long ID) throws BottomUpException;

    public List<PatientHistoryData> getByParam(Map<String, Object> param) throws BottomUpException;

    public void delete(Map<String, Object> param) throws BottomUpException;
}
