package com.bottomUp.service.docFeed.crud;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.PrescriptionReferenceData;
import com.bottomUp.myBatis.persistence.PrescriptionReferenceMapper;
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
public class PrescriptionReferenceService {

    @Autowired
    private PrescriptionReferenceMapper prescriptionReferenceMapper;

    @Autowired
    private ReferredDoctorService referredDoctorService;

    public void create(PrescriptionReferenceData data) throws BottomUpException {
        data.setReferredDoctorID(referredDoctorService.createByName(data.getDoctorName(), data.getDoctorAddress()));
        prescriptionReferenceMapper.create(data);
    }

    public void update(PrescriptionReferenceData data) throws BottomUpException {
        prescriptionReferenceMapper.update(data);
    }

    public PrescriptionReferenceData getByID(String ID)throws BottomUpException {
        return this.prescriptionReferenceMapper.getByID(ID);
    }

    public List<PrescriptionReferenceData> getByParam(Map<String, Object> param) throws BottomUpException {
        return this.prescriptionReferenceMapper.getByParam(param);
    }

    public void delete (Map<String,Object> param) throws BottomUpException {
        this.prescriptionReferenceMapper.delete(param);
    }
}
