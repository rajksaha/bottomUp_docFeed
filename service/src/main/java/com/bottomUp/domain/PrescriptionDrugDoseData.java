package com.bottomUp.domain;


import com.bottomUp.domain.common.BaseData;

public class PrescriptionDrugDoseData extends BaseData {

  private Long presDrugID;
  private String dose;
  private Integer numOfDay;
  private Integer durationType;

  public Long getPresDrugID() {
    return presDrugID;
  }

  public void setPresDrugID(Long presDrugID) {
    this.presDrugID = presDrugID;
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
