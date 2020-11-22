package com.bottomUp.service.docFeed.crud;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.PrescriptionInvData;
import com.bottomUp.myBatis.persistence.PrescriptionInvMapper;
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
public class PrescriptionInvService {

    @Autowired
    private PrescriptionInvMapper prescriptionInvMapper;

    @Autowired
    private ContentInvService contentInvService;

    public void create(Long appointmentID, Long invID) throws BottomUpException{
        PrescriptionInvData prescriptionInvData = new PrescriptionInvData();
        prescriptionInvData.setAppointmentID(appointmentID);
        prescriptionInvData.setInvID(invID);
        prescriptionInvMapper.create(prescriptionInvData);
    }

    public void create(PrescriptionInvData data) throws BottomUpException {
        if(data != null && data.getInvID() == null){
            data.setInvID(contentInvService.getInsert(data.getInvName()));
        }
        prescriptionInvMapper.create(data);
    }

    public void update(PrescriptionInvData  data) throws BottomUpException {
        if(data != null && data.getInvID() == null){
            data.setInvID(contentInvService.getInsert(data.getInvName()));
        }
        prescriptionInvMapper.update(data);
    }

    public PrescriptionInvData  getByID(Long ID)throws BottomUpException {
        return this.prescriptionInvMapper.getByID(ID);
    }

    public List<PrescriptionInvData> getByParam(Map<String, Object> param) throws BottomUpException {
        return this.prescriptionInvMapper.getByParam(param);
    }

    public void delete (Map<String,Object> param) throws BottomUpException {
        this.prescriptionInvMapper.delete(param);
    }
}
