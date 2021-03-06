package com.bottomUp.controller.docfeed;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.controller.BaseController;
import com.bottomUp.domain.  ReferredDoctorData;

import com.bottomUp.service.docFeed.crud.ReferredDoctorService;
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
@RequestMapping("/referredDoctor")
public class ReferredDoctorController extends BaseController {

    @Autowired
    private ReferredDoctorService referredDoctorService;

    @RequestMapping(value = {"/getByParam"}, method = RequestMethod.GET)
    @ResponseBody
    public List<  ReferredDoctorData> getAll(HttpServletRequest request) throws BottomUpException {

        Map<String, Object> params = new HashMap<>();

        return this.referredDoctorService.getByParam(params);
    }

    @RequestMapping(value = {"/getByID/{  referredDoctorID}"}, method = RequestMethod.GET)
    @ResponseBody
    public   ReferredDoctorData getByID(@PathVariable("referredDoctorID") String referredDoctorID, HttpServletRequest request) throws BottomUpException {
        return this.referredDoctorService.getByID(referredDoctorID);
    }

    @RequestMapping(value = {"/save"}, method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> save(@RequestBody   ReferredDoctorData data) throws BottomUpException {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", true);
        this.referredDoctorService.create(data);
        return result;
    }

    @RequestMapping(value = {"/update"}, method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> update(@RequestBody   ReferredDoctorData data) throws BottomUpException {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", true);
        this.referredDoctorService.update(data);
        return result;
    }

    @RequestMapping(value = "/delete/{  referredDoctorID}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("  referredDoctorID") String appointmentID, HttpServletResponse httpResponse_p) throws BottomUpException {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("  referredDoctorID", appointmentID);
        this.referredDoctorService.delete(param);
    }
}
