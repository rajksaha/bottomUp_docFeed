package com.bottomUp.controller.common;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.controller.BaseController;
import com.bottomUp.domain.DoctorInvDiseaseTemplateData;
import com.bottomUp.service.docFeed.DoctorInvDiseaseTemplateService;
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
    public DoctorInvDiseaseTemplateData getByID(@PathVariable("templateID") Integer templateID, HttpServletRequest request) throws BottomUpException {

        //Map<String, Object> params = this.parseParameter(request);

        return this.doctorInvDiseaseTemplateService.getByID(Long.valueOf(templateID));
    }

    @RequestMapping(value = {"/save"}, method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> save(@RequestBody DoctorInvDiseaseTemplateData data) throws BottomUpException {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", true);
        result.put("data", this.doctorInvDiseaseTemplateService.create(data));
        return result;
    }

    @RequestMapping(value = {"/update"}, method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> update(@RequestBody DoctorInvDiseaseTemplateData data) throws BottomUpException {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", true);
        result.put("data", this.doctorInvDiseaseTemplateService.update(data));
        return result;
    }

    @RequestMapping(value = "/delete/{templateID}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("templateID") Integer templateID, HttpServletResponse httpResponse_p) throws BottomUpException {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("templateID", templateID);
        this.doctorInvDiseaseTemplateService.delete(param);
    }
}
