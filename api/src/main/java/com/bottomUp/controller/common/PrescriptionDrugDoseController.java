package com.bottomUp.controller.common;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.controller.BaseController;
import com.bottomUp.domain.PrescriptionDrugDoseData;
import com.bottomUp.service.docFeed.AppointmentTypeService;
import com.bottomUp.service.docFeed.PrescriptionDrugDoseService;
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
@RequestMapping("/prescriptionDrugDose")
public class PrescriptionDrugDoseController extends BaseController {

    @Autowired
    private PrescriptionDrugDoseService prescriptionDrugDoseService;

    @RequestMapping(value = {"/getByParam"}, method = RequestMethod.GET)
    @ResponseBody
    public List<PrescriptionDrugDoseData> getAll(HttpServletRequest request) throws BottomUpException {

        Map<String, Object> params = new HashMap<>();

        return this.prescriptionDrugDoseService.getByParam(params);
    }

    @RequestMapping(value = {"/getByID/{presDrugID}"}, method = RequestMethod.GET)
    @ResponseBody
    public PrescriptionDrugDoseData getByID(@PathVariable("presDrugID") Integer presDrugID, HttpServletRequest request) throws BottomUpException {

        //Map<String, Object> params = this.parseParameter(request);

        return this.prescriptionDrugDoseService.getByID(Long.valueOf(presDrugID));
    }

    @RequestMapping(value = {"/save"}, method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> save(@RequestBody PrescriptionDrugDoseData data) throws BottomUpException {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", true);
        result.put("data", this.prescriptionDrugDoseService.create(data));
        return result;
    }

    @RequestMapping(value = {"/update"}, method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> update(@RequestBody PrescriptionDrugDoseData data) throws BottomUpException {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", true);
        result.put("data", this.prescriptionDrugDoseService.update(data));
        return result;
    }

    @RequestMapping(value = "/delete/{presDrugID}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("presDrugID") Integer presDrugID, HttpServletResponse httpResponse_p) throws BottomUpException {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("presDrugID", presDrugID);
        this.prescriptionDrugDoseService.delete(param);
    }
}
