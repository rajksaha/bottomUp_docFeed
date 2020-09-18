package com.bottomUp.domain;


import com.bottomUp.domain.common.BaseData;

public class ContentAdviceData extends BaseData {

  private long adviceID;
  private long type;
  private long lang;
  private String advice;
  private String pdf;


  public long getAdviceID() {
    return adviceID;
  }

  public void setAdviceID(long adviceID) {
    this.adviceID = adviceID;
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
}
