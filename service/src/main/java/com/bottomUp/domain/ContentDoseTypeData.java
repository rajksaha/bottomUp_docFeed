package com.bottomUp.domain;


import com.bottomUp.domain.common.BaseData;

public class ContentDoseTypeData extends BaseData {

  private String doseTypeID;
  private Integer doseCode;
  private String bangla;
  private String english;
  private String pdf;

  public String getDoseTypeID() {
    return doseTypeID;
  }

  public void setDoseTypeID(String doseTypeID) {
    this.doseTypeID = doseTypeID;
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

  public Integer getDoseCode() {
    return doseCode;
  }

  public void setDoseCode(Integer doseCode) {
    this.doseCode = doseCode;
  }
}
