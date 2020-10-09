package com.bottomUp.controller.common;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.controller.BaseController;
import com.bottomUp.domain.PrescriptionAdviceData;
import com.bottomUp.service.docFeed.AppointmentTypeService;
import com.bottomUp.service.docFeed.PrescriptionAdviceService;
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
@RequestMapping("/prescriptionAdvice")
public class PrescriptionAdviceController extends BaseController {

    @Autowired
    private PrescriptionAdviceService prescriptionAdviceService;

    @RequestMapping(value = {"/getByParam"}, method = RequestMethod.GET)
    @ResponseBody
    public List<PrescriptionAdviceData> getAll(HttpServletRequest request) throws BottomUpException {

        Map<String, Object> params = new HashMap<>();

        return this.prescriptionAdviceService.getByParam(params);
    }

    @RequestMapping(value = {"/getByID/{prescriptionAdviceIS}"}, method = RequestMethod.GET)
    @ResponseBody
    public PrescriptionAdviceData getByID(@PathVariable("prescriptionAdviceIS") Integer prescriptionAdviceIS, HttpServletRequest request) throws BottomUpException {

       // Map<String, Object> params = this.parseParameter(request);

        return this.prescriptionAdviceService.getByID(Long.valueOf(prescriptionAdviceIS));
    }

    @RequestMapping(value = {"/save"}, method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> save(@RequestBody PrescriptionAdviceData data) throws BottomUpException {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", true);
        result.put("data", this.prescriptionAdviceService.create(data));
        return result;
    }

    @RequestMapping(value = {"/update"}, method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> update(@RequestBody PrescriptionAdviceData data) throws BottomUpException {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", true);
        result.put("data", this.prescriptionAdviceService.update(data));
        return result;
    }

    @RequestMapping(value = "/delete/{prescriptionAdviceIS}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("prescriptionAdviceIS") Integer prescriptionAdviceIS, HttpServletResponse httpResponse_p) throws BottomUpException {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("prescriptionAdviceIS", prescriptionAdviceIS);
        this.prescriptionAdviceService.delete(param);
    }
}
