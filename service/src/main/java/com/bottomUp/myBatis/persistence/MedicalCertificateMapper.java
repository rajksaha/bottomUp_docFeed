package com.bottomUp.myBatis.persistence;


import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.ContentAdviceData;
import com.bottomUp.domain.MedicalCertificateData;

import java.util.List;
import java.util.Map;

/**
 * Created by raj on 09/08/2020.
 */
public interface MedicalCertificateMapper {

    public void create(MedicalCertificateData data) throws BottomUpException;

    public void update(MedicalCertificateData data) throws BottomUpException;

    public MedicalCertificateData getByAppointmentID(Long ID) throws BottomUpException;

    public List<MedicalCertificateData> getByParam(Map<String, Object> param) throws BottomUpException;

    public void delete(Map<String, Object> param) throws BottomUpException;
}
