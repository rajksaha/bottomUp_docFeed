package com.bottomUp.domain.common.user;


import com.bottomUp.domain.common.BaseData;

/**
 * Created by raj on 3/19/2016.
 */
public class PermissionData extends BaseData {

    private Long permissionID;
    private Long companyModuleID;
    private String companyModuleName;
    private String functionCode;
    private String shortName;
    private Boolean isAssigned;

    public Long getPermissionID() {
        return permissionID;
    }

    public void setPermissionID(Long permissionID) {
        this.permissionID = permissionID;
    }

    public Long getCompanyModuleID() {
        return companyModuleID;
    }

    public void setCompanyModuleID(Long companyModuleID) {
        this.companyModuleID = companyModuleID;
    }

    public String getFunctionCode() {
        return functionCode;
    }

    public void setFunctionCode(String functionCode) {
        this.functionCode = functionCode;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public Boolean getIsAssigned() {
        return isAssigned;
    }

    public void setIsAssigned(Boolean isAssigned) {
        this.isAssigned = isAssigned;
    }

    public String getCompanyModuleName() {
        return companyModuleName;
    }

    public void setCompanyModuleName(String companyModuleName) {
        this.companyModuleName = companyModuleName;
    }
}
