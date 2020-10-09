package com.bottomUp.controller.common;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.controller.BaseController;
import com.bottomUp.domain.PatientFollowUpData;
import com.bottomUp.service.docFeed.AppointmentTypeService;
import com.bottomUp.service.docFeed.PatientFollowUpService;
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
@RequestMapping("/patientFollowUP")
public class PatientFollowUPController extends BaseController {

    @Autowired
    private PatientFollowUpService patientFollowUpService;

    @RequestMapping(value = {"/getByParam"}, method = RequestMethod.GET)
    @ResponseBody
    public List<PatientFollowUpData> getAll(HttpServletRequest request) throws BottomUpException {

        Map<String, Object> params = new HashMap<>();

        return this.patientFollowUpService.getByParam(params);
    }

    @RequestMapping(value = {"/getByID/{patientFollowUpID}"}, method = RequestMethod.GET)
    @ResponseBody
    public PatientFollowUpData getByID(@PathVariable("patientFollowUpID") Integer patientFollowUpID, HttpServletRequest request) throws BottomUpException {

        //Map<String, Object> params = this.parseParameter(request);

        return this.patientFollowUpService.getByID(Long.valueOf(patientFollowUpID));
    }

    @RequestMapping(value = {"/save"}, method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> save(@RequestBody PatientFollowUpData data) throws BottomUpException {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", true);
        result.put("data", this.patientFollowUpService.create(data));
        return result;
    }

    @RequestMapping(value = {"/update"}, method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> update(@RequestBody PatientFollowUpData data) throws BottomUpException {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", true);
        result.put("data", this.patientFollowUpService.update(data));
        return result;
    }

    @RequestMapping(value = "/delete/{patientFollowUpID}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("patientFollowUpID") Integer patientFollowUpID, HttpServletResponse httpResponse_p) throws BottomUpException {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("patientFollowUpID", patientFollowUpID);
        this.patientFollowUpService.delete(param);
    }
}
