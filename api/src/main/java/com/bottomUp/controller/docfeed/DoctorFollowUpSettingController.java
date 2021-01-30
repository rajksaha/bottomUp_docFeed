package com.bottomUp.controller.docfeed;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.common.utility.SearchData;
import com.bottomUp.controller.BaseController;
import com.bottomUp.domain.DoctorFollowUpSettingData;
import com.bottomUp.service.docFeed.crud.DoctorFollowUpSettingService;
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
@RequestMapping("/doctorFollowUpSetting")
public class DoctorFollowUpSettingController extends BaseController {

    @Autowired
    private DoctorFollowUpSettingService doctorFollowUpSettingService;

    @RequestMapping(value = {"/getByParam"}, method = RequestMethod.GET)
    @ResponseBody
    public List<DoctorFollowUpSettingData> getAll(HttpServletRequest request) throws BottomUpException {
        Map<String, Object> params = new HashMap<>();
        if(this.getUserDetail().getDoctorData() != null){
            params.put("doctorID", this.getUserDetail().getDoctorData().getDoctorID());
        }
        return this.doctorFollowUpSettingService.getByParam(params);
    }

    @RequestMapping(value = {"/getByID/{followUpSettingID}"}, method = RequestMethod.GET)
    @ResponseBody
    public DoctorFollowUpSettingData getByID(@PathVariable("followUpSettingID") Long followUpSettingID, HttpServletRequest request) throws BottomUpException {
        return this.doctorFollowUpSettingService.getByID(followUpSettingID);
    }

    @RequestMapping(value = {"/getByPatientType/{doctorID}/{patientTypeID}"}, method = RequestMethod.GET)
    @ResponseBody
    public List<DoctorFollowUpSettingData> getByPatientType(@PathVariable("doctorID") Long doctorID,
                                                            @PathVariable("patientTypeID") Long patientTypeID,
                                                            HttpServletRequest request) throws BottomUpException {
        Map<String, Object> params = new HashMap<>();
        params.put("doctorID", doctorID);
        params.put("patientTypeID", patientTypeID);
        return this.doctorFollowUpSettingService.getByParam(params);
    }

    @RequestMapping(value = {"/create"}, method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> save(@RequestBody DoctorFollowUpSettingData data) throws BottomUpException {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", true);
        this.doctorFollowUpSettingService.create(data);
        return result;
    }

    @RequestMapping(value = {"/update"}, method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> update(@RequestBody DoctorFollowUpSettingData data) throws BottomUpException {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", true);
        this.doctorFollowUpSettingService.update(data);
        return result;
    }

    @RequestMapping(value = {"/updateDisplayOrder"}, method = RequestMethod.POST)
    @ResponseBody
    public void updateDisplayOrder(@RequestBody SearchData data) throws BottomUpException {
        this.doctorFollowUpSettingService.updateDisplayOrder(data.getFollowUpSettingList());
    }

    @RequestMapping(value = "/delete/{followUpSettingID}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("followUpSettingID") Long followUpSettingID, HttpServletResponse httpResponse_p) throws BottomUpException {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("followUpSettingID", followUpSettingID);
        this.doctorFollowUpSettingService.delete(param);
    }
}
