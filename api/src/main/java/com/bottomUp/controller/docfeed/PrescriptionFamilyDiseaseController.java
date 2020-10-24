package com.bottomUp.controller.docfeed;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.controller.BaseController;
import com.bottomUp.domain.PrescriptionFamilyDiseaseData;
import com.bottomUp.service.docFeed.crud.PrescriptionFamilyDiseaseService;
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
@RequestMapping("/prescriptionFamilyDisease")
public class PrescriptionFamilyDiseaseController extends BaseController {

    @Autowired
    private PrescriptionFamilyDiseaseService prescriptionFamilyDiseaseService;

    @RequestMapping(value = {"/getByParam"}, method = RequestMethod.GET)
    @ResponseBody
    public List<PrescriptionFamilyDiseaseData> getAll(HttpServletRequest request) throws BottomUpException {

        Map<String, Object> params = new HashMap<>();

        return this.prescriptionFamilyDiseaseService.getByParam(params);
    }

    @RequestMapping(value = {"/getByID/{presFamilyDiseaseID}"}, method = RequestMethod.GET)
    @ResponseBody
    public PrescriptionFamilyDiseaseData getByID(@PathVariable("presFamilyDiseaseID") Integer companyID, HttpServletRequest request) throws BottomUpException {

        Map<String, Object> params = this.parseParameter(request);

        return this.prescriptionFamilyDiseaseService.getByID(Long.valueOf(companyID));
    }

    @RequestMapping(value = {"/save"}, method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> save(@RequestBody PrescriptionFamilyDiseaseData data) throws BottomUpException {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", true);
        this.prescriptionFamilyDiseaseService.create(data);
        return result;
    }

    @RequestMapping(value = {"/update"}, method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> update(@RequestBody PrescriptionFamilyDiseaseData data) throws BottomUpException {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", true);
        this.prescriptionFamilyDiseaseService.update(data);
        return result;
    }

    @RequestMapping(value = "/delete/{presFamilyDiseaseID}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("presFamilyDiseaseID") Integer appointmentID, HttpServletResponse httpResponse_p) throws BottomUpException {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("presFamilyDiseaseID", appointmentID);
        this.prescriptionFamilyDiseaseService.delete(param);
    }
}
