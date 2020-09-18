package com.bottomUp.domain;


import com.bottomUp.domain.common.BaseData;

public class MenuSettingData extends BaseData {

  private long id;
  private long doctorID;
  private long menuID;
  private String menuHeader;
  private long order;

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
}
