package com.bottomUp.controller.docfeed;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.controller.BaseController;
import com.bottomUp.domain.PatientPastDiseaseData;
import com.bottomUp.service.docFeed.crud.PatientPastDiseaseService;
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
@RequestMapping("/patientPastDisease")
public class PatientPastDiseaseController extends BaseController {

    @Autowired
    private PatientPastDiseaseService patientPastDiseaseService;

    @RequestMapping(value = {"/getByParam"}, method = RequestMethod.GET)
    @ResponseBody
    public List<PatientPastDiseaseData> getAll(HttpServletRequest request) throws BottomUpException {

        Map<String, Object> params = new HashMap<>();

        return this.patientPastDiseaseService.getByParam(params);
    }

    @RequestMapping(value = {"/getByID/{patientPastDiseaseID}"}, method = RequestMethod.GET)
    @ResponseBody
    public PatientPastDiseaseData getByID(@PathVariable("patientPastDiseaseID") Integer companyID, HttpServletRequest request) throws BottomUpException {

        Map<String, Object> params = this.parseParameter(request);

        return this.patientPastDiseaseService.getByID(Long.valueOf(companyID));
    }

    @RequestMapping(value = {"/save"}, method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> save(@RequestBody PatientPastDiseaseData data) throws BottomUpException {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", true);
        this.patientPastDiseaseService.create(data);
        return result;
    }

    @RequestMapping(value = {"/update"}, method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> update(@RequestBody PatientPastDiseaseData data) throws BottomUpException {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", true);
        this.patientPastDiseaseService.update(data);
        return result;
    }

    @RequestMapping(value = "/delete/{patientPastDiseaseID}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("patientPastDiseaseID") Integer appointmentID, HttpServletResponse httpResponse_p) throws BottomUpException {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("patientPastDiseaseID", appointmentID);
        this.patientPastDiseaseService.delete(param);
    }
}
