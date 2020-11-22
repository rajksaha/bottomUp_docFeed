package com.bottomUp.controller.docfeed;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.controller.BaseController;
import com.bottomUp.domain.PrescriptionAdviceData;
import com.bottomUp.service.docFeed.crud.PrescriptionAdviceService;
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
    public PrescriptionAdviceData getByID(@PathVariable("prescriptionAdviceIS") Integer companyID, HttpServletRequest request) throws BottomUpException {

        Map<String, Object> params = this.parseParameter(request);

        return this.prescriptionAdviceService.getByID(Long.valueOf(companyID));
    }

    @RequestMapping(value = {"/save"}, method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> save(@RequestBody PrescriptionAdviceData data) throws BottomUpException {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", true);
        this.prescriptionAdviceService.create(data);
        return result;
    }

    @RequestMapping(value = {"/update"}, method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> update(@RequestBody PrescriptionAdviceData data) throws BottomUpException {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", true);
        this.prescriptionAdviceService.update(data);
        return result;
    }

    @RequestMapping(value = "/delete/{prescriptionAdviceID}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("prescriptionAdviceID") Integer prescriptionAdviceID, HttpServletResponse httpResponse_p) throws BottomUpException {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("presAdviceID", prescriptionAdviceID);
        this.prescriptionAdviceService.delete(param);
    }
}
