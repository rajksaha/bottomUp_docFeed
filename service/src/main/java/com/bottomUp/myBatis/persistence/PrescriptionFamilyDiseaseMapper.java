package com.bottomUp.myBatis.persistence;


import com.bottomUp.common.exception.BottomUpException;

import com.bottomUp.domain.PrescriptionFamilyDiseaseData;

import java.util.List;
import java.util.Map;

/**
 * Created by raj on 09/08/2020.
 */
public interface PrescriptionFamilyDiseaseMapper {

    public void create(PrescriptionFamilyDiseaseData data) throws BottomUpException;

    public void update(PrescriptionFamilyDiseaseData data) throws BottomUpException;

    public PrescriptionFamilyDiseaseData getByID(Long ID) throws BottomUpException;

    public List<PrescriptionFamilyDiseaseData> getByParam(Map<String, Object> param) throws BottomUpException;

    public void delete(Map<String, Object> param) throws BottomUpException;
}
