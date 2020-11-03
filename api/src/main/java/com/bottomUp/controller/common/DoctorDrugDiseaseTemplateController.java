package com.bottomUp.controller.common;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.controller.BaseController;
import com.bottomUp.domain.DoctorDrugDiseaseTemplateData;
import com.bottomUp.service.docFeed.AppointmentTypeService;
import com.bottomUp.service.docFeed.DoctorDrugDiseaseTemplateService;
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
@RequestMapping("/doctorDrugDiseaseTemplate")
public class DoctorDrugDiseaseTemplateController extends BaseController {

    @Autowired
    private DoctorDrugDiseaseTemplateService doctorDrugDiseaseTemplateService;

    @RequestMapping(value = {"/getByParam"}, method = RequestMethod.GET)
    @ResponseBody
    public List<DoctorDrugDiseaseTemplateData> getAll(HttpServletRequest request) throws BottomUpException {

        Map<String, Object> params = new HashMap<>();

        return this.doctorDrugDiseaseTemplateService.getByParam(params);
    }

    @RequestMapping(value = {"/getByID/{templateID}"}, method = RequestMethod.GET)
    @ResponseBody
    public DoctorDrugDiseaseTemplateData getByID(@PathVariable("templateID") Integer companyID, HttpServletRequest request) throws BottomUpException {

        Map<String, Object> params = this.parseParameter(request);

        return this.doctorDrugDiseaseTemplateService.getByID(Long.valueOf(companyID));
    }

    @RequestMapping(value = {"/save"}, method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> save(@RequestBody DoctorDrugDiseaseTemplateData data) throws BottomUpException {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", true);
        this.doctorDrugDiseaseTemplateService.create(data);
        return result;
    }

    @RequestMapping(value = {"/update"}, method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> update(@RequestBody DoctorDrugDiseaseTemplateData data) throws BottomUpException {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", true);
        this.doctorDrugDiseaseTemplateService.update(data);
        return result;
    }

    @RequestMapping(value = "/delete/{templateID}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("templateID") Integer appointmentID, HttpServletResponse httpResponse_p) throws BottomUpException {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("templateID", appointmentID);
        this.doctorDrugDiseaseTemplateService.delete(param);
    }
}
