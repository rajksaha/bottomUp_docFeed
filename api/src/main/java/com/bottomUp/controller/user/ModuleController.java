package com.bottomUp.controller.user;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.controller.BaseController;
import com.bottomUp.domain.common.ModuleData;
import com.bottomUp.service.common.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by raj on 6/1/2016.
 */
@Controller
@RequestMapping("/module")
public class ModuleController extends BaseController {

    @Autowired
    private ModuleService moduleService;


    @RequestMapping(value = {"/getAll"}, method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getAll(HttpServletRequest request) throws BottomUpException {

        Map<String, Object> params = this.parseParameter(request);

        List<ModuleData> moduleDataList = this.moduleService.getByParam(params);

        return this.buildResultForGrid(moduleDataList, moduleDataList.size(), params);
    }

    @RequestMapping(value = {"/getAllModule"}, method = RequestMethod.GET)
    @ResponseBody
    public List<ModuleData> getAllModule(HttpServletRequest request) throws BottomUpException {
        return this.moduleService.getByParam(null);
    }

    @RequestMapping(value = {"/save"}, method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> save(@RequestBody ModuleData data) throws BottomUpException {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", true);
        this.moduleService.create(data);
        return result;
    }

    @RequestMapping(value = {"/update"}, method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> update(@RequestBody ModuleData data) throws BottomUpException {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", true);
        this.moduleService.update(data);
        return result;
    }

    @RequestMapping(value = "/delete/{moduleID}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("moduleID") String moduleID, HttpServletResponse httpResponse_p) throws BottomUpException {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("moduleID",moduleID);
        this.moduleService.delete(param);
    }
}
