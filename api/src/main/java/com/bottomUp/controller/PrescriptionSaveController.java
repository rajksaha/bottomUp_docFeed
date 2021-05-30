package com.bottomUp.controller;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.common.utility.SearchData;
import com.bottomUp.domain.MedicalCertificateData;
import com.bottomUp.domain.PrescriptionDiagnosisData;
import com.bottomUp.domain.common.user.ContentDetailData;
import com.bottomUp.model.DietData;
import com.bottomUp.service.docFeed.MedicalCertificateService;
import com.bottomUp.service.docFeed.crud.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by raj on 11/13/2020.
 */
@Controller
@RequestMapping("/prescriptionSave")
public class PrescriptionSaveController extends BaseController{

    @Autowired
    private PrescriptionComplainService prescriptionComplainService;

    @Autowired
    private PrescriptionAdviceService prescriptionAdviceService;

    @Autowired
    private PrescriptionInvService prescriptionInvService;

    @Autowired
    private PrescriptionDiagnosisService prescriptionDiagnosisService;

    @Autowired
    private ContentDetailService contentDetailService;

    @Autowired
    private MedicalCertificateService medicalCertificateService;

    @RequestMapping(value = {"/saveDiagnosis"}, method = RequestMethod.POST)
    @ResponseBody
    public void saveDiagnosis(HttpServletRequest request, @RequestBody PrescriptionDiagnosisData diagnosisData) throws BottomUpException {
        this.prescriptionDiagnosisService.save(diagnosisData);
    }

    @RequestMapping(value = {"/saveDiet"}, method = RequestMethod.POST)
    @ResponseBody
    public void saveDiet(HttpServletRequest request, @RequestBody DietData dietData) throws BottomUpException {
        this.contentDetailService.createByDietData(dietData);
    }

    @RequestMapping(value = {"/saveComplain"}, method = RequestMethod.POST)
    @ResponseBody
    public void saveComplain(HttpServletRequest request, @RequestBody SearchData searchData) throws BottomUpException {
        this.prescriptionComplainService.createByList(searchData.getComplainList());
    }

    @RequestMapping(value = {"/saveInvFromPref/{appointmentID}/{invID}"}, method = RequestMethod.POST)
    @ResponseBody
    public void saveInvFromPref(HttpServletRequest request, @PathVariable String appointmentID, @PathVariable String invID) throws BottomUpException {
        this.prescriptionInvService.create(appointmentID, invID);
    }

    @RequestMapping(value = {"/saveAdviceFromPref/{appointmentID}/{adviceID}"}, method = RequestMethod.POST)
    @ResponseBody
    public void saveAdviceFromPref(HttpServletRequest request, @PathVariable String appointmentID, @PathVariable String adviceID) throws BottomUpException {
        this.prescriptionAdviceService.create(appointmentID, adviceID);
    }

    @RequestMapping(value = {"/savePresNote"}, method = RequestMethod.POST)
    @ResponseBody
    public void savePresNote(HttpServletRequest request, @RequestBody SearchData searchData) throws BottomUpException {
        this.contentDetailService.saveNote(searchData);
    }

    @RequestMapping(value = {"/addPresAdvTemp"}, method = RequestMethod.POST)
    @ResponseBody
    public ContentDetailData addPresAdvTemp(HttpServletRequest request, @RequestBody ContentDetailData contentDetailData) throws BottomUpException {
        this.contentDetailService.addAdvTemplateInPres(contentDetailData);
        return contentDetailData;
    }

    @RequestMapping(value = {"/createMedicalCert"}, method = RequestMethod.POST)
    @ResponseBody
    public MedicalCertificateData saveMedicalCertificate(HttpServletRequest request, @RequestBody MedicalCertificateData certificateData) throws BottomUpException {
        this.medicalCertificateService.create(certificateData);
        return certificateData;
    }

    @RequestMapping(value = {"/updateMedicalCert"}, method = RequestMethod.POST)
    @ResponseBody
    public void updateMedicalCertificate(HttpServletRequest request, @RequestBody MedicalCertificateData certificateData) throws BottomUpException {
        this.medicalCertificateService.update(certificateData);
    }
}
