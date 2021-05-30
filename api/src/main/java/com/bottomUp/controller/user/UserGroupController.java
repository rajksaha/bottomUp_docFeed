package com.bottomUp.controller.user;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.controller.BaseController;
import com.bottomUp.domain.common.user.UserGroupData;
import com.bottomUp.service.common.user.UserGroupService;
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
@RequestMapping("/userGroup")
public class UserGroupController extends BaseController {

    @Autowired
    private UserGroupService userGroupService;


    @RequestMapping(value = {"/getAll"}, method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getAll(HttpServletRequest request) throws BottomUpException {

        Map<String, Object> params = this.parseParameter(request);

        params.put("companyID", this.getUserDetail().getUserProfilePermissionData().getCompanyID());
        if(this.getUserDetail().getDoctorData() != null){
            params.put("isUserDefined", 1);
        }
        List<UserGroupData> dataList = this.userGroupService.getByParam(params);
        Integer count = this.userGroupService.getCountByParam(params);

        return this.buildResultForGrid(dataList, count, params);
    }

    @RequestMapping(value = {"/getGroupByCompanyID/companyID/{companyID}"}, method = RequestMethod.GET)
    @ResponseBody
    public List<UserGroupData> getGroupByCompanyID(@PathVariable("companyID") String companyID, HttpServletRequest request) throws BottomUpException{

        Map<String, Object> params = new HashMap<String, Object>();
        if(companyID.equalsIgnoreCase("null")){
            companyID = this.getUserDetail().getUserProfilePermissionData().getCompanyID();
        }
        params.put("companyID", companyID);
        if(this.getUserDetail().getDoctorData() != null){
            params.put("isUserDefined", 1);
        }
        return this.userGroupService.getByParam(params);
    }

    @RequestMapping(value = {"/getAllUserGroup"}, method = RequestMethod.GET)
    @ResponseBody
    public List<UserGroupData> getAllCompany(HttpServletRequest request) throws BottomUpException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("companyID", this.getUserDetail().getUserProfilePermissionData().getCompanyID());
        if(this.getUserDetail().getDoctorData() != null){
            params.put("isUserDefined", 1);
        }
        return this.userGroupService.getByParam(params);
    }

    @RequestMapping(value = {"/save"}, method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> save(@RequestBody UserGroupData data) throws BottomUpException {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", true);
        if(data.getIsUserDefined() == null && this.getUserDetail().getDoctorData() != null){
            data.setIsUserDefined(1);
        }
        data.setCompanyID(this.getUserDetail().getCompanyData().getCompanyID());
        this.userGroupService.create(data);
        return result;
    }

    @RequestMapping(value = {"/update"}, method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> update(@RequestBody UserGroupData data) throws BottomUpException {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", true);
        this.userGroupService.update(data);
        return result;
    }

    @RequestMapping(value = "/delete/{userGroupID}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("userGroupID") String userGroupID, HttpServletResponse httpResponse_p) throws BottomUpException {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("userGroupID",userGroupID);
        this.userGroupService.delete(param);
    }
}
