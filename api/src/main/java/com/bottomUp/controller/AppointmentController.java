package com.bottomUp.controller;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.common.utility.SearchData;
import com.bottomUp.domain.AppointmentData;
import com.bottomUp.model.AppointmentViewData;
import com.bottomUp.model.DoctorDashboardData;
import com.bottomUp.service.docFeed.AppointmentViewService;
import com.bottomUp.service.docFeed.crud.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import utility.DateUtil;

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

    @Autowired
    private AppointmentViewService appointmentViewService;

    @RequestMapping(value = {"/visitPatient"}, method = RequestMethod.POST)
    @ResponseBody
    public void visitPatient(HttpServletRequest request, @RequestBody SearchData searchData) throws BottomUpException {
        this.getUserDetail().setAppointmentID(searchData.getAppointmentID());
    }

    @RequestMapping(value = {"/getByParam"}, method = RequestMethod.GET)
    @ResponseBody
    public List<AppointmentViewData> getByParam(HttpServletRequest request) throws BottomUpException {

        Map<String, Object> params = new HashMap<>();
        params.put("appDate", DateUtil.getDateOnly(new Date()));
        params.put("doctorID", this.getUserDetail().getDoctorData().getDoctorID());
        params.put("lastVisit", true);
        return this.appointmentService.getAppPatientDetail(params);
    }

    @RequestMapping(value = {"/getByLastVisit"}, method = RequestMethod.GET)
    @ResponseBody
    public List<AppointmentViewData> getByLastVisit(HttpServletRequest request) throws BottomUpException {
        Map<String, Object> params = new HashMap<>();
        params.put("appDate", DateUtil.getDateOnly(new Date()));
        params.put("doctorID", this.getUserDetail().getDoctorData().getDoctorID());
        return this.appointmentService.getAppPatientDetail(params);
    }

    @RequestMapping(value = {"/getDoctorDashboard"}, method = RequestMethod.GET)
    @ResponseBody
    public DoctorDashboardData getDoctorDashboard(HttpServletRequest request) throws BottomUpException {

        Map<String, Object> params = new HashMap<>();
        params.put("appDate", DateUtil.getDateOnly(new Date()));
        params.put("doctorID", this.getUserDetail().getDoctorData().getDoctorID());
        return this.appointmentViewService.getDoctorDashboard(params);
    }

    @RequestMapping(value = {"/getCurrentAppointment"}, method = RequestMethod.GET)
    @ResponseBody
    public AppointmentData getCurrentAppointment(HttpServletRequest request) throws BottomUpException {
        return this.appointmentService.getByID(this.getUserDetail().getAppointmentID());
    }

    @RequestMapping(value = {"/getCurrAppDetail"}, method = RequestMethod.GET)
    @ResponseBody
    public AppointmentViewData getCurrentAppDetail(HttpServletRequest request) throws BottomUpException {
        Map<String, Object> params = new HashMap<>();
        params.put("appointmentID", this.getUserDetail().getAppointmentID());
        List<AppointmentViewData> dataList = this.appointmentService.getAppPatientDetail(params);
        if(dataList != null && dataList.size() > 0){
            return dataList.get(0);
        }
        return null;
    }

    @RequestMapping(value = {"/getByID/{appointmentID}"}, method = RequestMethod.GET)
    @ResponseBody
    public AppointmentData getByID(@PathVariable("appointmentID") Integer companyID, HttpServletRequest request) throws BottomUpException {
        return this.appointmentService.getByID(Long.valueOf(companyID));
    }

    @RequestMapping(value = {"/createFollowUpApp"}, method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> save(@RequestBody AppointmentViewData data) throws BottomUpException {
        Map<String, Object> result = new HashMap<String, Object>();
        data.setDoctorID(this.getUserDetail().getDoctorData().getDoctorID());
        this.appointmentViewService.createForFollowUpPatient(data);
        result.put("success", true);
        result.put("appointmentData", data);
        return result;
    }

    @RequestMapping(value = {"/createAppForNewPatient"}, method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> createAppForNewPatient(@RequestBody AppointmentViewData viewData) throws BottomUpException {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", true);
        viewData.setDoctorID(this.getUserDetail().getDoctorData().getDoctorID());
        appointmentViewService.createForNewPatient(viewData, this.getUserDetail().getCompanyData().getCompanyID());
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
        this.appointmentService.updateStatusByID(data.getAppointmentID(), data.getIntStatus());
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
