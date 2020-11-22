package com.bottomUp.domain;


import com.bottomUp.domain.common.BaseData;

public class PrescriptionAdviceData extends BaseData {

  private Long presAdviceID;
  private Long appointmentID;
  private Long adviceID;
  private Integer type;
  private Integer lang;
  private String advice;
  private String pdf;

  public Long getPresAdviceID() {
    return presAdviceID;
  }

  public void setPresAdviceID(Long presAdviceID) {
    this.presAdviceID = presAdviceID;
  }

  public Long getAppointmentID() {
    return appointmentID;
  }

  public void setAppointmentID(Long appointmentID) {
    this.appointmentID = appointmentID;
  }

  public Long getAdviceID() {
    return adviceID;
  }

  public void setAdviceID(Long adviceID) {
    this.adviceID = adviceID;
  }

  public Integer getType() {
    return type;
  }

  public void setType(Integer type) {
    this.type = type;
  }

  public Integer getLang() {
    return lang;
  }

  public void setLang(Integer lang) {
    this.lang = lang;
  }

  public String getAdvice() {
    return advice;
  }

  public void setAdvice(String advice) {
    this.advice = advice;
  }

  public String getPdf() {
    return pdf;
  }

  public void setPdf(String pdf) {
    this.pdf = pdf;
  }
}
