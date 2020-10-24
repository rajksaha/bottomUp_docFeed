package com.bottomUp.controller.docfeed;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.controller.BaseController;
import com.bottomUp.domain.DoctorInvDiseaseTemplateData;
import com.bottomUp.service.docFeed.crud.DoctorInvDiseaseTemplateService;
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
@RequestMapping("/doctorInvDiseaseTemplate")
public class DoctorInvDiseaseTemplateController extends BaseController {

    @Autowired
    private DoctorInvDiseaseTemplateService doctorInvDiseaseTemplateService;

    @RequestMapping(value = {"/getByParam"}, method = RequestMethod.GET)
    @ResponseBody
    public List<DoctorInvDiseaseTemplateData> getAll(HttpServletRequest request) throws BottomUpException {

        Map<String, Object> params = new HashMap<>();

        return this.doctorInvDiseaseTemplateService.getByParam(params);
    }

    @RequestMapping(value = {"/getByID/{templateID}"}, method = RequestMethod.GET)
    @ResponseBody
    public DoctorInvDiseaseTemplateData getByID(@PathVariable("templateID") Integer companyID, HttpServletRequest request) throws BottomUpException {

        Map<String, Object> params = this.parseParameter(request);

        return this.doctorInvDiseaseTemplateService.getByID(Long.valueOf(companyID));
    }

    @RequestMapping(value = {"/save"}, method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> save(@RequestBody DoctorInvDiseaseTemplateData data) throws BottomUpException {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", true);
        this.doctorInvDiseaseTemplateService.create(data);
        return result;
    }

    @RequestMapping(value = {"/update"}, method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> update(@RequestBody DoctorInvDiseaseTemplateData data) throws BottomUpException {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", true);
        this.doctorInvDiseaseTemplateService.update(data);
        return result;
    }

    @RequestMapping(value = "/delete/{templateID}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("templateID") Integer appointmentID, HttpServletResponse httpResponse_p) throws BottomUpException {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("templateID", appointmentID);
        this.doctorInvDiseaseTemplateService.delete(param);
    }
}
