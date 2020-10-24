package com.bottomUp.controller.docfeed;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.controller.BaseController;
import com.bottomUp.domain.PrescriptionDiagnosisData;
import com.bottomUp.service.docFeed.crud.PrescriptionDiagnosisService;
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
@RequestMapping("/prescriptionDiagnosis")
public class PrescriptionDiagnosisController extends BaseController {

    @Autowired
    private PrescriptionDiagnosisService prescriptionDiagnosisService;

    @RequestMapping(value = {"/getByParam"}, method = RequestMethod.GET)
    @ResponseBody
    public List<PrescriptionDiagnosisData> getAll(HttpServletRequest request) throws BottomUpException {

        Map<String, Object> params = new HashMap<>();

        return this.prescriptionDiagnosisService.getByParam(params);
    }

    @RequestMapping(value = {"/getByID/{diagnosisID}"}, method = RequestMethod.GET)
    @ResponseBody
    public PrescriptionDiagnosisData getByID(@PathVariable("diagnosisID") Integer companyID, HttpServletRequest request) throws BottomUpException {

        Map<String, Object> params = this.parseParameter(request);

        return this.prescriptionDiagnosisService.getByID(Long.valueOf(companyID));
    }

    @RequestMapping(value = {"/save"}, method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> save(@RequestBody PrescriptionDiagnosisData data) throws BottomUpException {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", true);
        this.prescriptionDiagnosisService.create(data);
        return result;
    }

    @RequestMapping(value = {"/update"}, method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> update(@RequestBody PrescriptionDiagnosisData data) throws BottomUpException {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", true);
        this.prescriptionDiagnosisService.update(data);
        return result;
    }

    @RequestMapping(value = "/delete/{diagnosisID}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("diagnosisID") Integer appointmentID, HttpServletResponse httpResponse_p) throws BottomUpException {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("diagnosisID", appointmentID);
        this.prescriptionDiagnosisService.delete(param);
    }
}
