package com.bottomUp.domain.common.user;


import com.bottomUp.domain.common.BaseData;

import java.util.List;

/**
 * Created by raj on 3/19/2016.
 */
public class UserGroupData extends BaseData {

    private String userGroupID;
    private String shortName;
    private String longDesc;
    private String companyModuleID;
    private String companyID;
    private String companyModuleName;
    private String companyName;
    private String moduleName;

    private Boolean isAssigned;
    private Integer isUserDefined;

    private List<PermissionData> groupPermissionList;

    public String getUserGroupID() {
        return userGroupID;
    }

    public void setUserGroupID(String userGroupID) {
        this.userGroupID = userGroupID;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getLongDesc() {
        return longDesc;
    }

    public void setLongDesc(String longDesc) {
        this.longDesc = longDesc;
    }

    public String getCompanyModuleID() {
        return companyModuleID;
    }

    public void setCompanyModuleID(String companyModuleID) {
        this.companyModuleID = companyModuleID;
    }

    public String getCompanyID() {
        return companyID;
    }

    public void setCompanyID(String companyID) {
        this.companyID = companyID;
    }

    public String getCompanyModuleName() {
        return companyModuleName;
    }

    public void setCompanyModuleName(String companyModuleName) {
        this.companyModuleName = companyModuleName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public Boolean getAssigned() {
        return isAssigned;
    }

    public void setAssigned(Boolean assigned) {
        isAssigned = assigned;
    }

    public Integer getIsUserDefined() {
        return isUserDefined;
    }

    public void setIsUserDefined(Integer isUserDefined) {
        this.isUserDefined = isUserDefined;
    }

    public List<PermissionData> getGroupPermissionList() {
        return groupPermissionList;
    }

    public void setGroupPermissionList(List<PermissionData> groupPermissionList) {
        this.groupPermissionList = groupPermissionList;
    }
}
