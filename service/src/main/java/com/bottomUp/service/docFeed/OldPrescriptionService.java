package com.bottomUp.service.docFeed;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.PrescriptionDiagnosisData;
import com.bottomUp.myBatis.persistence.*;
import com.bottomUp.service.docFeed.crud.PrescriptionAdviceService;
import com.bottomUp.service.docFeed.crud.PrescriptionComplainService;
import com.bottomUp.service.docFeed.crud.PrescriptionDrugService;
import com.bottomUp.service.docFeed.crud.PrescriptionInvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import utility.type.PresContentDetailType;
import utility.type.PrescriptionContentType;

import java.util.HashMap;
import java.util.Map;

import static utility.type.PresContentDetailType.*;

/**
 * Created by raj on 2/1/2021.
 */
@Service
@Transactional
public class OldPrescriptionService {

    @Autowired
    private PrescriptionDrugMapper prescriptionDrugMapper;

    @Autowired
    private PrescriptionComplainMapper prescriptionComplainMapper;

    @Autowired
    private PrescriptionAdviceMapper prescriptionAdviceMapper;

    @Autowired
    private PrescriptionInvMapper prescriptionInvMapper;

    @Autowired
    private PrescriptionDiagnosisMapper prescriptionDiagnosisMapper;

    @Autowired
    private ContentDetailMapper contentDetailMapper;

    @Autowired
    private PrescriptionHistoryMapper prescriptionHistoryMapper;

    @Autowired
    private PrescriptionPastDiseaseMapper prescriptionPastDiseaseMapper;

    @Autowired
    private PrescriptionFamilyDiseaseMapper prescriptionFamilyDiseaseMapper;

    public void copyByItem(String itemCode, Long itemID, Long newAppointmentID) throws BottomUpException{
        this.copy(itemCode, newAppointmentID, false, itemID);
    }

    public void copyItemsByAppointmentID(String itemCode, Long oldAppointmentID, Long newAppointmentID) throws BottomUpException{
        this.copy(itemCode, newAppointmentID, true, oldAppointmentID);
    }

    public void copyPrescription (Long oldAppointmentID, Long newAppointmentID) throws BottomUpException{
        for (PresContentDetailType itemCode : PresContentDetailType.values()) {
            this.copyItemsByAppointmentID(itemCode.getShortName(), newAppointmentID, oldAppointmentID);
        }
    }

    private void copy(String itemCode, Long newAppointmentID, Boolean copyByAppointment, Long requestedID)throws
            BottomUpException{

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("newAppointmentID", newAppointmentID);
        PresContentDetailType itemType = PresContentDetailType.valueOf(itemCode);
        switch (itemType){
            case DRUG:
                params.put(copyByAppointment ? "appointmentID" : DRUG.getIdName(),requestedID);
                prescriptionDrugMapper.selectInsert(params);
                break;
            case COMPLAIN:
                params.put(copyByAppointment ? "appointmentID" : COMPLAIN.getIdName(),requestedID);
                prescriptionComplainMapper.selectInsert(params);
                break;
            case INV:
                params.put(copyByAppointment ? "appointmentID" : INV.getIdName(),requestedID);
                prescriptionInvMapper.selectInsert(params);
                break;
            case ADVICE:
                params.put(copyByAppointment ? "appointmentID" : ADVICE.getIdName(),requestedID);
                prescriptionAdviceMapper.selectInsert(params);
                break;
            case DIAGNOSIS:
                PrescriptionDiagnosisData diagnosisData = prescriptionDiagnosisMapper.getByAppointmentID(newAppointmentID);
                if(diagnosisData == null){
                    params.put(copyByAppointment ? "appointmentID" : DIAGNOSIS.getIdName(),requestedID);
                    prescriptionDiagnosisMapper.selectInsert(params);
                }
                break;
            case DIET:
                params.put(copyByAppointment ? "appointmentID" : DIET.getIdName(),requestedID);
                params.put("entityType", PrescriptionContentType.DIET);
                this.contentDetailMapper.selectInsert(params);
                break;
            case HISTORY:
                params.put(copyByAppointment ? "appointmentID" : HISTORY.getIdName(),requestedID);
                prescriptionHistoryMapper.selectInsert(params);
                break;
            case PAST_HISTORY:
                params.put(copyByAppointment ? "appointmentID" : HISTORY.getIdName(),requestedID);
                prescriptionPastDiseaseMapper.selectInsert(params);
                break;
            case FAMILY_HISTORY:
                params.put(copyByAppointment ? "appointmentID" : HISTORY.getIdName(),requestedID);
                prescriptionFamilyDiseaseMapper.selectInsert(params);
                break;
            case COMMENT:
                params.put(copyByAppointment ? "appointmentID" : COMMENT.getIdName(),requestedID);
                params.put("entityType", PrescriptionContentType.COMMENT);
                this.contentDetailMapper.selectInsert(params);
                break;
            case OLD_DRUG:
                params.put(copyByAppointment ? "appointmentID" : OLD_DRUG.getIdName(),requestedID);
                params.put("entityType", PrescriptionContentType.OLD_DRUG);
                this.contentDetailMapper.selectInsert(params);
                break;
            case CURR_DRUG:
                params.put(copyByAppointment ? "appointmentID" : CURR_DRUG.getIdName(),requestedID);
                params.put("entityType", PrescriptionContentType.CURRENT_DRUG);
                this.contentDetailMapper.selectInsert(params);
                break;
            default:
                System.out.println("hello");
        }
    }

}
