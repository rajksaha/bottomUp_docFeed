package com.bottomUp.controller.common;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.controller.BaseController;
import com.bottomUp.domain.  PrescriptionReferenceData;
import com.bottomUp.service.docFeed.AppointmentTypeService;
import com.bottomUp.service.docFeed.PrescriptionReferenceService;
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
@RequestMapping("/prescriptionReference")
public class PrescriptionReferenceController extends BaseController {

    @Autowired
    private PrescriptionReferenceService prescriptionReferenceService;

    @RequestMapping(value = {"/getByParam"}, method = RequestMethod.GET)
    @ResponseBody
    public List<  PrescriptionReferenceData> getAll(HttpServletRequest request) throws BottomUpException {

        Map<String, Object> params = new HashMap<>();

        return this.prescriptionReferenceService.getByParam(params);
    }

    @RequestMapping(value = {"/getByID/{  prescriptionReferenceID}"}, method = RequestMethod.GET)
    @ResponseBody
    public   PrescriptionReferenceData getByID(@PathVariable("  prescriptionReferenceID") Integer prescriptionReferenceID, HttpServletRequest request) throws BottomUpException {

        //Map<String, Object> params = this.parseParameter(request);

        return this.prescriptionReferenceService.getByID(Long.valueOf(prescriptionReferenceID));
    }

    @RequestMapping(value = {"/save"}, method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> save(@RequestBody   PrescriptionReferenceData data) throws BottomUpException {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", true);
        result.put("data", this.prescriptionReferenceService.create(data));
        return result;
    }

    @RequestMapping(value = {"/update"}, method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> update(@RequestBody   PrescriptionReferenceData data) throws BottomUpException {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", true);
        result.put("data", this.prescriptionReferenceService.update(data));
        return result;
    }

    @RequestMapping(value = "/delete/{  prescriptionReferenceID}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("  prescriptionReferenceID") Integer prescriptionReferenceID, HttpServletResponse httpResponse_p) throws BottomUpException {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("  prescriptionReferenceID", prescriptionReferenceID);
        this.prescriptionReferenceService.delete(param);
    }
}
