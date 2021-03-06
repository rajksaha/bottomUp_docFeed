package com.bottomUp.service.docFeed;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.DoctorData;
import com.bottomUp.domain.DoctorSettingData;
import com.bottomUp.domain.PresNoteData;
import com.bottomUp.domain.common.user.ContentDetailData;
import com.bottomUp.model.DietData;
import com.bottomUp.model.DoctorViewData;
import com.bottomUp.myBatis.persistence.*;
import com.bottomUp.service.docFeed.crud.PrescriptionDrugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import utility.type.PrescriptionContentType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by raj on 11/8/2020.
 */
@Service
@Transactional
public class PrescriptionViewService {

    @Autowired
    private PrescriptionDiagnosisMapper prescriptionDiagnosisMapper;

    @Autowired
    private PrescriptionDrugService prescriptionDrugService;

    @Autowired
    private PrescriptionComplainMapper complainMapper;

    @Autowired
    private PrescriptionAdviceMapper adviceMapper;

    @Autowired
    private PrescriptionInvMapper invMapper;

    @Autowired
    private PrescriptionHistoryMapper historyMapper;

    @Autowired
    private PrescriptionPastDiseaseMapper pastDiseaseMapper;

    @Autowired
    private PrescriptionReferenceMapper referenceMapper;

    @Autowired
    private PrescriptionVitalMapper vitalMapper;

    @Autowired
    private PrescriptionNextVisitMapper nextVisitMapper;

    @Autowired
    private PrescriptionFamilyDiseaseMapper familyDiseaseMapper;

    @Autowired
    private ContentDetailMapper contentDetailMapper;

    @Autowired
    private DoctorSettingMapper doctorSettingMapper;

    @Autowired
    private PatientTypeMapper patientTypeMapper;

    @Autowired
    private AppointmentTypeMapper appointmentTypeMapper;

    @Autowired
    private MenuSettingMapper menuSettingMapper;

    @Autowired
    private DoctorMapper doctorMapper;

    @Autowired
    private FollowUpResultMapper followUpResultMapper;


    public Map<String, Object> getDetailsForPrescription(String doctorID)throws BottomUpException{
        Map<String, Object> requestMap = new HashMap<String, Object>();
        DoctorData doctorData = doctorMapper.getByID(doctorID);
        DoctorSettingData doctorSettingData = doctorSettingMapper.getByDoctorID(doctorID);
        DoctorViewData viewData = new DoctorViewData();
        requestMap.put("doctorType", doctorData.getCategoryID());
        viewData.setPatientTypeList(patientTypeMapper.getByParam(requestMap));
        viewData.setDoctorID(doctorID);
        viewData.setDoctorSettingData(doctorSettingData);
        requestMap.put("doctorID", doctorID);
        viewData.setMenuList(menuSettingMapper.getByParam(requestMap));
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("doctorData", viewData);
        result.put("appointmentType", appointmentTypeMapper.getByParam(null));

        return result;
    }

    public Map<String, Object> getPrescriptionDetail(String appointmentID)throws BottomUpException{
        Map<String, Object> requestMap = new HashMap<String, Object>();
        requestMap.put("appointmentID", appointmentID);

        Map<String, Object> result = new HashMap<String, Object>();
        result.put("diagnosis", prescriptionDiagnosisMapper.getByAppointmentID(appointmentID));
        result.put("inv", invMapper.getByParam(requestMap));
        result.put("advice", adviceMapper.getByParam(requestMap));
        result.put("vital", vitalMapper.getByParam(requestMap));
        result.put("complain", complainMapper.getByParam(requestMap));
        result.put("familyHistory", familyDiseaseMapper.getByParam(requestMap));
        result.put("pastDisease", pastDiseaseMapper.getByParam(requestMap));
        result.put("history", historyMapper.getByParam(requestMap));
        result.put("reference", referenceMapper.getByParam(requestMap));
        result.put("newtVisit", nextVisitMapper.getByParam(requestMap));
        result.put("drug", prescriptionDrugService.getByParam(requestMap));
        requestMap.put("entityID", appointmentID);
        requestMap.put("entityType", PrescriptionContentType.DIET);

        List<ContentDetailData> dietList = contentDetailMapper.getByParam(requestMap);
        if(dietList != null && dietList.size() == 1){
            DietData dietData = new DietData();
            dietData.setDietID(dietList.get(0).getContentDetailID());
            dietData.setAppointmentID(dietList.get(0).getEntityID());
            dietData.setDietName(dietList.get(0).getShortName());
            result.put("diet", dietData);
        }
        requestMap.put("entityType", PrescriptionContentType.OLD_DRUG);
        result.put("oldDrugHistory", contentDetailMapper.getByParam(requestMap));
        requestMap.put("entityType", PrescriptionContentType.CURRENT_DRUG);
        result.put("currentDrugHistory", contentDetailMapper.getByParam(requestMap));
        requestMap.put("entityType", PrescriptionContentType.COMMENT);
        result.put("comment", this.getPrescribedNote(appointmentID));
        return result;
    }

    public List<PresNoteData> getPrescribedNote(String appointmentID) throws BottomUpException{
        List<PresNoteData> presNoteDataList = new ArrayList<>();
        Map<String, Object> requestMap = new HashMap<String, Object>();
        requestMap.put("entityID", appointmentID);
        requestMap.put("entityType", PrescriptionContentType.NOTE);
        List<ContentDetailData> contentList = contentDetailMapper.getByParam(requestMap);
        for(ContentDetailData content: contentList){
            PresNoteData noteData = this.getNoteData(presNoteDataList, content.getShortName());
            noteData.getNoteList().add(content.getLongDesc());
        }
        return presNoteDataList;
    }

    private PresNoteData getNoteData(List<PresNoteData> presNoteDataList, String header){
        for (PresNoteData note: presNoteDataList){
            if(note.getHeader().equals(header)){
                return note;
            }
        }
        PresNoteData noteData = new PresNoteData();
        noteData.setHeader(header);
        noteData.setNoteList(new ArrayList<String>());
        presNoteDataList.add(noteData);
        return noteData;
    }
}
