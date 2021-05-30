package com.bottomUp.controller.docfeed;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.controller.BaseController;
import com.bottomUp.domain.MenuSettingData;
import com.bottomUp.service.docFeed.crud.MenuSettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by raj on 8/9/2020.
 */
@Controller
@RequestMapping("/menuSetting")
public class MenuSettingController extends BaseController {

    @Autowired
    private MenuSettingService menuSettingService;

    @RequestMapping(value = {"/getByParam"}, method = RequestMethod.GET)
    @ResponseBody
    public List<MenuSettingData> getByParam(HttpServletRequest request) throws BottomUpException {
        Map<String, Object> params = new HashMap<>();
        return this.menuSettingService.getByParam(params);
    }

    @RequestMapping(value = {"/getAll"}, method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getAll(HttpServletRequest request) throws BottomUpException {
        Map<String, Object> params = this.parseParameter(request);
        if(this.getUserDetail().getUserProfilePermissionData().getPermissions().get("COMPANY_ADMIN") && params.get("doctorID") == null){
            return this.buildResultForGrid( new ArrayList<MenuSettingData>(), 0, params);
        }
        List<MenuSettingData> dataList = this.menuSettingService.getByParam(params);
        return this.buildResultForGrid(dataList, dataList.size(), params);
    }

    @RequestMapping(value = {"/getByID/{menuSettingID}"}, method = RequestMethod.GET)
    @ResponseBody
    public MenuSettingData getByID(@PathVariable("menuSettingID") String menuSettingID, HttpServletRequest request) throws BottomUpException {
        return this.menuSettingService.getByID(menuSettingID);
    }

    @RequestMapping(value = {"/getByDoctorID/{doctorID}"}, method = RequestMethod.GET)
    @ResponseBody
    public List<MenuSettingData> getByDoctorID(@PathVariable("doctorID") Long doctorID, HttpServletRequest request) throws BottomUpException {
        Map<String, Object> params = new HashMap<>();
        params.put("doctorID", doctorID);
        return this.menuSettingService.getByParam(params);
    }

    @RequestMapping(value = {"/save"}, method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> save(@RequestBody MenuSettingData data) throws BottomUpException {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", true);
        if(data.getDoctorID() == null){
            data.setDoctorID(this.getUserDetail().getDoctorData().getDoctorID());
        }
        this.menuSettingService.create(data);
        return result;
    }

    @RequestMapping(value = {"/update"}, method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> update(@RequestBody MenuSettingData data) throws BottomUpException {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", true);
        if(data.getDoctorID() == null){
            data.setDoctorID(this.getUserDetail().getDoctorData().getDoctorID());
        }
        this.menuSettingService.update(data);
        return result;
    }

    @RequestMapping(value = "/delete/{menuSettingID}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("menuSettingID") String menuSettingID, HttpServletResponse httpResponse_p) throws BottomUpException {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("menuSettingID", menuSettingID);
        this.menuSettingService.delete(param);
    }
}
