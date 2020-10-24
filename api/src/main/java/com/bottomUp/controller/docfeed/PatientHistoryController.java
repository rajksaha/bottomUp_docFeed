package com.bottomUp.controller.docfeed;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.controller.BaseController;
import com.bottomUp.domain.PatientHistoryData;
import com.bottomUp.service.docFeed.crud.PatientHistoryService;
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
@RequestMapping("/patientHistory")
public class PatientHistoryController extends BaseController {

    @Autowired
    private PatientHistoryService patientHistoryService;

    @RequestMapping(value = {"/getByParam"}, method = RequestMethod.GET)
    @ResponseBody
    public List<PatientHistoryData> getAll(HttpServletRequest request) throws BottomUpException {

        Map<String, Object> params = new HashMap<>();

        return this.patientHistoryService.getByParam(params);
    }

    @RequestMapping(value = {"/getByID/{patientHistoryID}"}, method = RequestMethod.GET)
    @ResponseBody
    public PatientHistoryData getByID(@PathVariable("patientHistoryID") Integer companyID, HttpServletRequest request) throws BottomUpException {

        Map<String, Object> params = this.parseParameter(request);

        return this.patientHistoryService.getByID(Long.valueOf(companyID));
    }

    @RequestMapping(value = {"/save"}, method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> save(@RequestBody PatientHistoryData data) throws BottomUpException {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", true);
        this.patientHistoryService.create(data);
        return result;
    }

    @RequestMapping(value = {"/update"}, method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> update(@RequestBody PatientHistoryData data) throws BottomUpException {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", true);
        this.patientHistoryService.update(data);
        return result;
    }

    @RequestMapping(value = "/delete/{patientHistoryID}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("patientHistoryID") Integer appointmentID, HttpServletResponse httpResponse_p) throws BottomUpException {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("patientHistoryID", appointmentID);
        this.patientHistoryService.delete(param);
    }
}
