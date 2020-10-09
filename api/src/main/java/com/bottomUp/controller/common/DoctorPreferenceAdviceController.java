package com.bottomUp.controller.common;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.controller.BaseController;
import com.bottomUp.domain.DoctorPreferenceAdviceData;
import com.bottomUp.service.docFeed.AppointmentTypeService;
import com.bottomUp.service.docFeed.DoctorPreferenceAdviceService;
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
@RequestMapping("/doctorPreferenceAdvice")
public class DoctorPreferenceAdviceController extends BaseController {

    @Autowired
    private DoctorPreferenceAdviceService doctorPreferenceAdviceService;

    @RequestMapping(value = {"/getByParam"}, method = RequestMethod.GET)
    @ResponseBody
    public List<DoctorPreferenceAdviceData> getAll(HttpServletRequest request) throws BottomUpException {

        Map<String, Object> params = new HashMap<>();

        return this.doctorPreferenceAdviceService.getByParam(params);
    }

    @RequestMapping(value = {"/getByID/{advicePreferenceID}"}, method = RequestMethod.GET)
    @ResponseBody
    public DoctorPreferenceAdviceData getByID(@PathVariable("advicePreferenceID") Integer advicePreferenceID, HttpServletRequest request) throws BottomUpException {

        //Map<String, Object> params = this.parseParameter(request);

        return this.doctorPreferenceAdviceService.getByID(Long.valueOf(advicePreferenceID));
    }

    @RequestMapping(value = {"/save"}, method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> save(@RequestBody DoctorPreferenceAdviceData data) throws BottomUpException {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", true);
        result.put("data",  this.doctorPreferenceAdviceService.create(data));
        return result;
    }

    @RequestMapping(value = {"/update"}, method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> update(@RequestBody DoctorPreferenceAdviceData data) throws BottomUpException {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", true);
        result.put("data",  this.doctorPreferenceAdviceService.update(data));
        return result;
    }

    @RequestMapping(value = "/delete/{advicePreferenceID}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("advicePreferenceID") Integer advicePreferenceID, HttpServletResponse httpResponse_p) throws BottomUpException {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("advicePreferenceID", advicePreferenceID);
        this.doctorPreferenceAdviceService.delete(param);
    }
}
