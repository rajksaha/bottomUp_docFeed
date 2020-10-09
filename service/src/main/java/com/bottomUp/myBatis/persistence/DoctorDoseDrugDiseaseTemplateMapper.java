package com.bottomUp.myBatis.persistence;


import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.AppointmentData;
import com.bottomUp.domain.DoctorDoseDrugDiseaseTemplateData;

import java.util.List;
import java.util.Map;

/**
 * Created by raj on 09/08/2020.
 */
public interface DoctorDoseDrugDiseaseTemplateMapper {

    public DoctorDoseDrugDiseaseTemplateData create(DoctorDoseDrugDiseaseTemplateData data) throws BottomUpException;

    public DoctorDoseDrugDiseaseTemplateData update(DoctorDoseDrugDiseaseTemplateData data) throws BottomUpException;

    public DoctorDoseDrugDiseaseTemplateData getByID(Long ID) throws BottomUpException;

    public List<DoctorDoseDrugDiseaseTemplateData> getByParam(Map<String, Object> param) throws BottomUpException;

    public void delete(Map<String, Object> param) throws BottomUpException;
}
