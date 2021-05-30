package com.bottomUp.service.docFeed.crud;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.AppointmentTypeData;
import com.bottomUp.domain.PrescriptionPastDiseaseData;
import com.bottomUp.myBatis.persistence.AppointmentTypeMapper;
import com.bottomUp.myBatis.persistence.PrescriptionPastDiseaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * Created by raj on 09/08/2020.
 */

@Service
@Transactional
public class PrescriptionPastDiseaseService {

    @Autowired
    private PrescriptionPastDiseaseMapper prescriptionPastDiseaseMapper;

    public void create(PrescriptionPastDiseaseData data) throws BottomUpException {
        prescriptionPastDiseaseMapper.create(data);
    }

    public void update(PrescriptionPastDiseaseData data) throws BottomUpException {
        prescriptionPastDiseaseMapper.update(data);
    }

    public PrescriptionPastDiseaseData getByID(String ID)throws BottomUpException {
        return this.prescriptionPastDiseaseMapper.getByID(ID);
    }

    public List<PrescriptionPastDiseaseData> getByParam(Map<String, Object> param) throws BottomUpException {
        return this.prescriptionPastDiseaseMapper.getByParam(param);
    }

    public void delete (Map<String,Object> param) throws BottomUpException {
        this.prescriptionPastDiseaseMapper.delete(param);
    }
}
