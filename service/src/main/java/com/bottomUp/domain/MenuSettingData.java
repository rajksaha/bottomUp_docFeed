package com.bottomUp.domain;


import com.bottomUp.domain.common.BaseData;

public class MenuSettingData extends BaseData {

  private Long menuSettingID;
  private Long doctorID;
  private Integer menuID;
  private String menuHeader;
  private Integer displayOrder;
  private String menuURL;
  private String defaultName;
  private Integer isPopUp;
  private String functionName;
  private String functionCode;
  private Integer inPrescription;
  private Integer categoryID;

  public Long getMenuSettingID() {
    return menuSettingID;
  }

  public void setMenuSettingID(Long menuSettingID) {
    this.menuSettingID = menuSettingID;
  }

  public Long getDoctorID() {
    return doctorID;
  }

  public void setDoctorID(Long doctorID) {
    this.doctorID = doctorID;
  }

  public Integer getMenuID() {
    return menuID;
  }

  public void setMenuID(Integer menuID) {
    this.menuID = menuID;
  }

  public String getMenuHeader() {
    return menuHeader;
  }

  public void setMenuHeader(String menuHeader) {
    this.menuHeader = menuHeader;
  }

  public Integer getDisplayOrder() {
    return displayOrder;
  }

  public void setDisplayOrder(Integer displayOrder) {
    this.displayOrder = displayOrder;
  }

  public String getMenuURL() {
    return menuURL;
  }

  public void setMenuURL(String menuURL) {
    this.menuURL = menuURL;
  }

  public String getDefaultName() {
    return defaultName;
  }

  public void setDefaultName(String defaultName) {
    this.defaultName = defaultName;
  }

  public Integer getIsPopUp() {
    return isPopUp;
  }

  public void setIsPopUp(Integer isPopUp) {
    this.isPopUp = isPopUp;
  }

  public String getFunctionName() {
    return functionName;
  }

  public void setFunctionName(String functionName) {
    this.functionName = functionName;
  }

  public String getFunctionCode() {
    return functionCode;
  }

  public void setFunctionCode(String functionCode) {
    this.functionCode = functionCode;
  }

  public Integer getInPrescription() {
    return inPrescription;
  }

  public void setInPrescription(Integer inPrescription) {
    this.inPrescription = inPrescription;
  }

  public Integer getCategoryID() {
    return categoryID;
  }

  public void setCategoryID(Integer categoryID) {
    this.categoryID = categoryID;
  }
}
