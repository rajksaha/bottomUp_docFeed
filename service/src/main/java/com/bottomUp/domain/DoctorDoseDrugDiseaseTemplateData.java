package com.bottomUp.domain;


import com.bottomUp.domain.common.BaseData;

public class DoctorDoseDrugDiseaseTemplateData extends BaseData {

  private String templateID;
  private String dose;
  private Integer numOfDay;
  private Integer durationType;

  public String getTemplateID() {
    return templateID;
  }

  public void setTemplateID(String templateID) {
    this.templateID = templateID;
  }

  public String getDose() {
    return dose;
  }

  public void setDose(String dose) {
    this.dose = dose;
  }

  public Integer getNumOfDay() {
    return numOfDay;
  }

  public void setNumOfDay(Integer numOfDay) {
    this.numOfDay = numOfDay;
  }

  public Integer getDurationType() {
    return durationType;
  }

  public void setDurationType(Integer durationType) {
    this.durationType = durationType;
  }
}
