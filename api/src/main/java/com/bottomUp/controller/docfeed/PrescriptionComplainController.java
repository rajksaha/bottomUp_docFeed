package com.bottomUp.controller.docfeed;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.controller.BaseController;
import com.bottomUp.domain.PrescriptionComplainData;
import com.bottomUp.service.docFeed.crud.PrescriptionComplainService;
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
@RequestMapping("/prescriptionComplain")
public class PrescriptionComplainController extends BaseController {

    @Autowired
    private PrescriptionComplainService prescriptionComplainService;

    @RequestMapping(value = {"/getByParam"}, method = RequestMethod.GET)
    @ResponseBody
    public List<PrescriptionComplainData> getAll(HttpServletRequest request) throws BottomUpException {

        Map<String, Object> params = new HashMap<>();

        return this.prescriptionComplainService.getByParam(params);
    }

    @RequestMapping(value = {"/getByID/{complainID}"}, method = RequestMethod.GET)
    @ResponseBody
    public PrescriptionComplainData getByID(@PathVariable("complainID") String complainID, HttpServletRequest request) throws BottomUpException {
        return this.prescriptionComplainService.getByID(complainID);
    }

    @RequestMapping(value = {"/save"}, method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> save(@RequestBody PrescriptionComplainData data) throws BottomUpException {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", true);
        this.prescriptionComplainService.create(data);
        return result;
    }

    @RequestMapping(value = {"/update"}, method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> update(@RequestBody PrescriptionComplainData data) throws BottomUpException {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", true);
        this.prescriptionComplainService.update(data);
        return result;
    }

    @RequestMapping(value = "/delete/{complainID}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("complainID") String appointmentID, HttpServletResponse httpResponse_p) throws BottomUpException {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("complainID", appointmentID);
        this.prescriptionComplainService.delete(param);
    }
}
