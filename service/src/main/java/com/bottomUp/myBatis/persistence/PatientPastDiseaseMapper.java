package com.bottomUp.myBatis.persistence;


import com.bottomUp.common.exception.BottomUpException;

import com.bottomUp.domain.PatientPastDiseaseData;

import java.util.List;
import java.util.Map;

/**
 * Created by raj on 09/08/2020.
 */
public interface PatientPastDiseaseMapper {

    public void create(PatientPastDiseaseData data) throws BottomUpException;

    public void update(PatientPastDiseaseData data) throws BottomUpException;

    public PatientPastDiseaseData getByID(Long ID) throws BottomUpException;

    public List<PatientPastDiseaseData> getByParam(Map<String, Object> param) throws BottomUpException;

    public void delete(Map<String, Object> param) throws BottomUpException;
}
