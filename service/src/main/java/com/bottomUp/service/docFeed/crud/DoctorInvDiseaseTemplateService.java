package com.bottomUp.service.docFeed.crud;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.AppointmentTypeData;
import com.bottomUp.domain.DoctorInvDiseaseTemplateData;
import com.bottomUp.myBatis.persistence.AppointmentTypeMapper;
import com.bottomUp.myBatis.persistence.DoctorInvDiseaseTemplateMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by raj on 09/08/2020.
 */

@Service
public class DoctorInvDiseaseTemplateService {

    @Autowired
    private DoctorInvDiseaseTemplateMapper doctorInvDiseaseTemplateMapper;

    public void create(DoctorInvDiseaseTemplateData data) throws BottomUpException {
        doctorInvDiseaseTemplateMapper.create(data);
    }

    public void update(DoctorInvDiseaseTemplateData data) throws BottomUpException {
        doctorInvDiseaseTemplateMapper.update(data);
    }

    public DoctorInvDiseaseTemplateData getByID(Long ID)throws BottomUpException {
        return this.doctorInvDiseaseTemplateMapper.getByID(ID);
    }

    public List<DoctorInvDiseaseTemplateData> getByParam(Map<String, Object> param) throws BottomUpException {
        return this.doctorInvDiseaseTemplateMapper.getByParam(param);
    }

    public void delete (Map<String,Object> param) throws BottomUpException {
        this.doctorInvDiseaseTemplateMapper.delete(param);
    }
}
