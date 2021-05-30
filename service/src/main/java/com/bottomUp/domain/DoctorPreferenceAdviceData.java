package com.bottomUp.domain;


import com.bottomUp.domain.common.BaseData;

public class DoctorPreferenceAdviceData extends BaseData {

  private String advicePreferenceID;
  private String doctorID;
  private String adviceID;
  private Integer displayOrder;
  private Integer type;
  private Integer lang;
  private String advice;
  private String presAdviceID;
  private Boolean addedInPrescription;

  public String getAdvicePreferenceID() {
    return advicePreferenceID;
  }

  public void setAdvicePreferenceID(String advicePreferenceID) {
    this.advicePreferenceID = advicePreferenceID;
  }

  public String getDoctorID() {
    return doctorID;
  }

  public void setDoctorID(String doctorID) {
    this.doctorID = doctorID;
  }

  public String getAdviceID() {
    return adviceID;
  }

  public void setAdviceID(String adviceID) {
    this.adviceID = adviceID;
  }

  public Integer getDisplayOrder() {
    return displayOrder;
  }

  public void setDisplayOrder(Integer displayOrder) {
    this.displayOrder = displayOrder;
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

  public String getPresAdviceID() {
    return presAdviceID;
  }

  public void setPresAdviceID(String presAdviceID) {
    this.presAdviceID = presAdviceID;
  }

  public Boolean getAddedInPrescription() {
    return addedInPrescription;
  }

  public void setAddedInPrescription(Boolean addedInPrescription) {
    this.addedInPrescription = addedInPrescription;
  }
}
