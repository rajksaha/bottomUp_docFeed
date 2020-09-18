package com.bottomUp.myBatis.persistence;


import com.bottomUp.common.exception.BottomUpException;

import com.bottomUp.domain.DoctorInvDiseaseTemplateData;

import java.util.List;
import java.util.Map;

/**
 * Created by raj on 09/08/2020.
 */
public interface DoctorInvDiseaseTemplateMapper {

    public void create(DoctorInvDiseaseTemplateData data) throws BottomUpException;

    public void update(DoctorInvDiseaseTemplateData data) throws BottomUpException;

    public DoctorInvDiseaseTemplateData getByID(Long ID) throws BottomUpException;

    public List<DoctorInvDiseaseTemplateData> getByParam(Map<String, Object> param) throws BottomUpException;

    public void delete(Map<String, Object> param) throws BottomUpException;
}
