package com.bottomUp.domain;


import com.bottomUp.domain.common.BaseData;

public class DoctorDoseDrugDiseaseTemplateData extends BaseData {

  private long templateID;
  private String dose;
  private long numOfDay;
  private long durationType;

  public long getTemplateID() {
    return templateID;
  }

  public void setTemplateID(long templateID) {
    this.templateID = templateID;
  }

  public String getDose() {
    return dose;
  }

  public void setDose(String dose) {
    this.dose = dose;
  }

  public long getNumOfDay() {
    return numOfDay;
  }

  public void setNumOfDay(long numOfDay) {
    this.numOfDay = numOfDay;
  }

  public long getDurationType() {
    return durationType;
  }

  public void setDurationType(long durationType) {
    this.durationType = durationType;
  }
}
