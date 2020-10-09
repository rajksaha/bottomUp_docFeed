package com.bottomUp.service.docFeed;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.AppointmentTypeData;
import com.bottomUp.domain.DoctorDoseDrugDiseaseTemplateData;
import com.bottomUp.myBatis.persistence.AppointmentTypeMapper;
import com.bottomUp.myBatis.persistence.DoctorDoseDrugDiseaseTemplateMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by raj on 09/08/2020.
 */

@Service
public class DoctorDoseDrugDiseaseTemplateService {

    @Autowired
    private DoctorDoseDrugDiseaseTemplateMapper doctorDoseDrugDiseaseTemplateMapper;

    public DoctorDoseDrugDiseaseTemplateData create(DoctorDoseDrugDiseaseTemplateData data) throws BottomUpException {
        return this.doctorDoseDrugDiseaseTemplateMapper.create(data);
    }

    public DoctorDoseDrugDiseaseTemplateData update(DoctorDoseDrugDiseaseTemplateData data) throws BottomUpException {
        return this.doctorDoseDrugDiseaseTemplateMapper.update(data);
    }

    public DoctorDoseDrugDiseaseTemplateData getByID(Long ID)throws BottomUpException {
        return this.doctorDoseDrugDiseaseTemplateMapper.getByID(ID);
    }

    public List<DoctorDoseDrugDiseaseTemplateData> getByParam(Map<String, Object> param) throws BottomUpException {
        return this.doctorDoseDrugDiseaseTemplateMapper.getByParam(param);
    }

    public void delete (Map<String,Object> param) throws BottomUpException {
        this.doctorDoseDrugDiseaseTemplateMapper.delete(param);
    }
}
