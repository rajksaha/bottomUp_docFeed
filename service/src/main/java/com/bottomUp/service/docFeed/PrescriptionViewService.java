package com.bottomUp.service.docFeed;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.myBatis.persistence.*;
import com.bottomUp.service.docFeed.crud.PrescriptionComplainService;
import com.bottomUp.service.docFeed.crud.PrescriptionDrugService;
import org.springframework.beans.factory.annotation.Autowired;
import utility.type.PrescriptionContentType;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by raj on 11/8/2020.
 */
public class PrescriptionViewService {

    @Autowired
    private PrescriptionDiagnosisMapper diagnosisMapper;

    @Autowired
    private PrescriptionDrugService drugService;

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



    public Map<String, Object> getPrescriptionDetail(Long appointmentID)throws BottomUpException{
        Map<String, Object> requestMap = new HashMap<String, Object>();
        requestMap.put("appointmentID", appointmentID);

        Map<String, Object> result = new HashMap<String, Object>();
        result.put("diagnosis", diagnosisMapper.getByParam(requestMap));
        result.put("inv", invMapper.getByParam(requestMap));
        result.put("advice", adviceMapper.getByParam(requestMap));
        result.put("vital", vitalMapper.getByParam(requestMap));
        result.put("complain", complainMapper.getByParam(requestMap));
        result.put("familyHistory", familyDiseaseMapper.getByParam(requestMap));
        result.put("pastDisease", pastDiseaseMapper.getByParam(requestMap));
        result.put("history", historyMapper.getByParam(requestMap));
        result.put("reference", referenceMapper.getByParam(requestMap));
        result.put("newtVisit", nextVisitMapper.getByParam(requestMap));
        result.put("drug", drugService.getByParam(requestMap));
        requestMap.put("entityID", appointmentID);
        requestMap.put("entityType", PrescriptionContentType.DIET);
        result.put("diet", contentDetailMapper.getByParam(requestMap));
        requestMap.put("entityType", PrescriptionContentType.DRUG_HISTORY);
        result.put("drugHistory", contentDetailMapper.getByParam(requestMap));
        requestMap.put("entityType", PrescriptionContentType.COMMENT);
        result.put("comment", contentDetailMapper.getByParam(requestMap));

        //Clinical Record -- need change


        return result;
    }
}
