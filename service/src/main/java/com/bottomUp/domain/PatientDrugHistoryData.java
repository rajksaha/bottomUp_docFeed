package com.bottomUp.domain;


import com.bottomUp.domain.common.BaseData;

public class PatientDrugHistoryData extends BaseData {

  private String drugHistoryID;
  private String patientID;
  private String drugName;
  private Integer currentStatus;

  public String getDrugHistoryID() {
    return drugHistoryID;
  }

  public void setDrugHistoryID(String drugHistoryID) {
    this.drugHistoryID = drugHistoryID;
  }

  public String getPatientID() {
    return patientID;
  }

  public void setPatientID(String patientID) {
    this.patientID = patientID;
  }

  public String getDrugName() {
    return drugName;
  }

  public void setDrugName(String drugName) {
    this.drugName = drugName;
  }

  public Integer getCurrentStatus() {
    return currentStatus;
  }

  public void setCurrentStatus(Integer currentStatus) {
    this.currentStatus = currentStatus;
  }
}
