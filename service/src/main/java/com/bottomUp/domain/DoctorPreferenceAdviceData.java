package com.bottomUp.domain;


import com.bottomUp.domain.common.BaseData;

public class DoctorPreferenceAdviceData extends BaseData {

  private long advicePreferenceID;
  private long doctorID;
  private long adviceID;
  private long displayOrder;
  private long type;
  private long lang;
  private String advice;
  private Long presAdviceID;
  private Boolean addedInPrescription;


  public long getAdvicePreferenceID() {
    return advicePreferenceID;
  }

  public void setAdvicePreferenceID(long advicePreferenceID) {
    this.advicePreferenceID = advicePreferenceID;
  }

  public long getDoctorID() {
    return doctorID;
  }

  public void setDoctorID(long doctorID) {
    this.doctorID = doctorID;
  }

  public long getAdviceID() {
    return adviceID;
  }

  public void setAdviceID(long adviceID) {
    this.adviceID = adviceID;
  }

  public long getDisplayOrder() {
    return displayOrder;
  }

  public void setDisplayOrder(long displayOrder) {
    this.displayOrder = displayOrder;
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

  public Long getPresAdviceID() {
    return presAdviceID;
  }

  public void setPresAdviceID(Long presAdviceID) {
    this.presAdviceID = presAdviceID;
  }

  public Boolean getAddedInPrescription() {
    return addedInPrescription;
  }

  public void setAddedInPrescription(Boolean addedInPrescription) {
    this.addedInPrescription = addedInPrescription;
  }
}
