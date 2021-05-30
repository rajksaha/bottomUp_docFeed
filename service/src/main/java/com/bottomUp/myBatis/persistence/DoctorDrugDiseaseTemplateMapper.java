package com.bottomUp.myBatis.persistence;


import com.bottomUp.common.exception.BottomUpException;

import com.bottomUp.domain.DoctorDrugDiseaseTemplateData;

import java.util.List;
import java.util.Map;

/**
 * Created by raj on 09/08/2020.
 */
public interface DoctorDrugDiseaseTemplateMapper {

    public void create(DoctorDrugDiseaseTemplateData data) throws BottomUpException;

    public void update(DoctorDrugDiseaseTemplateData data) throws BottomUpException;

    public DoctorDrugDiseaseTemplateData getByID(String ID) throws BottomUpException;

    public List<DoctorDrugDiseaseTemplateData> getByParam(Map<String, Object> param) throws BottomUpException;

    public void delete(Map<String, Object> param) throws BottomUpException;
}
