package com.bottomUp.controller.common;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.controller.BaseController;
import com.bottomUp.domain.DoctorAdviceDiseaseTemplateData;
import com.bottomUp.service.docFeed.AppointmentTypeService;
import com.bottomUp.service.docFeed.DoctorAdviceDiseaseTemplateService;
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
@RequestMapping("/doctorAdviceDiseaseTemplate")
public class DoctorAdviceDiseaseTemplateController extends BaseController {

    @Autowired
    private DoctorAdviceDiseaseTemplateService doctorAdviceDiseaseTemplateService;

    @RequestMapping(value = {"/getByParam"}, method = RequestMethod.GET)
    @ResponseBody
    public List<DoctorAdviceDiseaseTemplateData> getAll(HttpServletRequest request) throws BottomUpException {

        Map<String, Object> params = new HashMap<>();

        return this.doctorAdviceDiseaseTemplateService.getByParam(params);
    }

    @RequestMapping(value = {"/getByID/{templateID}"}, method = RequestMethod.GET)
    @ResponseBody
    public DoctorAdviceDiseaseTemplateData getByID(@PathVariable("templateID") Integer companyID, HttpServletRequest request) throws BottomUpException {

        Map<String, Object> params = this.parseParameter(request);

        return this.doctorAdviceDiseaseTemplateService.getByID(Long.valueOf(companyID));
    }

    @RequestMapping(value = {"/save"}, method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> save(@RequestBody DoctorAdviceDiseaseTemplateData data) throws BottomUpException {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", true);
        this.doctorAdviceDiseaseTemplateService.create(data);
        return result;
    }

    @RequestMapping(value = {"/update"}, method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> update(@RequestBody DoctorAdviceDiseaseTemplateData data) throws BottomUpException {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", true);
        this.doctorAdviceDiseaseTemplateService.update(data);
        return result;
    }

    @RequestMapping(value = "/delete/{templateID}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("templateID") Integer appointmentID, HttpServletResponse httpResponse_p) throws BottomUpException {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("templateID", appointmentID);
        this.doctorAdviceDiseaseTemplateService.delete(param);
    }
}
