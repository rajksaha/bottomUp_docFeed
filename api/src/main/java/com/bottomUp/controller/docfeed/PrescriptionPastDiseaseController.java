package com.bottomUp.controller.docfeed;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.controller.BaseController;
import com.bottomUp.domain.  PrescriptionPastDiseaseData;
import com.bottomUp.service.docFeed.crud.PrescriptionPastDiseaseService;
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

    @RequestMapping(value = {"/getByID/{presPastDiseaseID}"}, method = RequestMethod.GET)
    @ResponseBody
    public   PrescriptionPastDiseaseData getByID(@PathVariable("presPastDiseaseID") String presPastDiseaseID, HttpServletRequest request) throws BottomUpException {
        return this.prescriptionPastDiseaseService.getByID(presPastDiseaseID);
    }

    @RequestMapping(value = {"/add/{pastDiseaseID}/{appointmentID}"}, method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> add(HttpServletRequest request, @PathVariable String pastDiseaseID, @PathVariable String appointmentID) throws BottomUpException {
        PrescriptionPastDiseaseData data = new PrescriptionPastDiseaseData();
        data.setAppointmentID(appointmentID);
        data.setPastDiseaseID(pastDiseaseID);
        this.prescriptionPastDiseaseService.create(data);
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("presPastDiseaseID", data.getPresPastDiseaseID());
        return result;
    }

    @RequestMapping(value = {"/save"}, method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> save(@RequestBody   PrescriptionPastDiseaseData data) throws BottomUpException {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", true);
        this.prescriptionPastDiseaseService.create(data);
        return result;
    }

    @RequestMapping(value = {"/update"}, method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> update(@RequestBody   PrescriptionPastDiseaseData data) throws BottomUpException {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", true);
        this.prescriptionPastDiseaseService.update(data);
        return result;
    }

    @RequestMapping(value = "/delete/{  presPastDiseaseID}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("  presPastDiseaseID") String appointmentID, HttpServletResponse httpResponse_p) throws BottomUpException {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("  presPastDiseaseID", appointmentID);
        this.prescriptionPastDiseaseService.delete(param);
    }
}
