package com.bottomUp.controller.common;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.controller.BaseController;
import com.bottomUp.domain.DoctorDrugDoseSettingData;
import com.bottomUp.service.docFeed.AppointmentTypeService;
import com.bottomUp.service.docFeed.DoctorDrugDoseSettingService;
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
@RequestMapping("/doctorDrugDoseSetting")
public class DoctorDrugDoseSettingController extends BaseController {

    @Autowired
    private DoctorDrugDoseSettingService doctorDrugDoseSettingService;

    @RequestMapping(value = {"/getByParam"}, method = RequestMethod.GET)
    @ResponseBody
    public List<DoctorDrugDoseSettingData> getAll(HttpServletRequest request) throws BottomUpException {

        Map<String, Object> params = new HashMap<>();

        return this.doctorDrugDoseSettingService.getByParam(params);
    }

    @RequestMapping(value = {"/getByID/{drugDoseSettingID}"}, method = RequestMethod.GET)
    @ResponseBody
    public DoctorDrugDoseSettingData getByID(@PathVariable("drugDoseSettingID") Integer companyID, HttpServletRequest request) throws BottomUpException {

        Map<String, Object> params = this.parseParameter(request);

        return this.doctorDrugDoseSettingService.getByID(Long.valueOf(companyID));
    }

    @RequestMapping(value = {"/save"}, method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> save(@RequestBody DoctorDrugDoseSettingData data) throws BottomUpException {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", true);
        this.doctorDrugDoseSettingService.create(data);
        return result;
    }

    @RequestMapping(value = {"/update"}, method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> update(@RequestBody DoctorDrugDoseSettingData data) throws BottomUpException {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", true);
        this.doctorDrugDoseSettingService.update(data);
        return result;
    }

    @RequestMapping(value = "/delete/{drugDoseSettingID}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("drugDoseSettingID") Integer appointmentID, HttpServletResponse httpResponse_p) throws BottomUpException {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("drugDoseSettingID", appointmentID);
        this.doctorDrugDoseSettingService.delete(param);
    }
}
