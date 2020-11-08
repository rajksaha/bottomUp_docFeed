package com.bottomUp.controller;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.common.utility.SearchData;
import com.bottomUp.domain.*;
import com.bottomUp.domain.common.user.ContentDetailData;
import com.bottomUp.service.docFeed.PrescriptionViewService;
import com.bottomUp.service.docFeed.crud.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import utility.type.PrescriptionContentType;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by raj on 11/7/2020.
 */
@Controller
@RequestMapping("/prescription")
public class PrescriptionController extends BaseController{

    @Autowired
    private PrescriptionViewService prescriptionViewService;

    @Autowired
    private PrescriptionDiagnosisService diagnosisService;

    @Autowired
    private PrescriptionComplainService complainService;

    @Autowired
    private PrescriptionDrugService drugService;

    @Autowired
    private PrescriptionInvService prescriptionInvService;

    @Autowired
    private PrescriptionHistoryService prescriptionHistoryService;

    @Autowired
    private PrescriptionFamilyDiseaseService prescriptionFamilyDiseaseService;

    @Autowired
    private PrescriptionAdviceService prescriptionAdviceService;

    @Autowired
    private ContentDetailService contentDetailService;

    @Autowired
    private PrescriptionReferenceService prescriptionReferenceService;

    @Autowired
    private PrescriptionNextVisitService prescriptionNextVisitService;

    @Autowired
    private PrescriptionPastDiseaseService prescriptionPastDiseaseService;

    @Autowired
    private PrescriptionVitalService prescriptionVitalService;

    @RequestMapping(value = {"/getDoctorMenu/{appointmentID}"}, method = RequestMethod.GET)
    @ResponseBody
    public void visitPatient(@PathVariable("appointmentID") Long appointmentID, HttpServletRequest request) throws BottomUpException {
    }

    @RequestMapping(value = {"/getPrescriptionInfo/{appointmentID}"}, method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getAppointmentInfo(@PathVariable("appointmentID") Long appointmentID, HttpServletRequest request) throws BottomUpException {
        return prescriptionViewService.getPrescriptionDetail(appointmentID);
    }

    @RequestMapping(value = {"/getDiagnosisInfo/{appointmentID}"}, method = RequestMethod.GET)
    @ResponseBody
    public List<PrescriptionDiagnosisData> getDiagnosisInfo(@PathVariable("appointmentID") Long appointmentID, HttpServletRequest request) throws BottomUpException {
        Map<String, Object> requestMap = new HashMap<String, Object>();
        requestMap.put("appointmentID", appointmentID);
        return diagnosisService.getByParam(requestMap);
    }

    @RequestMapping(value = {"/getComplainInfo/{appointmentID}"}, method = RequestMethod.GET)
    @ResponseBody
    public List<PrescriptionComplainData> getComplainInfo(@PathVariable("appointmentID") Long appointmentID, HttpServletRequest request) throws BottomUpException {
        Map<String, Object> requestMap = new HashMap<String, Object>();
        requestMap.put("appointmentID", appointmentID);
        return complainService.getByParam(requestMap);
    }

    @RequestMapping(value = {"/getInvInfo/{appointmentID}"}, method = RequestMethod.GET)
    @ResponseBody
    public List<PrescriptionInvData> getInvInfo(@PathVariable("appointmentID") Long appointmentID, HttpServletRequest request) throws BottomUpException {
        Map<String, Object> requestMap = new HashMap<String, Object>();
        requestMap.put("appointmentID", appointmentID);
        return prescriptionInvService.getByParam(requestMap);
    }

    @RequestMapping(value = {"/getDrugInfo/{appointmentID}"}, method = RequestMethod.GET)
    @ResponseBody
    public List<PrescriptionDrugData> getDrugInfo(@PathVariable("appointmentID") Long appointmentID, HttpServletRequest request) throws BottomUpException {
        Map<String, Object> requestMap = new HashMap<String, Object>();
        requestMap.put("appointmentID", appointmentID);
        return drugService.getByParam(requestMap);
    }

    @RequestMapping(value = {"/getAdviceInfo/{appointmentID}"}, method = RequestMethod.GET)
    @ResponseBody
    public List<PrescriptionAdviceData> getAdviceInfo(@PathVariable("appointmentID") Long appointmentID, HttpServletRequest request) throws BottomUpException {
        Map<String, Object> requestMap = new HashMap<String, Object>();
        requestMap.put("appointmentID", appointmentID);
        return prescriptionAdviceService.getByParam(requestMap);
    }

    @RequestMapping(value = {"/getHistoryInfo/{appointmentID}"}, method = RequestMethod.GET)
    @ResponseBody
    public List<PrescriptionHistoryData> getHistoryInfo(@PathVariable("appointmentID") Long appointmentID, HttpServletRequest request) throws BottomUpException {
        Map<String, Object> requestMap = new HashMap<String, Object>();
        requestMap.put("appointmentID", appointmentID);
        return prescriptionHistoryService.getByParam(requestMap);
    }

    @RequestMapping(value = {"/getDietInfo/{appointmentID}"}, method = RequestMethod.GET)
    @ResponseBody
    public List<ContentDetailData> getDietInfo(@PathVariable("appointmentID") Long appointmentID, HttpServletRequest request) throws BottomUpException {
        Map<String, Object> requestMap = new HashMap<String, Object>();
        requestMap.put("entityType", PrescriptionContentType.DIET);
        requestMap.put("entityID", appointmentID);
        return contentDetailService.getByParam(requestMap);
    }

    @RequestMapping(value = {"/getNextVisitInfo/{appointmentID}"}, method = RequestMethod.GET)
    @ResponseBody
    public List<PrescriptionNextVisitData> getNextVisitInfo(@PathVariable("appointmentID") Long appointmentID, HttpServletRequest request) throws BottomUpException {
        Map<String, Object> requestMap = new HashMap<String, Object>();
        requestMap.put("appointmentID", appointmentID);
        return prescriptionNextVisitService.getByParam(requestMap);
    }

    @RequestMapping(value = {"/getReferredDocInfo/{appointmentID}"}, method = RequestMethod.GET)
    @ResponseBody
    public List<PrescriptionReferenceData> getReferredDocInfo(@PathVariable("appointmentID") Long appointmentID, HttpServletRequest request) throws BottomUpException {
        Map<String, Object> requestMap = new HashMap<String, Object>();
        requestMap.put("appointmentID", appointmentID);
        return prescriptionReferenceService.getByParam(requestMap);
    }

    @RequestMapping(value = {"/getDrugHistoryInfo/{appointmentID}"}, method = RequestMethod.GET)
    @ResponseBody
    public List<ContentDetailData> getDrugHistoryInfo(@PathVariable("appointmentID") Long appointmentID, HttpServletRequest request) throws BottomUpException {
        Map<String, Object> requestMap = new HashMap<String, Object>();
        requestMap.put("entityType", PrescriptionContentType.DRUG_HISTORY);
        requestMap.put("entityID", appointmentID);
        return contentDetailService.getByParam(requestMap);
    }

    @RequestMapping(value = {"/getFamilyHistoryInfo/{appointmentID}"}, method = RequestMethod.GET)
    @ResponseBody
    public List<PrescriptionFamilyDiseaseData> getFamilyHistoryInfo(@PathVariable("appointmentID") Long appointmentID, HttpServletRequest request) throws BottomUpException {
        Map<String, Object> requestMap = new HashMap<String, Object>();
        requestMap.put("appointmentID", appointmentID);
        return prescriptionFamilyDiseaseService.getByParam(requestMap);
    }

    @RequestMapping(value = {"/getPastHistoryInfo/{appointmentID}"}, method = RequestMethod.GET)
    @ResponseBody
    public List<PrescriptionPastDiseaseData> getPastHistoryInfo(@PathVariable("appointmentID") Long appointmentID, HttpServletRequest request) throws BottomUpException {
        Map<String, Object> requestMap = new HashMap<String, Object>();
        requestMap.put("appointmentID", appointmentID);
        return prescriptionPastDiseaseService.getByParam(requestMap);
    }

    @RequestMapping(value = {"/getCommentInfo/{appointmentID}"}, method = RequestMethod.GET)
    @ResponseBody
    public List<ContentDetailData> getCommentInfo(@PathVariable("appointmentID") Long appointmentID, HttpServletRequest request) throws BottomUpException {
        Map<String, Object> requestMap = new HashMap<String, Object>();
        requestMap.put("entityType", PrescriptionContentType.COMMENT);
        requestMap.put("entityID", appointmentID);
        return contentDetailService.getByParam(requestMap);
    }

    @RequestMapping(value = {"/getClinicalInfo/{appointmentID}"}, method = RequestMethod.GET)
    @ResponseBody
    public List<ContentDetailData> getClinicalInfo(@PathVariable("appointmentID") Long appointmentID, HttpServletRequest request) throws BottomUpException {
        Map<String, Object> requestMap = new HashMap<String, Object>();
        //TODO
        return null;
    }

    @RequestMapping(value = {"/getVitalInfo/{appointmentID}"}, method = RequestMethod.GET)
    @ResponseBody
    public List<PrescriptionVitalData> getVitalInfo(@PathVariable("appointmentID") Long appointmentID, HttpServletRequest request) throws BottomUpException {
        Map<String, Object> requestMap = new HashMap<String, Object>();
        requestMap.put("appointmentID", appointmentID);
        return prescriptionVitalService.getByParam(requestMap);
    }


}
