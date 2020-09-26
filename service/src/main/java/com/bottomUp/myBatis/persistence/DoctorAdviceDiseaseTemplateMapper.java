package com.bottomUp.myBatis.persistence;


import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.AppointmentData;
import com.bottomUp.domain.DoctorAdviceDiseaseTemplateData;

import java.util.List;
import java.util.Map;

/**
 * Created by raj on 09/08/2020.
 */
public interface DoctorAdviceDiseaseTemplateMapper {

    public void create(DoctorAdviceDiseaseTemplateData data) throws BottomUpException;

    public void update(DoctorAdviceDiseaseTemplateData data) throws BottomUpException;

    public DoctorAdviceDiseaseTemplateData  getByID(Long ID) throws BottomUpException;

    public List<DoctorAdviceDiseaseTemplateData> getByParam(Map<String, Object> param) throws BottomUpException;

    public void delete(Map<String, Object> param) throws BottomUpException;
}