package com.bottomUp.controller.common;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.controller.BaseController;
import com.bottomUp.domain.DoctorDoseDrugDiseaseTemplateData;
import com.bottomUp.service.docFeed.AppointmentTypeService;
import com.bottomUp.service.docFeed.DoctorDoseDrugDiseaseTemplateService;
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
@RequestMapping("/doctorDoseDrugDiseaseTemplate")
public class DoctorDoseDrugDiseaseTemplateController extends BaseController {

    @Autowired
    private DoctorDoseDrugDiseaseTemplateService doctorDoseDrugDiseaseTemplateService;

    @RequestMapping(value = {"/getByParam"}, method = RequestMethod.GET)
    @ResponseBody
    public List<DoctorDoseDrugDiseaseTemplateData> getAll(HttpServletRequest request) throws BottomUpException {

        Map<String, Object> params = new HashMap<>();

        return this.doctorDoseDrugDiseaseTemplateService.getByParam(params);
    }

    @RequestMapping(value = {"/getByID/{templateID}"}, method = RequestMethod.GET)
    @ResponseBody
    public DoctorDoseDrugDiseaseTemplateData getByID(@PathVariable("templateID") Integer templateID, HttpServletRequest request) throws BottomUpException {

        Map<String, Object> params = this.parseParameter(request);

        return this.doctorDoseDrugDiseaseTemplateService.getByID(Long.valueOf(templateID));
    }

    @RequestMapping(value = {"/save"}, method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> save(@RequestBody DoctorDoseDrugDiseaseTemplateData data) throws BottomUpException {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", true);
        this.doctorDoseDrugDiseaseTemplateService.create(data);
        return result;
    }

    @RequestMapping(value = {"/update"}, method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> update(@RequestBody DoctorDoseDrugDiseaseTemplateData data) throws BottomUpException {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", true);
        this.doctorDoseDrugDiseaseTemplateService.update(data);
        return result;
    }

    @RequestMapping(value = "/delete/{templateID}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("templateID") Integer templateID, HttpServletResponse httpResponse_p) throws BottomUpException {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("templateID", templateID);
        this.doctorDoseDrugDiseaseTemplateService.delete(param);
    }
}
