package com.bottomUp.controller.docfeed;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.controller.BaseController;
import com.bottomUp.domain. PrescriptionInvData;
import com.bottomUp.service.docFeed.crud.PrescriptionInvService;
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
@RequestMapping("/prescriptionInv")
public class PrescriptionInvController extends BaseController {

    @Autowired
    private PrescriptionInvService prescriptionInvService;

    @RequestMapping(value = {"/getByParam"}, method = RequestMethod.GET)
    @ResponseBody
    public List< PrescriptionInvData> getAll(HttpServletRequest request) throws BottomUpException {

        Map<String, Object> params = new HashMap<>();

        return this.prescriptionInvService.getByParam(params);
    }

    @RequestMapping(value = {"/getByID/{  presInvID}"}, method = RequestMethod.GET)
    @ResponseBody
    public  PrescriptionInvData getByID(@PathVariable("presInvID") String presInvID, HttpServletRequest request) throws BottomUpException {
        return this.prescriptionInvService.getByID(presInvID);
    }

    @RequestMapping(value = {"/save"}, method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> save(@RequestBody  PrescriptionInvData data) throws BottomUpException {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", true);
        this.prescriptionInvService.create(data);
        return result;
    }

    @RequestMapping(value = {"/update"}, method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> update(@RequestBody  PrescriptionInvData data) throws BottomUpException {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", true);
        this.prescriptionInvService.update(data);
        return result;
    }

    @RequestMapping(value = "/delete/{presInvID}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("presInvID") String presInvID, HttpServletResponse httpResponse_p) throws BottomUpException {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("presInvID", presInvID);
        this.prescriptionInvService.delete(param);
    }
}
