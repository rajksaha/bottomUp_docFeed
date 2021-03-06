package com.bottomUp.domain;


import com.bottomUp.domain.common.BaseData;

public class ContentDrugAdviceData extends BaseData {

  private String drugAdviceID;
  private String doctorType;
  private String bangla;
  private String english;
  private String pdf;

  public String getDrugAdviceID() {
    return drugAdviceID;
  }

  public void setDrugAdviceID(String drugAdviceID) {
    this.drugAdviceID = drugAdviceID;
  }

  public String getDoctorType() {
    return doctorType;
  }

  public void setDoctorType(String doctorType) {
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
