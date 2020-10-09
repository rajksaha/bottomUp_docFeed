package com.bottomUp.controller.common;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.controller.BaseController;
import com.bottomUp.domain.PatientDrugHistoryData;
import com.bottomUp.service.docFeed.AppointmentTypeService;
import com.bottomUp.service.docFeed.PatientDrugHistoryService;
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
@RequestMapping("/patientDrugHistory")
public class PatientDrugHistoryController extends BaseController {

    @Autowired
    private PatientDrugHistoryService patientDrugHistoryService;

    @RequestMapping(value = {"/getByParam"}, method = RequestMethod.GET)
    @ResponseBody
    public List<PatientDrugHistoryData> getAll(HttpServletRequest request) throws BottomUpException {

        Map<String, Object> params = new HashMap<>();

        return this.patientDrugHistoryService.getByParam(params);
    }

    @RequestMapping(value = {"/getByID/{drugHistoryID}"}, method = RequestMethod.GET)
    @ResponseBody
    public PatientDrugHistoryData getByID(@PathVariable("drugHistoryID") Integer drugHistoryID, HttpServletRequest request) throws BottomUpException {

        //Map<String, Object> params = this.parseParameter(request);

        return this.patientDrugHistoryService.getByID(Long.valueOf(drugHistoryID));
    }

    @RequestMapping(value = {"/save"}, method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> save(@RequestBody PatientDrugHistoryData data) throws BottomUpException {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", true);
        result.put("data",  this.patientDrugHistoryService.create(data));
        return result;
    }

    @RequestMapping(value = {"/update"}, method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> update(@RequestBody PatientDrugHistoryData data) throws BottomUpException {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", true);
        result.put("data",  this.patientDrugHistoryService.update(data));
        return result;
    }

    @RequestMapping(value = "/delete/{drugHistoryID}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("drugHistoryID") Integer drugHistoryID, HttpServletResponse httpResponse_p) throws BottomUpException {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("drugHistoryID", drugHistoryID);
        this.patientDrugHistoryService.delete(param);
    }
}
