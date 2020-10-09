package com.bottomUp.controller.common;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.controller.BaseController;
import com.bottomUp.domain.  PrescriptionPastDiseaseData;
import com.bottomUp.service.docFeed.AppointmentTypeService;
import com.bottomUp.service.docFeed.PrescriptionPastDiseaseService;
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
@RequestMapping("/prescriptionPastDisease")
public class PrescriptionPastDiseaseController extends BaseController {

    @Autowired
    private PrescriptionPastDiseaseService prescriptionPastDiseaseService;

    @RequestMapping(value = {"/getByParam"}, method = RequestMethod.GET)
    @ResponseBody
    public List<  PrescriptionPastDiseaseData> getAll(HttpServletRequest request) throws BottomUpException {

        Map<String, Object> params = new HashMap<>();

        return this.prescriptionPastDiseaseService.getByParam(params);
    }

    @RequestMapping(value = {"/getByID/{  presPastDiseaseID}"}, method = RequestMethod.GET)
    @ResponseBody
    public   PrescriptionPastDiseaseData getByID(@PathVariable("  presPastDiseaseID") Integer presPastDiseaseID, HttpServletRequest request) throws BottomUpException {

        //Map<String, Object> params = this.parseParameter(request);

        return this.prescriptionPastDiseaseService.getByID(Long.valueOf(presPastDiseaseID));
    }

    @RequestMapping(value = {"/save"}, method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> save(@RequestBody   PrescriptionPastDiseaseData data) throws BottomUpException {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", true);
        result.put("data", this.prescriptionPastDiseaseService.create(data));
        return result;
    }

    @RequestMapping(value = {"/update"}, method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> update(@RequestBody   PrescriptionPastDiseaseData data) throws BottomUpException {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", true);
        result.put("data", this.prescriptionPastDiseaseService.update(data));
        return result;
    }

    @RequestMapping(value = "/delete/{  presPastDiseaseID}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("  presPastDiseaseID") Integer presPastDiseaseID, HttpServletResponse httpResponse_p) throws BottomUpException {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("  presPastDiseaseID", presPastDiseaseID);
        this.prescriptionPastDiseaseService.delete(param);
    }
}
