package com.bottomUp.controller.docfeed;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.controller.BaseController;
import com.bottomUp.domain.DrugDefaultSetupData;
import com.bottomUp.service.docFeed.crud.DrugDefaultSetupService;
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
@RequestMapping("/drugDefSetup")
public class DrugDefaultSetupController extends BaseController {

    @Autowired
    private DrugDefaultSetupService defaultSetupService;


    @RequestMapping(value = {"/getAll"}, method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getAll(HttpServletRequest request) throws BottomUpException {
        Map<String, Object> params = this.parseParameter(request);
        List<DrugDefaultSetupData> dataList = this.defaultSetupService.getByParam(params);
        return this.buildResultForGrid(dataList, dataList.size(), params);
    }

    @RequestMapping(value = {"/getByParam"}, method = RequestMethod.GET)
    @ResponseBody
    public List<DrugDefaultSetupData> getByParam(HttpServletRequest request) throws BottomUpException {
        Map<String, Object> params = new HashMap<String, Object>();
        return this.defaultSetupService.getByParam(params);
    }

    @RequestMapping(value = {"/getByID/{genericID}"}, method = RequestMethod.GET)
    @ResponseBody
    public DrugDefaultSetupData getByID(@PathVariable("genericID") Integer genericID, HttpServletRequest request) throws BottomUpException {
        return this.defaultSetupService.getByID(Long.valueOf(genericID));
    }

    @RequestMapping(value = {"/getDrugDefaultSetup/{drugID}/{genericID}"}, method = RequestMethod.GET)
    @ResponseBody
    public DrugDefaultSetupData getDrugDefaultSetup(@PathVariable("drugID") Long drugID,
                                                    @PathVariable("genericID") Long genericID,
                                                     HttpServletRequest request) throws BottomUpException {
        Long doctorID = null;
        if(this.getUserDetail().getDoctorData() != null){
            doctorID = this.getUserDetail().getDoctorData().getDoctorID();
        }
        return this.defaultSetupService.getDrugDefaultSetup(doctorID, drugID, genericID == 0 ? null : genericID);
    }

    @RequestMapping(value = {"/getGenericDefaultSetup/{genericID}"}, method = RequestMethod.GET)
    @ResponseBody
    public DrugDefaultSetupData getGenericDefaultSetup(@PathVariable("genericID") Long genericID,
                                                    HttpServletRequest request) throws BottomUpException {
        Long doctorID = null;
        if(this.getUserDetail().getDoctorData() != null){
            doctorID = this.getUserDetail().getDoctorData().getDoctorID();
        }
        return this.defaultSetupService.getGenericDefaultSetup(doctorID, genericID);
    }

    @RequestMapping(value = {"/save"}, method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> save(@RequestBody DrugDefaultSetupData data) throws BottomUpException {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", true);
        if(this.getUserDetail().getDoctorData() != null){
            data.setDoctorID(this.getUserDetail().getDoctorData().getDoctorID());
        }
        this.defaultSetupService.create(data);
        return result;
    }

    @RequestMapping(value = {"/update"}, method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> update(@RequestBody DrugDefaultSetupData data) throws BottomUpException {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", true);
        if(this.getUserDetail().getDoctorData() != null){
            data.setDoctorID(this.getUserDetail().getDoctorData().getDoctorID());
        }
        this.defaultSetupService.update(data);
        return result;
    }

    @RequestMapping(value = "/delete/{drugSettingID}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("drugSettingID") Integer drugSettingID, HttpServletResponse httpResponse_p) throws BottomUpException {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("drugSettingID", drugSettingID);
        this.defaultSetupService.delete(param);
    }
}
