package com.bottomUp.service.docFeed;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.AppointmentTypeData;
import com.bottomUp.domain.DoctorAdviceDiseaseTemplateData;
import com.bottomUp.myBatis.persistence.AppointmentTypeMapper;
import com.bottomUp.myBatis.persistence.DoctorAdviceDiseaseTemplateMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by raj on 09/08/2020.
 */

@Service
public class DoctorAdviceDiseaseTemplateService {

    @Autowired
    private DoctorAdviceDiseaseTemplateMapper doctorAdviceDiseaseTemplateMapper;

    public DoctorAdviceDiseaseTemplateData create(DoctorAdviceDiseaseTemplateData data) throws BottomUpException {
        return this.doctorAdviceDiseaseTemplateMapper.create(data);
    }

    public DoctorAdviceDiseaseTemplateData update(DoctorAdviceDiseaseTemplateData data) throws BottomUpException {
        return this.doctorAdviceDiseaseTemplateMapper.update(data);
    }

    public DoctorAdviceDiseaseTemplateData getByID(Long ID)throws BottomUpException {
        return this.doctorAdviceDiseaseTemplateMapper.getByID(ID);
    }

    public List<DoctorAdviceDiseaseTemplateData> getByParam(Map<String, Object> param) throws BottomUpException {
        return this.doctorAdviceDiseaseTemplateMapper.getByParam(param);
    }

    public void delete (Map<String,Object> param) throws BottomUpException {
        this.doctorAdviceDiseaseTemplateMapper.delete(param);
    }
}
