package com.bottomUp.myBatis.persistence;


import com.bottomUp.common.exception.BottomUpException;

import com.bottomUp.domain.PatientDetailData;

import java.util.List;
import java.util.Map;

/**
 * Created by raj on 09/08/2020.
 */
public interface PatientDetailMapper {

    public void create(PatientDetailData data) throws BottomUpException;

    public void update(PatientDetailData data) throws BottomUpException;

    public PatientDetailData getByID(String ID) throws BottomUpException;

    public List<PatientDetailData> getByParam(Map<String, Object> param) throws BottomUpException;

    public void delete(Map<String, Object> param) throws BottomUpException;
}
