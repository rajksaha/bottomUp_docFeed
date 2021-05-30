package com.bottomUp.domain;


import com.bottomUp.domain.common.BaseData;

public class ContentInvData extends BaseData {

  private String invID;
  private String categoryID;
  private String name;

  public String getInvID() {
    return invID;
  }

  public void setInvID(String invID) {
    this.invID = invID;
  }

  public String getCategoryID() {
    return categoryID;
  }

  public void setCategoryID(String categoryID) {
    this.categoryID = categoryID;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
