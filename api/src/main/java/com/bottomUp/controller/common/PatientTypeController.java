package com.bottomUp.controller.common;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.controller.BaseController;
import com.bottomUp.domain.PatientTypeData;
import com.bottomUp.service.docFeed.AppointmentTypeService;
import com.bottomUp.service.docFeed.PatientTypeService;
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
@RequestMapping("/patientType")
public class PatientTypeController extends BaseController {

    @Autowired
    private PatientTypeService patientTypeService;

    @RequestMapping(value = {"/getByParam"}, method = RequestMethod.GET)
    @ResponseBody
    public List<PatientTypeData> getAll(HttpServletRequest request) throws BottomUpException {

        Map<String, Object> params = new HashMap<>();

        return this.patientTypeService.getByParam(params);
    }

    @RequestMapping(value = {"/getByID/{patientTypeID}"}, method = RequestMethod.GET)
    @ResponseBody
    public PatientTypeData getByID(@PathVariable("patientTypeID") Integer patientTypeID, HttpServletRequest request) throws BottomUpException {

       // Map<String, Object> params = this.parseParameter(request);

        return this.patientTypeService.getByID(Long.valueOf(patientTypeID));
    }

    @RequestMapping(value = {"/save"}, method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> save(@RequestBody PatientTypeData data) throws BottomUpException {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", true);
        result.put("data", this.patientTypeService.create(data));
        return result;
    }

    @RequestMapping(value = {"/update"}, method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> update(@RequestBody PatientTypeData data) throws BottomUpException {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", true);
        result.put("data", this.patientTypeService.update(data));
        return result;
    }

    @RequestMapping(value = "/delete/{patientTypeID}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("patientTypeID") Integer patientTypeID, HttpServletResponse httpResponse_p) throws BottomUpException {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("patientTypeID", patientTypeID);
        this.patientTypeService.delete(param);
    }
}
