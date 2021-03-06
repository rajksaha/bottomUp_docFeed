package com.bottomUp.controller.docfeed;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.controller.BaseController;
import com.bottomUp.domain.InvReportDateData;
import com.bottomUp.service.docFeed.crud.InvReportDateService;
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
@RequestMapping("/invReportDate")
public class InvReportDateController extends BaseController {

    @Autowired
    private InvReportDateService invReportDateService;

    @RequestMapping(value = {"/getByParam"}, method = RequestMethod.GET)
    @ResponseBody
    public List<InvReportDateData> getAll(HttpServletRequest request) throws BottomUpException {

        Map<String, Object> params = new HashMap<>();

        return this.invReportDateService.getByParam(params);
    }

    @RequestMapping(value = {"/getByID/{invReportDateId}"}, method = RequestMethod.GET)
    @ResponseBody
    public InvReportDateData getByID(@PathVariable("invReportDateId") String invReportDateId, HttpServletRequest request) throws BottomUpException {
        return this.invReportDateService.getByID(invReportDateId);
    }

    @RequestMapping(value = {"/save"}, method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> save(@RequestBody InvReportDateData data) throws BottomUpException {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", true);
        this.invReportDateService.create(data);
        return result;
    }

    @RequestMapping(value = {"/update"}, method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> update(@RequestBody InvReportDateData data) throws BottomUpException {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", true);
        this.invReportDateService.update(data);
        return result;
    }

    @RequestMapping(value = "/delete/{invReportDateId}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("invReportDateId") String appointmentID, HttpServletResponse httpResponse_p) throws BottomUpException {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("invReportDateId", appointmentID);
        this.invReportDateService.delete(param);
    }
}
