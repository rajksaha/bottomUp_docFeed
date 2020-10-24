package com.bottomUp.service;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.common.CompanyData;
import com.bottomUp.domain.common.CompanyModuleData;
import com.bottomUp.domain.common.user.GroupPermissionData;
import com.bottomUp.domain.common.user.PermissionData;
import com.bottomUp.domain.common.user.UserGroupData;
import com.bottomUp.myBatis.persistence.GroupPermissionMapper;
import com.bottomUp.myBatis.persistence.PermissionMapper;
import com.bottomUp.myBatis.persistence.UserGroupMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by raj on 10/18/2020.
 */
@Service
public class CompanyDefaultSetupService {

    @Autowired
    private PermissionMapper permissionMapper;

    @Autowired
    private UserGroupMapper userGroupMapper;

    @Autowired
    private GroupPermissionMapper groupPermissionMapper;


    public void createAdminPermissionForCompany(CompanyData companyData)throws BottomUpException {
        this.createPermissionForCompany(companyData.getCompanyID(), null, "COMPANY_ADMIN", "ADMIN");
    }

    public void createDefaultPermissionAndGroupForModule(CompanyModuleData moduleData) throws BottomUpException{
        if(moduleData.getCompanyModuleID() == 1){
            this.createPermissionForCompany(moduleData.getCompanyID(), moduleData.getCompanyModuleID(), "DOCTOR", "DOCTOR");
            this.createPermissionForCompany(moduleData.getCompanyID(), moduleData.getCompanyModuleID(), "DOCTOR_STAFF", "DOCTOR_STAFF");
        }
    }

    private void createPermissionForCompany(Long companyID, Long companyModuleID, String code, String name)throws BottomUpException {
        PermissionData permissionData = this.createPermission(companyID, companyModuleID, code, name);
        UserGroupData userGroupData = this.createUserGroup(companyID, companyModuleID, code,  name);
        this.createGroupPermission(permissionData.getPermissionID(), userGroupData.getUserGroupID());
    }


    private PermissionData createPermission(Long companyID, Long companyModuleID, String functionCode, String shortName)throws BottomUpException{
        PermissionData permissionData = new PermissionData();
        permissionData.setFunctionCode(functionCode);
        permissionData.setShortName(shortName);
        permissionData.setCompanyModuleID(companyModuleID != null ? companyModuleID : companyID);
        permissionMapper.create(permissionData);
        return permissionData;
    }

    private UserGroupData createUserGroup(Long companyID, Long companyModuleID, String shortName, String longDesk)throws BottomUpException{
        UserGroupData userGroupData = new UserGroupData();
        userGroupData.setCompanyID(companyID);
        userGroupData.setCompanyModuleID(companyModuleID);
        userGroupData.setShortName(shortName);
        userGroupData.setLongDesc(longDesk);
        userGroupMapper.create(userGroupData);
        return userGroupData;
    }

    private GroupPermissionData createGroupPermission(Long permissionID, Long userGroupID) throws BottomUpException{
        GroupPermissionData groupPermissionData = new GroupPermissionData();
        groupPermissionData.setPermissionID(permissionID);
        groupPermissionData.setUserGroupID(userGroupID);
        groupPermissionMapper.create(groupPermissionData);
        return groupPermissionData;
    }
}
