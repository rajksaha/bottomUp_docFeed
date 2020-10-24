package com.bottomUp.service.docFeed.crud;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.AppointmentTypeData;
import com.bottomUp.domain.PrescriptionDiagnosisData;
import com.bottomUp.myBatis.persistence.AppointmentTypeMapper;
import com.bottomUp.myBatis.persistence.PrescriptionDiagnosisMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by raj on 09/08/2020.
 */

@Service
public class PrescriptionDiagnosisService {

    @Autowired
    private PrescriptionDiagnosisMapper prescriptionDiagnosisMapper;

    public void create(PrescriptionDiagnosisData data) throws BottomUpException {
        prescriptionDiagnosisMapper.create(data);
    }

    public void update(PrescriptionDiagnosisData data) throws BottomUpException {
        prescriptionDiagnosisMapper.update(data);
    }

    public PrescriptionDiagnosisData getByID(Long ID)throws BottomUpException {
        return this.prescriptionDiagnosisMapper.getByID(ID);
    }

    public List<PrescriptionDiagnosisData> getByParam(Map<String, Object> param) throws BottomUpException {
        return this.prescriptionDiagnosisMapper.getByParam(param);
    }

    public void delete (Map<String,Object> param) throws BottomUpException {
        this.prescriptionDiagnosisMapper.delete(param);
    }
}
