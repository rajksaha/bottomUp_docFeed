package com.bottomUp.controller.common;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.controller.BaseController;
import com.bottomUp.domain.DoctorFollowUpSettingData;
import com.bottomUp.service.docFeed.AppointmentTypeService;
import com.bottomUp.service.docFeed.DoctorFollowUpSettingService;
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

        return this.doctorFollowUpSettingService.getByParam(params);
    }

    @RequestMapping(value = {"/getByID/{followUpSettingID}"}, method = RequestMethod.GET)
    @ResponseBody
    public DoctorFollowUpSettingData getByID(@PathVariable("followUpSettingID") Integer followUpSettingID, HttpServletRequest request) throws BottomUpException {

       // Map<String, Object> params = this.parseParameter(request);

        return this.doctorFollowUpSettingService.getByID(Long.valueOf(followUpSettingID));
    }

    @RequestMapping(value = {"/save"}, method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> save(@RequestBody DoctorFollowUpSettingData data) throws BottomUpException {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", true);
        result.put("data", this.doctorFollowUpSettingService.create(data));
        return result;
    }

    @RequestMapping(value = {"/update"}, method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> update(@RequestBody DoctorFollowUpSettingData data) throws BottomUpException {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", true);
        result.put("data", this.doctorFollowUpSettingService.update(data));
        return result;
    }

    @RequestMapping(value = "/delete/{followUpSettingID}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("followUpSettingID") Integer followUpSettingID, HttpServletResponse httpResponse_p) throws BottomUpException {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("followUpSettingID", followUpSettingID);
        this.doctorFollowUpSettingService.delete(param);
    }
}
