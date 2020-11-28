package com.bottomUp.domain;


import com.bottomUp.domain.common.BaseData;

public class DoctorDrugDoseSettingData  extends BaseData {

  private Long drugDoseSettingID;
  private Long drugSettingID;
  private String dose;
  private Integer numOfDay;
  private Integer durationType;

  public Long getDrugDoseSettingID() {
    return drugDoseSettingID;
  }

  public void setDrugDoseSettingID(Long drugDoseSettingID) {
    this.drugDoseSettingID = drugDoseSettingID;
  }

  public Long getDrugSettingID() {
    return drugSettingID;
  }

  public void setDrugSettingID(Long drugSettingID) {
    this.drugSettingID = drugSettingID;
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
