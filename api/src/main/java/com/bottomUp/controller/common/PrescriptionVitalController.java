package com.bottomUp.controller.common;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.controller.BaseController;
import com.bottomUp.domain.  PrescriptionVitalData;
import com.bottomUp.service.docFeed.AppointmentTypeService;
import com.bottomUp.service.docFeed.PrescriptionVitalService;
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
@RequestMapping("/prescriptionVital")
public class PrescriptionVitalController extends BaseController {

    @Autowired
    private PrescriptionVitalService prescriptionVitalService;

    @RequestMapping(value = {"/getByParam"}, method = RequestMethod.GET)
    @ResponseBody
    public List<  PrescriptionVitalData> getAll(HttpServletRequest request) throws BottomUpException {

        Map<String, Object> params = new HashMap<>();

        return this.prescriptionVitalService.getByParam(params);
    }

    @RequestMapping(value = {"/getByID/{  presVitalID}"}, method = RequestMethod.GET)
    @ResponseBody
    public   PrescriptionVitalData getByID(@PathVariable("  presVitalID") Integer presVitalID, HttpServletRequest request) throws BottomUpException {

        //Map<String, Object> params = this.parseParameter(request);

        return this.prescriptionVitalService.getByID(Long.valueOf(presVitalID));
    }

    @RequestMapping(value = {"/save"}, method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> save(@RequestBody   PrescriptionVitalData data) throws BottomUpException {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", true);
        result.put("data", this.prescriptionVitalService.create(data));
        return result;
    }

    @RequestMapping(value = {"/update"}, method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> update(@RequestBody   PrescriptionVitalData data) throws BottomUpException {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", true);
        result.put("data", this.prescriptionVitalService.update(data));
        return result;
    }

    @RequestMapping(value = "/delete/{  presVitalID}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("  presVitalID") Integer presVitalID, HttpServletResponse httpResponse_p) throws BottomUpException {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("  presVitalID", presVitalID);
        this.prescriptionVitalService.delete(param);
    }
}
