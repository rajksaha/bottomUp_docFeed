package com.bottomUp.service.docFeed.crud;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.common.utility.SearchData;
import com.bottomUp.domain.DoctorHistorySettingData;
import com.bottomUp.domain.PatientHistoryData;
import com.bottomUp.domain.PrescriptionHistoryData;
import com.bottomUp.myBatis.persistence.PatientHistoryMapper;
import com.bottomUp.myBatis.persistence.PrescriptionHistoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by raj on 09/08/2020.
 */

@Service
@Transactional
public class PatientHistoryService {

    @Autowired
    private PatientHistoryMapper patientHistoryMapper;

    @Autowired
    private PrescriptionHistoryMapper prescriptionHistoryMapper;

    public void saveCustomHistory(SearchData data) throws BottomUpException{
        Map<String, Object> param = new HashMap<>();
        param.put("patientID", data.getEntityID());
        param.put("typeCode", data.getEntityType());
        patientHistoryMapper.delete(param);
        param.put("appointmentID", data.getAppointmentID());
        param.put("typeCode", data.getEntityType());
        prescriptionHistoryMapper.delete(param);

        for(DoctorHistorySettingData history : data.getHistoryList()){
            if(history.getHistoryResult() != null && history.getHistoryResult().trim().length() > 0){
                PatientHistoryData historyData = new PatientHistoryData();
                historyData.setPatientID(data.getEntityID());
                historyData.setHistoryResult(history.getHistoryResult());
                historyData.setHistoryID(history.getHistoryID());
                patientHistoryMapper.create(historyData);
                if (history.getAddedInPrescription()){
                    PrescriptionHistoryData presHisData = new PrescriptionHistoryData();
                    presHisData.setAppointmentID(data.getAppointmentID());
                    presHisData.setPatientHistoryID(historyData.getPatientHistoryID());
                    prescriptionHistoryMapper.create(presHisData);
                }
            }
        }

    }

    public void create(PatientHistoryData data) throws BottomUpException {
        patientHistoryMapper.create(data);
    }

    public void update(PatientHistoryData data) throws BottomUpException {
        patientHistoryMapper.update(data);
    }

    public PatientHistoryData getByID(Long ID)throws BottomUpException {
        return this. patientHistoryMapper.getByID(ID);
    }

    public List<PatientHistoryData> getByParam(Map<String, Object> param) throws BottomUpException {
        return this. patientHistoryMapper.getByParam(param);
    }

    public void delete (Map<String,Object> param) throws BottomUpException {
        this. patientHistoryMapper.delete(param);
    }
}
