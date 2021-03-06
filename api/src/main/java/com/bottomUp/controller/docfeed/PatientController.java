package com.bottomUp.controller.docfeed;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.controller.BaseController;
import com.bottomUp.domain.PatientData;
import com.bottomUp.model.PatientViewData;
import com.bottomUp.service.docFeed.PatientViewService;
import com.bottomUp.service.docFeed.crud.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by raj on 8/9/2020.
 */
@Controller
@RequestMapping("/patient")
public class PatientController extends BaseController {

    @Autowired
    private PatientService patientService;

    @Autowired
    private PatientViewService patientViewService;

    @RequestMapping(value = {"/getByParam"}, method = RequestMethod.GET)
    @ResponseBody
    public List<PatientData> getAll(HttpServletRequest request) throws BottomUpException {

        Map<String, Object> params = new HashMap<>();

        return this.patientService.getByParam(params);
    }

    @RequestMapping(value = {"/getByID/{patientID}"}, method = RequestMethod.GET)
    @ResponseBody
    public PatientViewData getByID(@PathVariable("patientID") String patientID, HttpServletRequest request) throws BottomUpException {
        return this.patientService.getByID(patientID);
    }

    @RequestMapping(value = {"/save"}, method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> save(@RequestBody PatientViewData patientViewData) throws BottomUpException {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", true);
        this.patientViewService.create(patientViewData, this.getUserDetail().getCompanyData().getCompanyID());
        return result;
    }

    @RequestMapping(value = {"/update"}, method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> update(@RequestBody PatientViewData patientViewData) throws BottomUpException {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", true);
        this.patientViewService.update(patientViewData);
        return result;
    }

    @RequestMapping(value = {"/updatePatientType/{patientID}/{patientTypeID}"}, method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> updatePatientType(@PathVariable("patientID") String patientID, @PathVariable("patientTypeID") Integer patientTypeID) throws BottomUpException {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", true);
        this.patientService.updatePatientType(patientID, patientTypeID);
        return result;
    }

    @RequestMapping(value = "/delete/{patientID}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("patientID") String appointmentID, HttpServletResponse httpResponse_p) throws BottomUpException {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("patientID", appointmentID);
        this.patientService.delete(param);
    }
}
