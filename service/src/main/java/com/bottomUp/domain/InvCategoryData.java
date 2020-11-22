package com.bottomUp.domain;


import com.bottomUp.domain.common.BaseData;

public class InvCategoryData extends BaseData {

  private long invCategoryID;
  private String name;

  public long getInvCategoryID() {
    return invCategoryID;
  }

  public void setInvCategoryID(long invCategoryID) {
    this.invCategoryID = invCategoryID;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
