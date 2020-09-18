package com.bottomUp.domain;


import com.bottomUp.domain.common.BaseData;

public class PatientDrugHistoryData extends BaseData {

  private long drugHistoryID;
  private long patientID;
  private String drugName;
  private long currentStatus;

  public long getDrugHistoryID() {
    return drugHistoryID;
  }

  public void setDrugHistoryID(long drugHistoryID) {
    this.drugHistoryID = drugHistoryID;
  }

  public long getPatientID() {
    return patientID;
  }

  public void setPatientID(long patientID) {
    this.patientID = patientID;
  }

  public String getDrugName() {
    return drugName;
  }

  public void setDrugName(String drugName) {
    this.drugName = drugName;
  }

  public long getCurrentStatus() {
    return currentStatus;
  }

  public void setCurrentStatus(long currentStatus) {
    this.currentStatus = currentStatus;
  }
}
