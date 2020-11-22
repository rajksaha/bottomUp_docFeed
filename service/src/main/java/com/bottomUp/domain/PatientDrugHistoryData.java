package com.bottomUp.domain;


import com.bottomUp.domain.common.BaseData;

public class PatientDrugHistoryData extends BaseData {

  private Long drugHistoryID;
  private Long patientID;
  private String drugName;
  private Integer currentStatus;

  public Long getDrugHistoryID() {
    return drugHistoryID;
  }

  public void setDrugHistoryID(Long drugHistoryID) {
    this.drugHistoryID = drugHistoryID;
  }

  public Long getPatientID() {
    return patientID;
  }

  public void setPatientID(Long patientID) {
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
