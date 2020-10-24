package com.bottomUp.controller.docfeed;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.controller.BaseController;
import com.bottomUp.domain.  PrescriptionNextVisitData;
import com.bottomUp.service.docFeed.crud.PrescriptionNextVisitService;
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
@RequestMapping("/prescriptionNextVisit")
public class PrescriptionNextVisitController extends BaseController {

    @Autowired
    private PrescriptionNextVisitService prescriptionNextVisitService;

    @RequestMapping(value = {"/getByParam"}, method = RequestMethod.GET)
    @ResponseBody
    public List<  PrescriptionNextVisitData> getAll(HttpServletRequest request) throws BottomUpException {

        Map<String, Object> params = new HashMap<>();

        return this.prescriptionNextVisitService.getByParam(params);
    }

    @RequestMapping(value = {"/getByID/{  appointmentID}"}, method = RequestMethod.GET)
    @ResponseBody
    public   PrescriptionNextVisitData getByID(@PathVariable("  appointmentID") Integer companyID, HttpServletRequest request) throws BottomUpException {

        Map<String, Object> params = this.parseParameter(request);

        return this.prescriptionNextVisitService.getByID(Long.valueOf(companyID));
    }

    @RequestMapping(value = {"/save"}, method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> save(@RequestBody   PrescriptionNextVisitData data) throws BottomUpException {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", true);
        this.prescriptionNextVisitService.create(data);
        return result;
    }

    @RequestMapping(value = {"/update"}, method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> update(@RequestBody   PrescriptionNextVisitData data) throws BottomUpException {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", true);
        this.prescriptionNextVisitService.update(data);
        return result;
    }

    @RequestMapping(value = "/delete/{  appointmentID}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("  appointmentID") Integer appointmentID, HttpServletResponse httpResponse_p) throws BottomUpException {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("  appointmentID", appointmentID);
        this.prescriptionNextVisitService.delete(param);
    }
}
