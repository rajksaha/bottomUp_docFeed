package com.bottomUp.domain.common;

/**
 * Created by raj on 4/20/2016.
 */
public class ModuleData extends BaseData {

    private Long moduleID;
    private String moduleCode;
    private String moduleName;

    public Long getModuleID() {
        return moduleID;
    }

    public void setModuleID(Long moduleID) {
        this.moduleID = moduleID;
    }

    public String getModuleCode() {
        return moduleCode;
    }

    public void setModuleCode(String moduleCode) {
        this.moduleCode = moduleCode;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }
}
