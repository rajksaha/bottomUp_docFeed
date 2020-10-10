package com.bottomUp.myBatis.persistence;


import com.bottomUp.common.exception.BottomUpException;

import com.bottomUp.domain.PatientData;

import java.util.List;
import java.util.Map;

/**
 * Created by raj on 09/08/2020.
 */
public interface PatientMapper {

    public void create(PatientData data) throws BottomUpException;

    public void update(PatientData data) throws BottomUpException;

    public PatientData getByID(Long ID) throws BottomUpException;

    public List<PatientData> getByParam(Map<String, Object> param) throws BottomUpException;

    public void delete(Map<String, Object> param) throws BottomUpException;
}
