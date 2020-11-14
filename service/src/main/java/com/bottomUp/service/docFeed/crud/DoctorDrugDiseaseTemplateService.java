package com.bottomUp.service.docFeed.crud;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.AppointmentTypeData;
import com.bottomUp.domain.DoctorDrugDiseaseTemplateData;
import com.bottomUp.myBatis.persistence.AppointmentTypeMapper;
import com.bottomUp.myBatis.persistence.DoctorDoseDrugDiseaseTemplateMapper;
import com.bottomUp.myBatis.persistence.DoctorDrugDiseaseTemplateMapper;
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
public class DoctorDrugDiseaseTemplateService {

    @Autowired
    private DoctorDrugDiseaseTemplateMapper doctorDrugDiseaseTemplateMapper;

    public void create(DoctorDrugDiseaseTemplateData data) throws BottomUpException {
        doctorDrugDiseaseTemplateMapper.create(data);
    }

    public void update(DoctorDrugDiseaseTemplateData data) throws BottomUpException {
        doctorDrugDiseaseTemplateMapper.update(data);
    }

    public DoctorDrugDiseaseTemplateData getByID(Long ID)throws BottomUpException {
        return this.doctorDrugDiseaseTemplateMapper.getByID(ID);
    }

    public List<DoctorDrugDiseaseTemplateData> getByParam(Map<String, Object> param) throws BottomUpException {
        return this.doctorDrugDiseaseTemplateMapper.getByParam(param);
    }

    public void delete (Map<String,Object> param) throws BottomUpException {
        this.doctorDrugDiseaseTemplateMapper.delete(param);
    }
}
