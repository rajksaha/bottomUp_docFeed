package com.bottomUp.controller.common;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.controller.BaseController;
import com.bottomUp.domain.MenuSettingData;
import com.bottomUp.domain.MenuSettingData;
import com.bottomUp.service.docFeed.AppointmentTypeService;
import com.bottomUp.service.docFeed.MenuSettingService;
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
@RequestMapping("/menuSetting")
public class MenuSettingController extends BaseController {

    @Autowired
    private MenuSettingService menuSettingService;

    @RequestMapping(value = {"/getByParam"}, method = RequestMethod.GET)
    @ResponseBody
    public List<MenuSettingData> getAll(HttpServletRequest request) throws BottomUpException {

        Map<String, Object> params = new HashMap<>();

        return this.menuSettingService.getByParam(params);
    }

    @RequestMapping(value = {"/getByID/{menuSettingID}"}, method = RequestMethod.GET)
    @ResponseBody
    public MenuSettingData getByID(@PathVariable("menuSettingID") Integer menuSettingID, HttpServletRequest request) throws BottomUpException {

        Map<String, Object> params = this.parseParameter(request);

        return this.menuSettingService.getByID(Long.valueOf(menuSettingID));
    }

    @RequestMapping(value = {"/save"}, method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> save(@RequestBody MenuSettingData data) throws BottomUpException {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", true);
        result.put("data",  this.menuSettingService.create(data));
        return result;
    }

    @RequestMapping(value = {"/update"}, method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> update(@RequestBody MenuSettingData data) throws BottomUpException {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", true);
        result.put("data",  this.menuSettingService.update(data));
        return result;
    }

    @RequestMapping(value = "/delete/{menuSettingID}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("menuSettingID") Integer menuSettingID, HttpServletResponse httpResponse_p) throws BottomUpException {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("menuSettingID", menuSettingID);
        this.menuSettingService.delete(param);
    }
}
