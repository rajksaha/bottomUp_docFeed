package com.bottomUp.domain;


import com.bottomUp.domain.common.BaseData;

public class ContentDayTypeData extends BaseData {

  private long dayTypeID;
  private String bangla;
  private String pdf;
  private String english;

  public long getDayTypeID() {
    return dayTypeID;
  }

  public void setDayTypeID(long dayTypeID) {
    this.dayTypeID = dayTypeID;
  }

  public String getBangla() {
    return bangla;
  }

  public void setBangla(String bangla) {
    this.bangla = bangla;
  }

  public String getPdf() {
    return pdf;
  }

  public void setPdf(String pdf) {
    this.pdf = pdf;
  }

  public String getEnglish() {
    return english;
  }

  public void setEnglish(String english) {
    this.english = english;
  }
}
