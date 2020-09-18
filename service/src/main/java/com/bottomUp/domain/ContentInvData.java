package com.bottomUp.domain;


import com.bottomUp.domain.common.BaseData;

public class ContentInvData extends BaseData {

  private long invID;
  private long categoryID;
  private String name;

  public long getInvID() {
    return invID;
  }

  public void setInvID(long invID) {
    this.invID = invID;
  }

  public long getCategoryID() {
    return categoryID;
  }

  public void setCategoryID(long categoryID) {
    this.categoryID = categoryID;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
