package com.bottomUp.domain;


import com.bottomUp.domain.common.BaseData;

public class ContentDrugAdviceData extends BaseData {

  private long drugAdviceId;
  private long doctorType;
  private String bangla;
  private String english;
  private String pdf;

  public long getDrugAdviceId() {
    return drugAdviceId;
  }

  public void setDrugAdviceId(long drugAdviceId) {
    this.drugAdviceId = drugAdviceId;
  }

  public long getDoctorType() {
    return doctorType;
  }

  public void setDoctorType(long doctorType) {
    this.doctorType = doctorType;
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
