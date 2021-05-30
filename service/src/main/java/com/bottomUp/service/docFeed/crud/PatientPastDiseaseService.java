package com.bottomUp.service.docFeed.crud;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.AppointmentTypeData;
import com.bottomUp.domain.PatientPastDiseaseData;
import com.bottomUp.myBatis.persistence.AppointmentTypeMapper;
import com.bottomUp.myBatis.persistence.PatientPastDiseaseMapper;
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
public class PatientPastDiseaseService {

    @Autowired
    private PatientPastDiseaseMapper patientPastDiseaseMapper;

    @Autowired
    private ContentDiseaseService contentDiseaseService;

    public void create(PatientPastDiseaseData data) throws BottomUpException {
        data.setDiseaseID(contentDiseaseService.getInsert(data.getDiseaseName()));
        patientPastDiseaseMapper.create(data);
    }

    public void update(PatientPastDiseaseData data) throws BottomUpException {
        data.setDiseaseID(contentDiseaseService.getInsert(data.getDiseaseName()));
        patientPastDiseaseMapper.update(data);
    }

    public PatientPastDiseaseData getByID(String ID)throws BottomUpException {
        return this.patientPastDiseaseMapper.getByID(ID);
    }

    public List<PatientPastDiseaseData> getByParam(Map<String, Object> param) throws BottomUpException {
        return this.patientPastDiseaseMapper.getByParam(param);
    }

    public void delete (Map<String,Object> param) throws BottomUpException {
        this.patientPastDiseaseMapper.delete(param);
    }
}
