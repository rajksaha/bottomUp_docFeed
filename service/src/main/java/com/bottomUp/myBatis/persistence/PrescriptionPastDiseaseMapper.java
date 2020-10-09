package com.bottomUp.myBatis.persistence;


import com.bottomUp.common.exception.BottomUpException;

import com.bottomUp.domain.PrescriptionPastDiseaseData;

import java.util.List;
import java.util.Map;

/**
 * Created by raj on 09/08/2020.
 */
public interface PrescriptionPastDiseaseMapper {

    public PrescriptionPastDiseaseData create(PrescriptionPastDiseaseData data) throws BottomUpException;

    public PrescriptionPastDiseaseData update(PrescriptionPastDiseaseData data) throws BottomUpException;

    public PrescriptionPastDiseaseData getByID(Long ID) throws BottomUpException;

    public List<PrescriptionPastDiseaseData> getByParam(Map<String, Object> param) throws BottomUpException;

    public void delete(Map<String, Object> param) throws BottomUpException;
}
