package com.bottomUp.domain;


import com.bottomUp.domain.common.BaseData;

public class DoctorPreferenceAdviceData extends BaseData {

  private Long advicePreferenceID;
  private Long doctorID;
  private Long adviceID;
  private Integer displayOrder;
  private Integer type;
  private Integer lang;
  private String advice;
  private Long presAdviceID;
  private Boolean addedInPrescription;

  public Long getAdvicePreferenceID() {
    return advicePreferenceID;
  }

  public void setAdvicePreferenceID(Long advicePreferenceID) {
    this.advicePreferenceID = advicePreferenceID;
  }

  public Long getDoctorID() {
    return doctorID;
  }

  public void setDoctorID(Long doctorID) {
    this.doctorID = doctorID;
  }

  public Long getAdviceID() {
    return adviceID;
  }

  public void setAdviceID(Long adviceID) {
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
