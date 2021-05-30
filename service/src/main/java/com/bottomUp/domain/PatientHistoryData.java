package com.bottomUp.domain;


import com.bottomUp.domain.common.BaseData;

public class PatientHistoryData extends BaseData {

  private String patientHistoryID;
  private String patientID;
  private String historyID;
  private String historyResult;

  public String getPatientHistoryID() {
    return patientHistoryID;
  }

  public void setPatientHistoryID(String patientHistoryID) {
    this.patientHistoryID = patientHistoryID;
  }

  public String getPatientID() {
    return patientID;
  }

  public void setPatientID(String patientID) {
    this.patientID = patientID;
  }

  public String getHistoryID() {
    return historyID;
  }

  public void setHistoryID(String historyID) {
    this.historyID = historyID;
  }

  public String getHistoryResult() {
    return historyResult;
  }

  public void setHistoryResult(String historyResult) {
    this.historyResult = historyResult;
  }
}
