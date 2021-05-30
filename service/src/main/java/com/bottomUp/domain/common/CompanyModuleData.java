package com.bottomUp.domain.common;

/**
 * Created by raj on 4/20/2016.
 */
public class CompanyModuleData extends BaseData {

    private String companyModuleID;
    private String companyID;
    private String moduleID;
    private String shortName;

    private String companyName;
    private String moduleName;

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

    public String getModuleID() {
        return moduleID;
    }

    public void setModuleID(String moduleID) {
        this.moduleID = moduleID;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
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
}
