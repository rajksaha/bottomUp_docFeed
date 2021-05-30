package com.bottomUp.controller.docfeed;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.controller.BaseController;
import com.bottomUp.domain.DoctorHistorySettingData;
import com.bottomUp.service.docFeed.crud.DoctorHistorySettingService;
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
@RequestMapping("/doctorHistorySetting")
public class DoctorHistorySettingController extends BaseController {

    @Autowired
    private DoctorHistorySettingService doctorHistorySettingService;

    @RequestMapping(value = {"/getByParam"}, method = RequestMethod.GET)
    @ResponseBody
    public List<DoctorHistorySettingData> getAll(HttpServletRequest request) throws BottomUpException {

        Map<String, Object> params = new HashMap<>();
        return this.doctorHistorySettingService.getByParam(params);
    }

    @RequestMapping(value = {"/getByPatient/{doctorID}/{patientID}/{appointmentID}/{typeCode}"}, method = RequestMethod.GET)
    @ResponseBody
    public List<DoctorHistorySettingData> getByParam(@PathVariable("doctorID") Long doctorID,
                                                     @PathVariable("patientID") Long patientID,
                                                     @PathVariable("appointmentID") Long appointmentID,
                                                     @PathVariable("typeCode") String typeCode,
                                                     HttpServletRequest request) throws BottomUpException {

        Map<String, Object> params = new HashMap<>();
        params.put("doctorID", doctorID);
        params.put("patientID", patientID);
        params.put("appointmentID", appointmentID);
        params.put("typeCode", typeCode);
        return this.doctorHistorySettingService.getByParam(params);
    }

    @RequestMapping(value = {"/getByID/{historySettingID}"}, method = RequestMethod.GET)
    @ResponseBody
    public DoctorHistorySettingData getByID(@PathVariable("historySettingID") String historySettingID, HttpServletRequest request) throws BottomUpException {
        return this.doctorHistorySettingService.getByID(historySettingID);
    }

    @RequestMapping(value = {"/save"}, method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> save(@RequestBody DoctorHistorySettingData data) throws BottomUpException {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", true);
        this.doctorHistorySettingService.create(data);
        return result;
    }

    @RequestMapping(value = {"/update"}, method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> update(@RequestBody DoctorHistorySettingData data) throws BottomUpException {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", true);
        this.doctorHistorySettingService.update(data);
        return result;
    }

    @RequestMapping(value = "/delete/{historySettingID}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("historySettingID") String historySettingID, HttpServletResponse httpResponse_p) throws BottomUpException {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("historySettingID", historySettingID);
        this.doctorHistorySettingService.delete(param);
    }
}
