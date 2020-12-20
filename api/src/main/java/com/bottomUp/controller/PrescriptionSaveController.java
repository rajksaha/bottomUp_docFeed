package com.bottomUp.controller;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.common.utility.SearchData;
import com.bottomUp.domain.PrescriptionDiagnosisData;
import com.bottomUp.model.DietData;
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
    public void saveInvFromPref(HttpServletRequest request, @PathVariable Long appointmentID, @PathVariable Long invID) throws BottomUpException {
        this.prescriptionInvService.create(appointmentID, invID);
    }

    @RequestMapping(value = {"/saveAdviceFromPref/{appointmentID}/{adviceID}"}, method = RequestMethod.POST)
    @ResponseBody
    public void saveAdviceFromPref(HttpServletRequest request, @PathVariable Long appointmentID, @PathVariable Long adviceID) throws BottomUpException {
        this.prescriptionAdviceService.create(appointmentID, adviceID);
    }
}
