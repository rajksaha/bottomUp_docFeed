package com.bottomUp.controller.docfeed;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.controller.BaseController;
import com.bottomUp.domain.DoctorVitalSettingData;
import com.bottomUp.service.docFeed.crud.DoctorVitalSettingService;
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
@RequestMapping("/doctorVitalSetting")
public class DoctorVitalSettingController extends BaseController {

    @Autowired
    private DoctorVitalSettingService doctorVitalSettingService;

    @RequestMapping(value = {"/getByDoctorVitalInfo/{doctorID}/{appointmentID}"}, method = RequestMethod.GET)
    @ResponseBody
    public  List<DoctorVitalSettingData> getByDoctorID(@PathVariable("doctorID") Long doctorID,@PathVariable("appointmentID") Long appointmentID,  HttpServletRequest request) throws BottomUpException {
        Map<String, Object> params = new HashMap<>();
        params.put("doctorID", doctorID);
        params.put("appointmentID", appointmentID);
        return this.doctorVitalSettingService.getByDoctorParam(params);
    }

    @RequestMapping(value = {"/save"}, method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> save(@RequestBody DoctorVitalSettingData data) throws BottomUpException {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", true);
        this.doctorVitalSettingService.create(data);
        return result;
    }

    @RequestMapping(value = {"/update"}, method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> update(@RequestBody DoctorVitalSettingData data) throws BottomUpException {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", true);
        this.doctorVitalSettingService.update(data);
        return result;
    }

    @RequestMapping(value = "/delete/{vitalSettingID}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("vitalSettingID") String appointmentID, HttpServletResponse httpResponse_p) throws BottomUpException {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("vitalSettingID", appointmentID);
        this.doctorVitalSettingService.delete(param);
    }
}
