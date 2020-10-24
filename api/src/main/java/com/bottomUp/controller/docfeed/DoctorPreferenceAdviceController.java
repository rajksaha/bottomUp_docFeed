package com.bottomUp.controller.docfeed;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.controller.BaseController;
import com.bottomUp.domain.DoctorPreferenceAdviceData;
import com.bottomUp.service.docFeed.crud.DoctorPreferenceAdviceService;
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
    public DoctorPreferenceAdviceData getByID(@PathVariable("advicePreferenceID") Integer companyID, HttpServletRequest request) throws BottomUpException {

        Map<String, Object> params = this.parseParameter(request);

        return this.doctorPreferenceAdviceService.getByID(Long.valueOf(companyID));
    }

    @RequestMapping(value = {"/save"}, method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> save(@RequestBody DoctorPreferenceAdviceData data) throws BottomUpException {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", true);
        this.doctorPreferenceAdviceService.create(data);
        return result;
    }

    @RequestMapping(value = {"/update"}, method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> update(@RequestBody DoctorPreferenceAdviceData data) throws BottomUpException {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", true);
        this.doctorPreferenceAdviceService.update(data);
        return result;
    }

    @RequestMapping(value = "/delete/{advicePreferenceID}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("advicePreferenceID") Integer appointmentID, HttpServletResponse httpResponse_p) throws BottomUpException {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("advicePreferenceID", appointmentID);
        this.doctorPreferenceAdviceService.delete(param);
    }
}
