package com.bottomUp.domain;


import com.bottomUp.domain.common.BaseData;

public class DoctorDrugDoseSettingData  extends BaseData {

  private long drugDoseSettingID;
  private long drugSettingID;
  private String dose;
  private long numOfDay;
  private long durationType;

  public long getDrugDoseSettingID() {
    return drugDoseSettingID;
  }

  public void setDrugDoseSettingID(long drugDoseSettingID) {
    this.drugDoseSettingID = drugDoseSettingID;
  }

  public long getDrugSettingID() {
    return drugSettingID;
  }

  public void setDrugSettingID(long drugSettingID) {
    this.drugSettingID = drugSettingID;
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
