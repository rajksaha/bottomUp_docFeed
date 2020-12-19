package com.bottomUp.domain;


import com.bottomUp.domain.common.BaseData;

public class ContentDurationTypeData extends BaseData {

  private Integer durationType;
  private String bangla;
  private String pdf;
  private String english;

  public Integer getDurationType() {
    return durationType;
  }

  public void setDurationType(Integer durationType) {
    this.durationType = durationType;
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
