package com.bottomUp.controller.docfeed;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.controller.BaseController;
import com.bottomUp.domain.MenuData;
import com.bottomUp.service.docFeed.crud.MenuService;
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
@RequestMapping("/menu")
public class MenuController extends BaseController {

    @Autowired
    private MenuService menuService;

    @RequestMapping(value = {"/getAll"}, method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getAll(HttpServletRequest request) throws BottomUpException {
        Map<String, Object> params = this.parseParameter(request);
        List<MenuData> dataList = this.menuService.getByParam(params);
        return this.buildResultForGrid(dataList, dataList.size(), params);
    }

    @RequestMapping(value = {"/getByParam"}, method = RequestMethod.GET)
    @ResponseBody
    public List<MenuData> getByParam(HttpServletRequest request) throws BottomUpException {
        Map<String, Object> params = new HashMap<String, Object>();
        if(params.get("categoryID") == null){
            params.put("categoryID", this.getUserDetail().getDoctorData().getCategoryID());
        }
        return this.menuService.getByParam(params);
    }

    @RequestMapping(value = {"/getByCategory/{categoryID}"}, method = RequestMethod.GET)
    @ResponseBody
    public List<MenuData> getByCategory(@PathVariable("categoryID") Integer categoryID, HttpServletRequest request) throws BottomUpException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("categoryID", categoryID);
        return this.menuService.getByParam(params);
    }

    @RequestMapping(value = {"/getByID/{menuID}"}, method = RequestMethod.GET)
    @ResponseBody
    public MenuData getByID(@PathVariable("menuID") Integer menuID, HttpServletRequest request) throws BottomUpException {
        return this.menuService.getByID(Long.valueOf(menuID));
    }

    @RequestMapping(value = {"/save"}, method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> save(@RequestBody MenuData data) throws BottomUpException {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", true);
        if(data.getCategoryID() == null && this.getUserDetail().getDoctorData() != null){
            data.setCategoryID(this.getUserDetail().getDoctorData().getCategoryID());
        }
        this.menuService.create(data);
        return result;
    }

    @RequestMapping(value = {"/update"}, method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> update(@RequestBody MenuData data) throws BottomUpException {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", true);
        if(data.getCategoryID() == null && this.getUserDetail().getDoctorData() != null){
            data.setCategoryID(this.getUserDetail().getDoctorData().getCategoryID());
        }
        this.menuService.update(data);
        return result;
    }

    @RequestMapping(value = "/delete/{menuID}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("menuID") Integer menuID, HttpServletResponse httpResponse_p) throws BottomUpException {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("menuID", menuID);
        this.menuService.delete(param);
    }
}
