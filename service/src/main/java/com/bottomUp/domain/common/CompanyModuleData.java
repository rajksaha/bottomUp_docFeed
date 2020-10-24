package com.bottomUp.domain.common;

/**
 * Created by raj on 4/20/2016.
 */
public class CompanyModuleData extends BaseData {

    private Long companyModuleID;
    private Long companyID;
    private Integer moduleID;
    private String shortName;

    private String companyName;
    private String moduleName;

    public Long getCompanyModuleID() {
        return companyModuleID;
    }

    public void setCompanyModuleID(Long companyModuleID) {
        this.companyModuleID = companyModuleID;
    }

    public Long getCompanyID() {
        return companyID;
    }

    public void setCompanyID(Long companyID) {
        this.companyID = companyID;
    }

    public Integer getModuleID() {
        return moduleID;
    }

    public void setModuleID(Integer moduleID) {
        this.moduleID = moduleID;
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

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }
}
