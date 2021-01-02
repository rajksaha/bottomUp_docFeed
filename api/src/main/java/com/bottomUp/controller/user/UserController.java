package com.bottomUp.controller.user;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.common.utility.SearchData;
import com.bottomUp.controller.BaseController;
import com.bottomUp.domain.common.user.UserData;
import com.bottomUp.domain.common.user.UserGroupData;
import com.bottomUp.domain.common.user.UserProfileData;
import com.bottomUp.service.common.user.UserGroupAssignmentService;
import com.bottomUp.service.common.user.UserGroupService;
import com.bottomUp.service.common.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by raj on 5/3/2016.
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserGroupService userGroupService;

    @Autowired
    private UserGroupAssignmentService userGroupAssignmentService;


    @RequestMapping(value = {"/getAll"}, method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getAll(HttpServletRequest request) throws BottomUpException {


        Map<String, Object> params = this.parseParameter(request);
        Map<String, Boolean> permission = this.getUserDetail().getUserProfilePermissionData().getPermissions();
        if(permission.get("SUPER_ADMIN") != null && permission.get("SUPER_ADMIN")){
            if(params.get("companyID") == null){
                params.put("companyID", -1);
            }else{
                params.put("companyID", params.get("companyID"));
            }
        }else{
            params.put("companyID", this.getUserDetail().getUserProfilePermissionData().getCompanyID());
            if(permission.get("DOCTOR") != null && permission.get("DOCTOR")){
                params.put("doctorID", this.getUserDetail().getDoctorData().getDoctorID());
            }else if(permission.get("DOCTOR_STAFF") != null && permission.get("DOCTOR_STAFF")){
                params.put("userName", this.getUserDetail().getUsername());
            }
        }

        List<UserProfileData> dataList = this.userService.getUserProfileByParam(params);
        Integer count = this.userService.getUserCountByParam(params);
        return this.buildResultForGrid(dataList, count, params);
    }

    @RequestMapping(value = {"/getItemForTypeHead/data/{data}"}, method = RequestMethod.GET)
    @ResponseBody
    public List<UserProfileData> getItemForTypeHead(@PathVariable("data") String data, HttpServletRequest request) throws BottomUpException {

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("companyID", this.getUserDetail().getUserProfilePermissionData().getCompanyID());
        if(this.getUserDetail().getDoctorData() != null){
            params.put("doctorID", this.getUserDetail().getDoctorData().getDoctorID());
        }
        params.put("likeStaffCode", data);
        params.put("limit", 20);
        return this.userService.getUserProfileByParam(params);
    }

    @RequestMapping(value = {"/getUserProfile/userID/{userID}"}, method = RequestMethod.GET)
    @ResponseBody
    public UserProfileData getUserProfile(@PathVariable("userID") Long userID, HttpServletRequest request) throws BottomUpException {
        return this.userService.getUserProfileByID(userID);
    }

    @RequestMapping(value = {"/updateUserPassword"}, method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> updateUserPassword(@RequestBody UserData userData) throws BottomUpException {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", true);
        this.userService.updatePassword(userData);
        userData.setStatus(1);
        updateUserStatus(userData);
        return result;
    }


    @RequestMapping(value = {"/updateUserStatus"}, method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> updateUserStatus(@RequestBody UserData userData) throws BottomUpException {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", true);
        this.userService.updateStatus(userData);
        this.getUserDetail().getUserProfilePermissionData().setStatus(userData.getStatus());
        return result;
    }

    @RequestMapping(value={"/save"}, method=RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> save(@RequestBody UserProfileData profileData) throws BottomUpException {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", true);
        Long companyID = profileData.getCompanyID();
        if(companyID == null){
            companyID = this.getUserDetail().getUserProfilePermissionData().getCompanyID();
        }
        if(this.getUserDetail().getDoctorData() != null){
            profileData.setDoctorID(this.getUserDetail().getDoctorData().getDoctorID());
        }
        this.userService.createUserProfile(profileData, companyID);
        return result;
    }

    @RequestMapping(value = {"/update"}, method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> update(@RequestBody UserProfileData profileData) throws BottomUpException {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", true);
        this.userService.updateUserProfile(profileData);
        return result;
    }

    @RequestMapping(value = {"/getUserGroupForUser"}, method = RequestMethod.POST)
    @ResponseBody
    public List<UserGroupData> getUserGroupForUser(@RequestBody SearchData data) throws BottomUpException{

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("userID", data.getUserID());
        params.put("companyID", this.getUserDetail().getUserProfilePermissionData().getCompanyID());
        if(this.getUserDetail().getDoctorData() != null){
            params.put("isUserDefined", 1);
        }
        return this.userGroupService.getUserGroupForUser(params);
    }

    @RequestMapping(value = {"/updateUserGroupAssignment"}, method = RequestMethod.POST)
    @ResponseBody public Map<String, Object> updateUserGroupAssignment(@RequestBody UserProfileData data) throws BottomUpException {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", true);
        this.userGroupAssignmentService.updateUserGroupAssignment(data);
        return result;
    }
}
