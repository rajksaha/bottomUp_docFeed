package com.bottomUp.domain;


import com.bottomUp.domain.common.BaseData;

public class InvCategoryData extends BaseData {

  private String invCategoryID;
  private String name;

  public String getInvCategoryID() {
    return invCategoryID;
  }

  public void setInvCategoryID(String invCategoryID) {
    this.invCategoryID = invCategoryID;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
