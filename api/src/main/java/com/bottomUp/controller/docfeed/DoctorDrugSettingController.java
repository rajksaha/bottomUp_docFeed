package com.bottomUp.controller.docfeed;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.controller.BaseController;
import com.bottomUp.domain.AppointmentTypeData;
import com.bottomUp.service.docFeed.crud.AppointmentTypeService;
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
    private AppointmentTypeService appointmentTypeService;

    @RequestMapping(value = {"/getByParam"}, method = RequestMethod.GET)
    @ResponseBody
    public List<AppointmentTypeData> getAll(HttpServletRequest request) throws BottomUpException {

        Map<String, Object> params = new HashMap<>();

        return this.appointmentTypeService.getByParam(params);
    }

    @RequestMapping(value = {"/getByID/{drugSettingID}"}, method = RequestMethod.GET)
    @ResponseBody
    public AppointmentTypeData getByID(@PathVariable("drugSettingID") Integer companyID, HttpServletRequest request) throws BottomUpException {

        Map<String, Object> params = this.parseParameter(request);

        return this.appointmentTypeService.getByID(Long.valueOf(companyID));
    }

    @RequestMapping(value = {"/save"}, method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> save(@RequestBody AppointmentTypeData data) throws BottomUpException {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", true);
        this.appointmentTypeService.create(data);
        return result;
    }

    @RequestMapping(value = {"/update"}, method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> update(@RequestBody AppointmentTypeData data) throws BottomUpException {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", true);
        this.appointmentTypeService.update(data);
        return result;
    }

    @RequestMapping(value = "/delete/{drugSettingID}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("drugSettingID") Integer appointmentID, HttpServletResponse httpResponse_p) throws BottomUpException {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("drugSettingID", appointmentID);
        this.appointmentTypeService.delete(param);
    }
}
