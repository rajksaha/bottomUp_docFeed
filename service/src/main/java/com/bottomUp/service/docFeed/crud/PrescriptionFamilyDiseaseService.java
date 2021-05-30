package com.bottomUp.service.docFeed.crud;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.AppointmentTypeData;
import com.bottomUp.domain.PrescriptionFamilyDiseaseData;
import com.bottomUp.myBatis.persistence.AppointmentTypeMapper;
import com.bottomUp.myBatis.persistence.PrescriptionFamilyDiseaseMapper;
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
public class PrescriptionFamilyDiseaseService {

    @Autowired
    private PrescriptionFamilyDiseaseMapper prescriptionFamilyDiseaseMapper;

    public void create(PrescriptionFamilyDiseaseData data) throws BottomUpException {
        prescriptionFamilyDiseaseMapper.create(data);
    }

    public void update(PrescriptionFamilyDiseaseData data) throws BottomUpException {
        prescriptionFamilyDiseaseMapper.update(data);
    }

    public PrescriptionFamilyDiseaseData getByID(String ID)throws BottomUpException {
        return this.prescriptionFamilyDiseaseMapper.getByID(ID);
    }

    public List<PrescriptionFamilyDiseaseData> getByParam(Map<String, Object> param) throws BottomUpException {
        return this.prescriptionFamilyDiseaseMapper.getByParam(param);
    }

    public void delete (Map<String,Object> param) throws BottomUpException {
        this.prescriptionFamilyDiseaseMapper.delete(param);
    }
}
