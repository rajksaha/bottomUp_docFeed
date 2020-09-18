package com.bottomUp.myBatis.persistence;


import com.bottomUp.common.exception.BottomUpException;

import com.bottomUp.domain.PatientTypeData;

import java.util.List;
import java.util.Map;

/**
 * Created by raj on 09/08/2020.
 */
public interface PatientTypeMapper {

    public void create(PatientTypeData data) throws BottomUpException;

    public void update(PatientTypeData data) throws BottomUpException;

    public PatientTypeData getByID(Long ID) throws BottomUpException;

    public List<PatientTypeData> getByParam(Map<String, Object> param) throws BottomUpException;

    public void delete(Map<String, Object> param) throws BottomUpException;
}
