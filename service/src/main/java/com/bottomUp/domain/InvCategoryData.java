package com.bottomUp.domain;


import com.bottomUp.domain.common.BaseData;

public class InvCategoryData extends BaseData {

  private long invcategoryID;
  private String name;

  public long getInvcategoryID() {
    return invcategoryID;
  }

  public void setInvcategoryID(long invcategoryID) {
    this.invcategoryID = invcategoryID;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
