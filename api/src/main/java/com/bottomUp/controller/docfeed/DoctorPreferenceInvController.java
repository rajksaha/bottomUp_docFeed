package com.bottomUp.controller.docfeed;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.controller.BaseController;
import com.bottomUp.domain.DoctorPreferenceInvData;
import com.bottomUp.service.docFeed.crud.DoctorPreferenceInvService;
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
@RequestMapping("/doctorPreferenceInv")
public class DoctorPreferenceInvController extends BaseController {

    @Autowired
    private DoctorPreferenceInvService doctorPreferenceInvService;

    @RequestMapping(value = {"/getByDoctorID/{doctorID}"}, method = RequestMethod.GET)
    @ResponseBody
    public List<DoctorPreferenceInvData> getAll(@PathVariable("doctorID") Long doctorID,
                                                HttpServletRequest request) throws BottomUpException {

        Map<String, Object> params = new HashMap<>();
        params.put("doctorID", doctorID);
        return this.doctorPreferenceInvService.getByParam(params);
    }

    @RequestMapping(value = {"/getByID/{invPreferenceID}"}, method = RequestMethod.GET)
    @ResponseBody
    public DoctorPreferenceInvData getByID(@PathVariable("invPreferenceID") String invPreferenceID, HttpServletRequest request) throws BottomUpException {
        return this.doctorPreferenceInvService.getByID(invPreferenceID);
    }

    @RequestMapping(value = {"/getDoctorPrefInv/{doctorID}/{appointmentID}/{categoryID}"}, method = RequestMethod.GET)
    @ResponseBody
    public List<DoctorPreferenceInvData> getDoctorPrefInv(@PathVariable("doctorID") Long doctorID,
                                                          @PathVariable("appointmentID") Long appointmentID,
                                                          @PathVariable("categoryID") Long categoryID,
                                                          HttpServletRequest request) throws BottomUpException {
        Map<String, Object> params = new HashMap<>();
        params.put("doctorID", doctorID);
        params.put("appointmentID", appointmentID);
        if(categoryID != Long.valueOf(-1)){
            params.put("categoryID", categoryID);
        }
        return this.doctorPreferenceInvService.getByParam(params);
    }

    @RequestMapping(value = {"/save"}, method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> save(@RequestBody DoctorPreferenceInvData data) throws BottomUpException {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", true);
        this.doctorPreferenceInvService.create(data);
        return result;
    }

    @RequestMapping(value = {"/update"}, method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> update(@RequestBody DoctorPreferenceInvData data) throws BottomUpException {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", true);
        this.doctorPreferenceInvService.update(data);
        return result;
    }

    @RequestMapping(value = "/delete/{invPreferenceID}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("invPreferenceID") String invPreferenceID, HttpServletResponse httpResponse_p) throws BottomUpException {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("invPreferenceID", invPreferenceID);
        this.doctorPreferenceInvService.delete(param);
    }
}
