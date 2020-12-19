package com.bottomUp.controller.docfeed;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.controller.BaseController;
import com.bottomUp.domain.PrescriptionDrugData;
import com.bottomUp.service.docFeed.crud.ContentDrugAdviceService;
import com.bottomUp.service.docFeed.crud.ContentDrugTypeService;
import com.bottomUp.service.docFeed.crud.ContentWhenTypeService;
import com.bottomUp.service.docFeed.crud.PrescriptionDrugService;
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
@RequestMapping("/prescriptionDrug")
public class PrescriptionDrugController extends BaseController {

    @Autowired
    private PrescriptionDrugService prescriptionDrugService;


    @RequestMapping(value = {"/getByParam"}, method = RequestMethod.GET)
    @ResponseBody
    public List<PrescriptionDrugData> getAll(HttpServletRequest request) throws BottomUpException {
        Map<String, Object> params = new HashMap<>();
        return this.prescriptionDrugService.getByParam(params);
    }

    @RequestMapping(value = {"/getReqContent"}, method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getReqContent(HttpServletRequest request) throws BottomUpException {
        return prescriptionDrugService.getReqContent();
    }

    @RequestMapping(value = {"/getByID/{presDrugID}"}, method = RequestMethod.GET)
    @ResponseBody
    public PrescriptionDrugData getByID(@PathVariable("presDrugID") Integer presDrugID, HttpServletRequest request) throws BottomUpException {
        return this.prescriptionDrugService.getByID(Long.valueOf(presDrugID));
    }

    @RequestMapping(value = {"/save"}, method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> save(@RequestBody PrescriptionDrugData data) throws BottomUpException {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", true);
        this.prescriptionDrugService.save(data);
        return result;
    }

    @RequestMapping(value = {"/update"}, method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> update(@RequestBody PrescriptionDrugData data) throws BottomUpException {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", true);
        this.prescriptionDrugService.update(data);
        return result;
    }

    @RequestMapping(value = "/delete/{presDrugID}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("presDrugID") Integer appointmentID, HttpServletResponse httpResponse_p) throws BottomUpException {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("presDrugID", appointmentID);
        this.prescriptionDrugService.delete(param);
    }
}
