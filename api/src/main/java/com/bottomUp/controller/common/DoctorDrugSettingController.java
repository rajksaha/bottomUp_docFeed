package com.bottomUp.controller.common;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.controller.BaseController;
import com.bottomUp.domain.AppointmentTypeData;
import com.bottomUp.domain.DoctorDrugSettingData;
import com.bottomUp.domain.DoctorSettingData;
import com.bottomUp.service.docFeed.AppointmentTypeService;
import com.bottomUp.service.docFeed.DoctorDrugSettingService;
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
@RequestMapping("/doctorDrugSetting")
public class DoctorDrugSettingController extends BaseController {

    @Autowired
    private DoctorDrugSettingService doctorDrugSettingService;

    @RequestMapping(value = {"/getByParam"}, method = RequestMethod.GET)
    @ResponseBody
    public List<DoctorDrugSettingData> getAll(HttpServletRequest request) throws BottomUpException {

        Map<String, Object> params = new HashMap<>();

        return this.doctorDrugSettingService.getByParam(params);
    }

    @RequestMapping(value = {"/getByID/{drugSettingID}"}, method = RequestMethod.GET)
    @ResponseBody
    public DoctorDrugSettingData getByID(@PathVariable("drugSettingID") Integer drugSettingID, HttpServletRequest request) throws BottomUpException {

        //Map<String, Object> params = this.parseParameter(request);

        return this.doctorDrugSettingService.getByID(Long.valueOf(drugSettingID));
    }

    @RequestMapping(value = {"/save"}, method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> save(@RequestBody DoctorDrugSettingData data) throws BottomUpException {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", true);
        result.put("data", this.doctorDrugSettingService.create(data));
        return result;
    }

    @RequestMapping(value = {"/update"}, method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> update(@RequestBody DoctorDrugSettingData data) throws BottomUpException {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", true);
        result.put("data", this.doctorDrugSettingService.update(data));
        return result;
    }

    @RequestMapping(value = "/delete/{drugSettingID}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("drugSettingID") Integer drugSettingID, HttpServletResponse httpResponse_p) throws BottomUpException {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("drugSettingID", drugSettingID);
        this.doctorDrugSettingService.delete(param);
    }
}
