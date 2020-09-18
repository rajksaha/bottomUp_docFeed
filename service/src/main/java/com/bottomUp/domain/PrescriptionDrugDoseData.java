package com.bottomUp.domain;


import com.bottomUp.domain.common.BaseData;

public class PrescriptionDrugDoseData extends BaseData {

  private long presDrugID;
  private String dose;
  private double numOfDay;
  private long durationtype;

  public long getPresDrugID() {
    return presDrugID;
  }

  public void setPresDrugID(long presDrugID) {
    this.presDrugID = presDrugID;
  }

  public String getDose() {
    return dose;
  }

  public void setDose(String dose) {
    this.dose = dose;
  }

  public double getNumOfDay() {
    return numOfDay;
  }

  public void setNumOfDay(double numOfDay) {
    this.numOfDay = numOfDay;
  }

  public long getDurationtype() {
    return durationtype;
  }

  public void setDurationtype(long durationtype) {
    this.durationtype = durationtype;
  }
}
