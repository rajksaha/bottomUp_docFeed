package com.bottomUp.controller.common;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.controller.BaseController;
import com.bottomUp.domain.InvReportData;
import com.bottomUp.service.docFeed.AppointmentTypeService;
import com.bottomUp.service.docFeed.InvReportService;
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
@RequestMapping("/invReport")
public class InvReportController extends BaseController {

    @Autowired
    private InvReportService invReportService;

    @RequestMapping(value = {"/getByParam"}, method = RequestMethod.GET)
    @ResponseBody
    public List<InvReportData> getAll(HttpServletRequest request) throws BottomUpException {

        Map<String, Object> params = new HashMap<>();

        return this.invReportService.getByParam(params);
    }

    @RequestMapping(value = {"/getByID/{id}"}, method = RequestMethod.GET)
    @ResponseBody
    public InvReportData getByID(@PathVariable("id") Integer companyID, HttpServletRequest request) throws BottomUpException {

        Map<String, Object> params = this.parseParameter(request);

        return this.invReportService.getByID(Long.valueOf(companyID));
    }

    @RequestMapping(value = {"/save"}, method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> save(@RequestBody InvReportData data) throws BottomUpException {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", true);
        this.invReportService.create(data);
        return result;
    }

    @RequestMapping(value = {"/update"}, method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> update(@RequestBody InvReportData data) throws BottomUpException {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", true);
        this.invReportService.update(data);
        return result;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") Integer appointmentID, HttpServletResponse httpResponse_p) throws BottomUpException {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("id", appointmentID);
        this.invReportService.delete(param);
    }
}
