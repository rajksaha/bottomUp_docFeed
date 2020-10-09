package com.bottomUp.myBatis.persistence;


import com.bottomUp.common.exception.BottomUpException;

import com.bottomUp.domain.DoctorDrugDiseaseTemplateData;

import java.util.List;
import java.util.Map;

/**
 * Created by raj on 09/08/2020.
 */
public interface DoctorDrugDiseaseTemplateMapper {

    public DoctorDrugDiseaseTemplateData create(DoctorDrugDiseaseTemplateData data) throws BottomUpException;

    public DoctorDrugDiseaseTemplateData update(DoctorDrugDiseaseTemplateData data) throws BottomUpException;

    public DoctorDrugDiseaseTemplateData getByID(Long ID) throws BottomUpException;

    public List<DoctorDrugDiseaseTemplateData> getByParam(Map<String, Object> param) throws BottomUpException;

    public void delete(Map<String, Object> param) throws BottomUpException;
}
