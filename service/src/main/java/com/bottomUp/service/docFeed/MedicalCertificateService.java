package com.bottomUp.service.docFeed;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.MedicalCertificateData;
import com.bottomUp.myBatis.persistence.MedicalCertificateMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * Created by raj on 6/1/2016.
 */

@Service
@Transactional(rollbackFor = BottomUpException.class)
public class MedicalCertificateService {

    @Autowired
    private MedicalCertificateMapper medicalCertificateMapper;

    public void create(MedicalCertificateData data) throws BottomUpException {
        medicalCertificateMapper.create(data);
    }

    public void update(MedicalCertificateData data) throws BottomUpException {
        medicalCertificateMapper.update(data);
    }

    public MedicalCertificateData getByAppointmentID(String appointmentID)throws BottomUpException {
        return this.medicalCertificateMapper.getByAppointmentID(appointmentID);
    }

    public List<MedicalCertificateData> getByParam(Map<String, Object> param) throws BottomUpException {
        return this.medicalCertificateMapper.getByParam(param);
    }

    public void delete (Map<String,Object> param) throws BottomUpException {
        this.medicalCertificateMapper.delete(param);
    }
}
