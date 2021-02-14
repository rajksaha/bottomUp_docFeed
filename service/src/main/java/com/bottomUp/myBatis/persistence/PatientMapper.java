package com.bottomUp.myBatis.persistence;


import com.bottomUp.common.exception.BottomUpException;

import com.bottomUp.domain.PatientData;
import com.bottomUp.model.PatientViewData;

import java.util.List;
import java.util.Map;

/**
 * Created by raj on 09/08/2020.
 */
public interface PatientMapper {

    public void create(PatientData data) throws BottomUpException;

    public void update(PatientData data) throws BottomUpException;

    public void updatePatientType(PatientData data) throws BottomUpException;

    public void updatePatientImg(PatientData data) throws BottomUpException;

    public PatientViewData getByID(Long ID) throws BottomUpException;

    public List<PatientData> getByParam(Map<String, Object> param) throws BottomUpException;

    public List<PatientViewData> patientSearch(Map<String, Object> param) throws BottomUpException;

    public void delete(Map<String, Object> param) throws BottomUpException;
}
