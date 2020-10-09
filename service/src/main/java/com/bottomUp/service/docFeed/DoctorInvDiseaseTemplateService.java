package com.bottomUp.service.docFeed;

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

    public DoctorInvDiseaseTemplateData create(DoctorInvDiseaseTemplateData data) throws BottomUpException {
        return this.doctorInvDiseaseTemplateMapper.create(data);
    }

    public DoctorInvDiseaseTemplateData update(DoctorInvDiseaseTemplateData data) throws BottomUpException {
        return this.doctorInvDiseaseTemplateMapper.update(data);
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
