package com.bottomUp.domain;


import com.bottomUp.domain.common.BaseData;

public class MenuData extends BaseData {

  private Long menuID;
  private Integer categoryID;
  private String categoryName;
  private String menuURL;
  private String defaultName;
  private Integer isPopUp;
  private String functionName;
  private Integer inPrescription;
  private Integer displayOrder;

  public Long getMenuID() {
    return menuID;
  }

  public void setMenuID(Long menuID) {
    this.menuID = menuID;
  }

  public Integer getCategoryID() {
    return categoryID;
  }

  public void setCategoryID(Integer categoryID) {
    this.categoryID = categoryID;
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

  public Integer getInPrescription() {
    return inPrescription;
  }

  public void setInPrescription(Integer inPrescription) {
    this.inPrescription = inPrescription;
  }

  public Integer getDisplayOrder() {
    return displayOrder;
  }

  public void setDisplayOrder(Integer displayOrder) {
    this.displayOrder = displayOrder;
  }

  public String getCategoryName() {
    return categoryName;
  }

  public void setCategoryName(String categoryName) {
    this.categoryName = categoryName;
  }
}
