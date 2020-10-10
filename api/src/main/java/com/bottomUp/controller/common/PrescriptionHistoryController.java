package com.bottomUp.controller.common;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.controller.BaseController;
import com.bottomUp.domain.PrescriptionHistoryData;
import com.bottomUp.service.docFeed.AppointmentTypeService;
import com.bottomUp.service.docFeed.PrescriptionHistoryService;
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
@RequestMapping("/prescriptionHistory")
public class PrescriptionHistoryController extends BaseController {

    @Autowired
    private PrescriptionHistoryService prescriptionHistoryService;

    @RequestMapping(value = {"/getByParam"}, method = RequestMethod.GET)
    @ResponseBody
    public List<PrescriptionHistoryData> getAll(HttpServletRequest request) throws BottomUpException {

        Map<String, Object> params = new HashMap<>();

        return this.prescriptionHistoryService.getByParam(params);
    }

    @RequestMapping(value = {"/getByID/{presHistoryID}"}, method = RequestMethod.GET)
    @ResponseBody
    public PrescriptionHistoryData getByID(@PathVariable("presHistoryID") Integer companyID, HttpServletRequest request) throws BottomUpException {

        Map<String, Object> params = this.parseParameter(request);

        return this.prescriptionHistoryService.getByID(Long.valueOf(companyID));
    }

    @RequestMapping(value = {"/save"}, method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> save(@RequestBody PrescriptionHistoryData data) throws BottomUpException {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", true);
        this.prescriptionHistoryService.create(data);
        return result;
    }

    @RequestMapping(value = {"/update"}, method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> update(@RequestBody PrescriptionHistoryData data) throws BottomUpException {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", true);
        this.prescriptionHistoryService.update(data);
        return result;
    }

    @RequestMapping(value = "/delete/{presHistoryID}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("presHistoryID") Integer appointmentID, HttpServletResponse httpResponse_p) throws BottomUpException {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("presHistoryID", appointmentID);
        this.prescriptionHistoryService.delete(param);
    }
}
