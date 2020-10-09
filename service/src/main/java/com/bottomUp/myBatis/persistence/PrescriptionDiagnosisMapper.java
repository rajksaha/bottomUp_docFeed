package com.bottomUp.myBatis.persistence;


import com.bottomUp.common.exception.BottomUpException;

import com.bottomUp.domain.PrescriptionDiagnosisData;

import java.util.List;
import java.util.Map;

/**
 * Created by raj on 09/08/2020.
 */
public interface PrescriptionDiagnosisMapper {

    public PrescriptionDiagnosisData create(PrescriptionDiagnosisData data) throws BottomUpException;

    public PrescriptionDiagnosisData update(PrescriptionDiagnosisData data) throws BottomUpException;

    public PrescriptionDiagnosisData getByID(Long ID) throws BottomUpException;

    public List<PrescriptionDiagnosisData> getByParam(Map<String, Object> param) throws BottomUpException;

    public void delete(Map<String, Object> param) throws BottomUpException;
}
