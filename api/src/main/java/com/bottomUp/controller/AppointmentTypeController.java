package com.bottomUp.controller;

import com.bottomUp.common.exception.BottomUpException;

import com.bottomUp.domain.AppointmentTypeData;
import com.bottomUp.service.docFeed.AppointmentTypeService;
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
@RequestMapping("/appointmentType")
public class AppointmentTypeController extends BaseController {

    @Autowired
    private AppointmentTypeService appointmentTypeService;

    @RequestMapping(value = {"/getByParam"}, method = RequestMethod.GET)
    @ResponseBody
    public List<AppointmentTypeData> getAll(HttpServletRequest request) throws BottomUpException {

        Map<String, Object> params = new HashMap<>();

        return this.appointmentTypeService.getByParam(params);
    }

    @RequestMapping(value = {"/getByID/{appointmentTypeID}"}, method = RequestMethod.GET)
    @ResponseBody
    public AppointmentTypeData getByID(@PathVariable("appointmentTypeID") Integer appointmentTypeID, HttpServletRequest request) throws BottomUpException {

       // Map<String, Object> params = this.parseParameter(request);

        return this.appointmentTypeService.getByID(Long.valueOf(appointmentTypeID));
    }

    @RequestMapping(value = {"/save"}, method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> save(@RequestBody AppointmentTypeData data) throws BottomUpException {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", true);
        this.appointmentTypeService.create(data);
        result.put("data", data);
        return result;
    }

    @RequestMapping(value = {"/update"}, method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> update(@RequestBody AppointmentTypeData data) throws BottomUpException {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", true);
        this.appointmentTypeService.update(data);
        result.put("data", data);
        return result;
    }

    @RequestMapping(value = "/delete/{appointmentTypeID}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("appointmentTypeID") Integer appointmentTypeID, HttpServletResponse httpResponse_p) throws BottomUpException {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("appointmentTypeID",appointmentTypeID);
        this.appointmentTypeService.delete(param);
    }
}
