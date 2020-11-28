package com.bottomUp.domain;


import com.bottomUp.domain.common.BaseData;

public class ContentDrugAdviceData extends BaseData {

  private Long drugAdviceID;
  private Long doctorType;
  private String bangla;
  private String english;
  private String pdf;

  public Long getDrugAdviceID() {
    return drugAdviceID;
  }

  public void setDrugAdviceID(Long drugAdviceID) {
    this.drugAdviceID = drugAdviceID;
  }

  public Long getDoctorType() {
    return doctorType;
  }

  public void setDoctorType(Long doctorType) {
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
