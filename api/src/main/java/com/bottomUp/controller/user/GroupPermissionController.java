package com.bottomUp.controller.user;
import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.common.utility.SearchData;
import com.bottomUp.controller.BaseController;
import com.bottomUp.domain.common.user.PermissionData;
import com.bottomUp.domain.common.user.UserGroupData;
import com.bottomUp.service.common.user.UserGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by raj on 6/7/2016.
 */
@Controller
@RequestMapping("/groupPermission")
public class GroupPermissionController extends BaseController {

    @Autowired
    private UserGroupService userGroupService;


    @RequestMapping(value = {"/getCompanyModulePermission"}, method = RequestMethod.POST)
    @ResponseBody
    public List<PermissionData> getCompanyModulePermission(@RequestBody SearchData data) throws BottomUpException {

        Map<String, Object> params = new HashMap<String, Object>();

        params.put("userGroupID", data.getEntityID());
        params.put("companyID", data.getEntityType() == null ? this.getUserDetail().getUserProfilePermissionData().getCompanyID() : data.getEntityType());
        if(this.getUserDetail().getDoctorData() != null){
            params.put("isUserDefined", 1);
        }
        return this.userGroupService.getCompanyModulePermission(params);
    }

    @RequestMapping(value = {"/updateGroupPermission"}, method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> updateGroupPermission(@RequestBody UserGroupData data) throws BottomUpException {
        Map<String, Object> params = new HashMap<String, Object>();
        this.userGroupService.updateGroupPermission(data);
        params.put("status", true);
        return params;
    }
}
