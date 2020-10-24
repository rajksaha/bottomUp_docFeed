package com.bottomUp.controller.docfeed;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.common.utility.SearchData;
import com.bottomUp.controller.BaseController;
import com.bottomUp.domain.AppointmentData;
import com.bottomUp.service.docFeed.crud.AppointmentService;
import com.bottomUp.utility.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by raj on 8/9/2020.
 */
@Controller
@RequestMapping("/appointment")
public class AppointmentController extends BaseController {

    @Autowired
    private AppointmentService appointmentService;

    @RequestMapping(value = {"/visitPatient"}, method = RequestMethod.POST)
    @ResponseBody
    public void visitPatient(HttpServletRequest request, @RequestBody SearchData searchData) throws BottomUpException {
        this.getUserDetail().setAppointmentID(searchData.getAppointmentID());
    }

    @RequestMapping(value = {"/getByParam"}, method = RequestMethod.GET)
    @ResponseBody
    public List<AppointmentData> getByParam(HttpServletRequest request) throws BottomUpException {

        Map<String, Object> params = new HashMap<>();
        params.put("date", DateUtil.getDateOnly(new Date()));
        params.put("doctorID", this.getUserDetail().getDoctorData().getDoctorID());
        return this.appointmentService.getByParam(params);
    }

    @RequestMapping(value = {"/getByID/{appointmentID}"}, method = RequestMethod.GET)
    @ResponseBody
    public AppointmentData getByID(@PathVariable("appointmentID") Integer companyID, HttpServletRequest request) throws BottomUpException {
        return this.appointmentService.getByID(Long.valueOf(companyID));
    }

    @RequestMapping(value = {"/save"}, method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> save(@RequestBody AppointmentData data) throws BottomUpException {
        Map<String, Object> result = new HashMap<String, Object>();
        this.appointmentService.create(data);
        result.put("success", true);
        result.put("appointmentData", data);
        return result;
    }

    @RequestMapping(value = {"/update"}, method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> update(@RequestBody AppointmentData data) throws BottomUpException {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", true);
        this.appointmentService.update(data);
        result.put("appointmentData", data);
        return result;
    }

    @RequestMapping(value = {"/updateStatus"}, method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> updateStatus(@RequestBody SearchData data) throws BottomUpException {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("appointmentID", data.getAppointmentID());
        param.put("status", data.getIntStatus());
        this.appointmentService.updateStatusByID(param);
        param.put("success", true);
        return param;
    }

    @RequestMapping(value = "/delete/{appointmentID}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("appointmentID") Integer appointmentID, HttpServletResponse httpResponse_p) throws BottomUpException {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("appointmentID", appointmentID);
        this.appointmentService.delete(param);
    }
}