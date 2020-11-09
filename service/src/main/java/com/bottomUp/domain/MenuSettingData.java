package com.bottomUp.domain;


import com.bottomUp.domain.common.BaseData;

public class MenuSettingData extends BaseData {

  private long id;
  private long doctorID;
  private long menuID;
  private String menuHeader;
  private long order;
  private String menuURL;
  private String defaultName;
  private long isPopUp;
  private String functionName;
  private String functionCode;
  private long inPrescription;
  private long displayOrder;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public long getDoctorID() {
    return doctorID;
  }

  public void setDoctorID(long doctorID) {
    this.doctorID = doctorID;
  }

  public long getMenuID() {
    return menuID;
  }

  public void setMenuID(long menuID) {
    this.menuID = menuID;
  }

  public String getMenuHeader() {
    return menuHeader;
  }

  public void setMenuHeader(String menuHeader) {
    this.menuHeader = menuHeader;
  }

  public long getOrder() {
    return order;
  }

  public void setOrder(long order) {
    this.order = order;
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

  public long getIsPopUp() {
    return isPopUp;
  }

  public void setIsPopUp(long isPopUp) {
    this.isPopUp = isPopUp;
  }

  public String getFunctionName() {
    return functionName;
  }

  public void setFunctionName(String functionName) {
    this.functionName = functionName;
  }

  public long getInPrescription() {
    return inPrescription;
  }

  public void setInPrescription(long inPrescription) {
    this.inPrescription = inPrescription;
  }

  public long getDisplayOrder() {
    return displayOrder;
  }

  public void setDisplayOrder(long displayOrder) {
    this.displayOrder = displayOrder;
  }

  public String getFunctionCode() {
    return functionCode;
  }

  public void setFunctionCode(String functionCode) {
    this.functionCode = functionCode;
  }
}
