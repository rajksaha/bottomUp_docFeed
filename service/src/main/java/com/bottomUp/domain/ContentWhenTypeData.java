package com.bottomUp.domain;


import com.bottomUp.domain.common.BaseData;

public class ContentWhenTypeData  extends BaseData {

  private String whenTypeID;
  private String bangla;
  private String english;
  private String pdf;

  public String getWhenTypeID() {
    return whenTypeID;
  }

  public void setWhenTypeID(String whenTypeID) {
    this.whenTypeID = whenTypeID;
  }

  public String getBangla() {
    return bangla;
  }

  public void setBangla(String bangla) {
    this.bangla = bangla;
  }

  public String getEnglish() {
    return english;
  }

  public void setEnglish(String english) {
    this.english = english;
  }

  public String getPdf() {
    return pdf;
  }

  public void setPdf(String pdf) {
    this.pdf = pdf;
  }
}
