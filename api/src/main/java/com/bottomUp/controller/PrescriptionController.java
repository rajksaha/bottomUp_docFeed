package com.bottomUp.controller;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.*;
import com.bottomUp.domain.common.user.ContentDetailData;
import com.bottomUp.model.AttachmentData;
import com.bottomUp.service.common.AttachmentService;
import com.bottomUp.service.docFeed.MedicalCertificateService;
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
    private PrescriptionDiagnosisService prescriptionDiagnosisService;

    @Autowired
    private PrescriptionComplainService prescriptionComplainService;

    @Autowired
    private PrescriptionDrugService prescriptionDrugService;

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

    @Autowired
    private MedicalCertificateService medicalCertificateService;

    @Autowired
    private AttachmentService attachmentService;


    @RequestMapping(value = {"/getDoctorDetail/{doctorID}"}, method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getDoctorDetail(@PathVariable("doctorID") String doctorID, HttpServletRequest request) throws BottomUpException {
        return prescriptionViewService.getDetailsForPrescription(doctorID);
    }

    @RequestMapping(value = {"/getPrescriptionInfo/{appointmentID}"}, method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getAppointmentInfo(@PathVariable("appointmentID") String appointmentID, HttpServletRequest request) throws BottomUpException {
        return prescriptionViewService.getPrescriptionDetail(appointmentID);
    }

    @RequestMapping(value = {"/getPrescribedDiagnosis/{appointmentID}"}, method = RequestMethod.GET)
    @ResponseBody
    public List<PrescriptionDiagnosisData> getDiagnosisInfo(@PathVariable("appointmentID") String appointmentID, HttpServletRequest request) throws BottomUpException {
        Map<String, Object> requestMap = new HashMap<String, Object>();
        requestMap.put("appointmentID", appointmentID);
        return prescriptionDiagnosisService.getByParam(requestMap);
    }

    @RequestMapping(value = {"/getPrescribedComplain/{appointmentID}"}, method = RequestMethod.GET)
    @ResponseBody
    public List<PrescriptionComplainData> getComplainInfo(@PathVariable("appointmentID") String appointmentID, HttpServletRequest request) throws BottomUpException {
        Map<String, Object> requestMap = new HashMap<String, Object>();
        requestMap.put("appointmentID", appointmentID);
        return prescriptionComplainService.getByParam(requestMap);
    }

    @RequestMapping(value = {"/getPrescribedInv/{appointmentID}"}, method = RequestMethod.GET)
    @ResponseBody
    public List<PrescriptionInvData> getInvInfo(@PathVariable("appointmentID") String appointmentID, HttpServletRequest request) throws BottomUpException {
        Map<String, Object> requestMap = new HashMap<String, Object>();
        requestMap.put("appointmentID", appointmentID);
        return prescriptionInvService.getByParam(requestMap);
    }

    @RequestMapping(value = {"/getPrescribedDrug/{appointmentID}"}, method = RequestMethod.GET)
    @ResponseBody
    public List<PrescriptionDrugData> getPrescribedDrug(@PathVariable("appointmentID") String appointmentID, HttpServletRequest request) throws BottomUpException {
        Map<String, Object> requestMap = new HashMap<String, Object>();
        requestMap.put("appointmentID", appointmentID);
        return prescriptionDrugService.getByParam(requestMap);
    }

    @RequestMapping(value = {"/getPrescribedAdvice/{appointmentID}"}, method = RequestMethod.GET)
    @ResponseBody
    public List<PrescriptionAdviceData> getAdviceInfo(@PathVariable("appointmentID") String appointmentID, HttpServletRequest request) throws BottomUpException {
        Map<String, Object> requestMap = new HashMap<String, Object>();
        requestMap.put("appointmentID", appointmentID);
        return prescriptionAdviceService.getByParam(requestMap);
    }

    @RequestMapping(value = {"/getHistoryInfo/{patientID}/{appointmentID}/{typeCode}"}, method = RequestMethod.GET)
    @ResponseBody
    public List<PrescriptionHistoryData> getHistoryInfo(@PathVariable("patientID") String patientID,
                                                        @PathVariable("appointmentID") String appointmentID,
                                                        @PathVariable("typeCode") String typeCode,
                                                        HttpServletRequest request) throws BottomUpException {
        Map<String, Object> requestMap = new HashMap<String, Object>();
        requestMap.put("appointmentID", appointmentID);
        requestMap.put("patientID", patientID);
        requestMap.put("typeCode", typeCode);
        return prescriptionHistoryService.getByParam(requestMap);
    }

    @RequestMapping(value = {"/getPrescribedDiet/{appointmentID}"}, method = RequestMethod.GET)
    @ResponseBody
    public List<ContentDetailData> getDietInfo(@PathVariable("appointmentID") String appointmentID, HttpServletRequest request) throws BottomUpException {
        Map<String, Object> requestMap = new HashMap<String, Object>();
        requestMap.put("entityType", PrescriptionContentType.DIET);
        requestMap.put("entityID", appointmentID);
        return contentDetailService.getByParam(requestMap);
    }

    @RequestMapping(value = {"/getPrescribedOldDrugs/{appointmentID}"}, method = RequestMethod.GET)
    @ResponseBody
    public List<ContentDetailData> getPrescribedOldDrugs(@PathVariable("appointmentID") String appointmentID, HttpServletRequest request) throws BottomUpException {
        Map<String, Object> requestMap = new HashMap<String, Object>();
        requestMap.put("entityType", PrescriptionContentType.OLD_DRUG);
        requestMap.put("entityID", appointmentID);
        return contentDetailService.getByParam(requestMap);
    }

    @RequestMapping(value = {"/getPrescribedCurrentDrug/{appointmentID}"}, method = RequestMethod.GET)
    @ResponseBody
    public List<ContentDetailData> getPrescribedCurrentDrug(@PathVariable("appointmentID") String appointmentID, HttpServletRequest request) throws BottomUpException {
        Map<String, Object> requestMap = new HashMap<String, Object>();
        requestMap.put("entityType", PrescriptionContentType.CURRENT_DRUG);
        requestMap.put("entityID", appointmentID);
        return contentDetailService.getByParam(requestMap);
    }

    @RequestMapping(value = {"/getPrescribedNextVisit/{appointmentID}"}, method = RequestMethod.GET)
    @ResponseBody
    public List<PrescriptionNextVisitData> getNextVisitInfo(@PathVariable("appointmentID") String appointmentID, HttpServletRequest request) throws BottomUpException {
        Map<String, Object> requestMap = new HashMap<String, Object>();
        requestMap.put("appointmentID", appointmentID);
        return prescriptionNextVisitService.getByParam(requestMap);
    }

    @RequestMapping(value = {"/getPrescribedRefDoc/{appointmentID}"}, method = RequestMethod.GET)
    @ResponseBody
    public List<PrescriptionReferenceData> getReferredDocInfo(@PathVariable("appointmentID") String appointmentID, HttpServletRequest request) throws BottomUpException {
        Map<String, Object> requestMap = new HashMap<String, Object>();
        requestMap.put("appointmentID", appointmentID);
        return prescriptionReferenceService.getByParam(requestMap);
    }

    @RequestMapping(value = {"/getDrugHistoryInfo/{appointmentID}"}, method = RequestMethod.GET)
    @ResponseBody
    public List<ContentDetailData> getDrugHistoryInfo(@PathVariable("appointmentID") String appointmentID, HttpServletRequest request) throws BottomUpException {
        Map<String, Object> requestMap = new HashMap<String, Object>();
        requestMap.put("entityType", PrescriptionContentType.DRUG_HISTORY);
        requestMap.put("entityID", appointmentID);
        return contentDetailService.getByParam(requestMap);
    }

    @RequestMapping(value = {"/getPrescribedFamilyHistory/{appointmentID}"}, method = RequestMethod.GET)
    @ResponseBody
    public List<PrescriptionFamilyDiseaseData> getFamilyHistoryInfo(@PathVariable("appointmentID") String appointmentID, HttpServletRequest request) throws BottomUpException {
        Map<String, Object> requestMap = new HashMap<String, Object>();
        requestMap.put("appointmentID", appointmentID);
        return prescriptionFamilyDiseaseService.getByParam(requestMap);
    }

    @RequestMapping(value = {"/getPrescribedPastHistory/{appointmentID}"}, method = RequestMethod.GET)
    @ResponseBody
    public List<PrescriptionPastDiseaseData> getPastHistoryInfo(@PathVariable("appointmentID") String appointmentID, HttpServletRequest request) throws BottomUpException {
        Map<String, Object> requestMap = new HashMap<String, Object>();
        requestMap.put("appointmentID", appointmentID);
        return prescriptionPastDiseaseService.getByParam(requestMap);
    }

    @RequestMapping(value = {"/getRecordOfClinical/{appointmentID}"}, method = RequestMethod.GET)
    @ResponseBody
    public List<ContentDetailData> getClinicalInfo(@PathVariable("appointmentID") String appointmentID, HttpServletRequest request) throws BottomUpException {
        Map<String, Object> requestMap = new HashMap<String, Object>();
        requestMap.put("entityType", PrescriptionContentType.FOLLOW_UP);
        requestMap.put("entityID", appointmentID);
        return contentDetailService.getByParam(requestMap);
    }

    @RequestMapping(value = {"/getPrescribedVital/{appointmentID}"}, method = RequestMethod.GET)
    @ResponseBody
    public List<PrescriptionVitalData> getVitalInfo(@PathVariable("appointmentID") String appointmentID, HttpServletRequest request) throws BottomUpException {
        Map<String, Object> requestMap = new HashMap<String, Object>();
        requestMap.put("appointmentID", appointmentID);
        return prescriptionVitalService.getByParam(requestMap);
    }

    @RequestMapping(value = {"/getPrescribedComment/{appointmentID}"}, method = RequestMethod.GET)
    @ResponseBody
    public List<PresNoteData> getPrescribedNote(@PathVariable("appointmentID") String appointmentID, HttpServletRequest request) throws BottomUpException {
        return prescriptionViewService.getPrescribedNote(appointmentID);
    }

    @RequestMapping(value = {"/getMedicalReport/{appointmentID}"}, method = RequestMethod.GET)
    @ResponseBody
    public MedicalCertificateData getMedicalReport(@PathVariable("appointmentID") String appointmentID, HttpServletRequest request) throws BottomUpException {
        return medicalCertificateService.getByAppointmentID(appointmentID);
    }

    @RequestMapping(value = {"/getPresAdvTemp/{appointmentID}/{doctorID}"}, method = RequestMethod.GET)
    @ResponseBody
    public List<AttachmentData> getPresAdvTemp(@PathVariable("appointmentID") String appointmentID,
                                               @PathVariable("doctorID") String doctorID,
                                               HttpServletRequest request) throws BottomUpException {
        Map<String, Object> requestMap = new HashMap<String, Object>();
        requestMap.put("appointmentID", appointmentID);
        requestMap.put("doctorID", doctorID);
        requestMap.put("entityType", "GROUP_ADVICE");
        return this.attachmentService.getPrescribedAttachment(requestMap);
    }


}
