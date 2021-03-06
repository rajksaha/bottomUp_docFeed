package com.bottomUp.myBatis.persistence;


import com.bottomUp.common.exception.BottomUpException;

import com.bottomUp.domain.PrescriptionDiagnosisData;

import java.util.List;
import java.util.Map;

/**
 * Created by raj on 09/08/2020.
 */
public interface PrescriptionDiagnosisMapper {

    public void create(PrescriptionDiagnosisData data) throws BottomUpException;

    public void selectInsert(Map<String, Object> param) throws BottomUpException;

    public void update(PrescriptionDiagnosisData data) throws BottomUpException;

    public PrescriptionDiagnosisData getByID(String ID) throws BottomUpException;

    public PrescriptionDiagnosisData getByAppointmentID(String getByAppointmentID) throws BottomUpException;

    public List<PrescriptionDiagnosisData> getByParam(Map<String, Object> param) throws BottomUpException;

    public void delete(Map<String, Object> param) throws BottomUpException;
}
