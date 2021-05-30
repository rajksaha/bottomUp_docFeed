package com.bottomUp.domain;


import com.bottomUp.domain.common.BaseData;

public class ContentDrugCompanyData extends BaseData {

  private String drugCompanyID;
  private String companyName;
  private String folder;

  public String getDrugCompanyID() {
    return drugCompanyID;
  }

  public void setDrugCompanyID(String drugCompanyID) {
    this.drugCompanyID = drugCompanyID;
  }

  public String getCompanyName() {
    return companyName;
  }

  public void setCompanyName(String companyName) {
    this.companyName = companyName;
  }

  public String getFolder() {
    return folder;
  }

  public void setFolder(String folder) {
    this.folder = folder;
  }
}
