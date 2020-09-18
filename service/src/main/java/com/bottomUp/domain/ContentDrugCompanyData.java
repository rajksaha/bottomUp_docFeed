package com.bottomUp.domain;


import com.bottomUp.domain.common.BaseData;

public class ContentDrugCompanyData extends BaseData {

  private long drugCompanyID;
  private String companyName;
  private String folder;


  public long getDrugCompanyID() {
    return drugCompanyID;
  }

  public void setDrugCompanyID(long drugCompanyID) {
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
