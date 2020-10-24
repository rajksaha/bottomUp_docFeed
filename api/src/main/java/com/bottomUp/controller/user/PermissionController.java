package com.bottomUp.controller.user;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.controller.BaseController;
import com.bottomUp.domain.common.user.GroupPermissionData;
import com.bottomUp.domain.common.user.PermissionData;
import com.bottomUp.service.common.user.GroupPermissionService;
import com.bottomUp.service.common.user.PermissionService;
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
@RequestMapping("/permission")
public class PermissionController extends BaseController {

    @Autowired
    private PermissionService permissionService;

    @Autowired
    private GroupPermissionService groupPermissionService;


    @RequestMapping(value = {"/getAll"}, method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getAll(HttpServletRequest request) throws BottomUpException {

        Map<String, Object> params = this.parseParameter(request);
        params.put("companyID", this.getUserDetail().getCompanyData().getCompanyID());
        List<PermissionData> permissionDataList = this.permissionService.getByParam(params);

        return this.buildResultForGrid(permissionDataList, permissionDataList.size(), params);
    }

    @RequestMapping(value = {"/getAllPermission"}, method = RequestMethod.GET)
    @ResponseBody
    public List<PermissionData> getAllPermission(HttpServletRequest request) throws BottomUpException {
        return this.permissionService.getByParam(null);
    }

    @RequestMapping(value = {"/save"}, method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> save(@RequestBody PermissionData data) throws BottomUpException {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", true);
        this.permissionService.create(data);
        return result;
    }

    @RequestMapping(value = {"/update"}, method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> update(@RequestBody PermissionData data) throws BottomUpException {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", true);
        this.permissionService.update(data);
        return result;
    }

    @RequestMapping(value = "/delete/{permissionID}", method = RequestMethod.DELETE)
    public Map<String, Object> delete(@PathVariable("permissionID") Integer permissionID, HttpServletResponse httpResponse_p) throws BottomUpException {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("permissionID",permissionID);
        List<GroupPermissionData> listOfConnectedData = groupPermissionService.getByParam(param);
        Map<String, Object> result = new HashMap<String, Object>();
        if(listOfConnectedData != null && listOfConnectedData.size() > 0){
            result.put("success", false);
        }
        this.permissionService.delete(param);
        result.put("success", false);
        return result;
    }
}
