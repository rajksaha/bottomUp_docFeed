package com.bottomUp.domain;


import com.bottomUp.domain.common.BaseData;

public class PrescriptionAdviceData extends BaseData {

  private long presAdviceID;
  private long appointmentID;
  private long adviceId;
  private long type;
  private long lang;
  private String advice;
  private String pdf;


  public long getPresAdviceID() {
    return presAdviceID;
  }

  public void setPresAdviceID(long presAdviceID) {
    this.presAdviceID = presAdviceID;
  }

  public long getAppointmentID() {
    return appointmentID;
  }

  public void setAppointmentID(long appointmentID) {
    this.appointmentID = appointmentID;
  }

  public long getType() {
    return type;
  }

  public void setType(long type) {
    this.type = type;
  }

  public long getLang() {
    return lang;
  }

  public void setLang(long lang) {
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

  public long getAdviceId() {
    return adviceId;
  }

  public void setAdviceId(long adviceId) {
    this.adviceId = adviceId;
  }
}
