package com.bottomUp.controller.docfeed;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.common.utility.SearchData;
import com.bottomUp.controller.BaseController;
import com.bottomUp.domain.PatientFamilyHistoryData;
import com.bottomUp.service.docFeed.crud.PatientFamilyHistoryService;
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
@RequestMapping("/patientFamilyHistory")
public class PatientFamilyHistoryController extends BaseController {

    @Autowired
    private PatientFamilyHistoryService patientFamilyHistoryService;

    @RequestMapping(value = {"/getByParam"}, method = RequestMethod.GET)
    @ResponseBody
    public List<PatientFamilyHistoryData> getAll(@RequestBody SearchData data, HttpServletRequest request) throws BottomUpException {
        Map<String, Object> params = new HashMap<>();
        params.put("patientID", data.getEntityID());
        return this.patientFamilyHistoryService.getByParam(params);
    }

    @RequestMapping(value = {"/getByPatientID/{patientID}"}, method = RequestMethod.GET)
    @ResponseBody
    public List<PatientFamilyHistoryData> getByPatientID(@PathVariable("patientID") String patientID, HttpServletRequest request) throws BottomUpException {
        Map<String, Object> params = new HashMap<>();
        params.put("patientID", patientID);
        return this.patientFamilyHistoryService.getByParam(params);
    }

    @RequestMapping(value = {"/save"}, method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> save(@RequestBody PatientFamilyHistoryData data) throws BottomUpException {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", true);
        if(data.getFamilyHistoryID() != null){
            this.patientFamilyHistoryService.update(data);
        }else{
            this.patientFamilyHistoryService.create(data);
        }
        result.put("familyHistoryID", data.getFamilyHistoryID());
        return result;
    }

    @RequestMapping(value = {"/create"}, method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> create(@RequestBody PatientFamilyHistoryData data) throws BottomUpException {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", true);
        this.patientFamilyHistoryService.create(data);
        return result;
    }

    @RequestMapping(value = {"/update"}, method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> update(@RequestBody PatientFamilyHistoryData data) throws BottomUpException {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", true);
        this.patientFamilyHistoryService.update(data);
        return result;
    }

    @RequestMapping(value = "/delete/{familyHistoryID}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("familyHistoryID") String appointmentID, HttpServletResponse httpResponse_p) throws BottomUpException {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("familyHistoryID", appointmentID);
        this.patientFamilyHistoryService.delete(param);
    }
}
