package com.bottomUp.domain;


import com.bottomUp.domain.common.BaseData;

public class ContentAdviceData extends BaseData {

  private String adviceID;
  private Integer type;
  private Integer lang;
  private String advice;
  private String pdf;


  public String getAdviceID() {
    return adviceID;
  }

  public void setAdviceID(String adviceID) {
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
