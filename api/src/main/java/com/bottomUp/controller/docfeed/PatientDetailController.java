package com.bottomUp.controller.docfeed;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.controller.BaseController;
import com.bottomUp.domain.PatientDetailData;
import com.bottomUp.service.docFeed.crud.PatientDetailService;
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
@RequestMapping("/patientDetail")
public class PatientDetailController extends BaseController {

    @Autowired
    private PatientDetailService patientDetailService;

    @RequestMapping(value = {"/getByParam"}, method = RequestMethod.GET)
    @ResponseBody
    public List<PatientDetailData> getAll(HttpServletRequest request) throws BottomUpException {

        Map<String, Object> params = new HashMap<>();

        return this.patientDetailService.getByParam(params);
    }

    @RequestMapping(value = {"/getByID/{patientID}"}, method = RequestMethod.GET)
    @ResponseBody
    public PatientDetailData getByID(@PathVariable("patientID") String patientID, HttpServletRequest request) throws BottomUpException {
        return this.patientDetailService.getByID(patientID);
    }

    @RequestMapping(value = {"/save"}, method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> save(@RequestBody PatientDetailData data) throws BottomUpException {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", true);
        this.patientDetailService.create(data);
        return result;
    }

    @RequestMapping(value = {"/update"}, method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> update(@RequestBody PatientDetailData data) throws BottomUpException {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", true);
        this.patientDetailService.update(data);
        return result;
    }

    @RequestMapping(value = "/delete/{patientID}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("patientID") String appointmentID, HttpServletResponse httpResponse_p) throws BottomUpException {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("patientID", appointmentID);
        this.patientDetailService.delete(param);
    }
}
