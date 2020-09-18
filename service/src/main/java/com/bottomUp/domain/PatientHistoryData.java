package com.bottomUp.domain;


import com.bottomUp.domain.common.BaseData;

public class PatientHistoryData extends BaseData {

  private long patientHistoryID;
  private long patientID;
  private long historyID;
  private String historyResult;

  public long getPatientHistoryID() {
    return patientHistoryID;
  }

  public void setPatientHistoryID(long patientHistoryID) {
    this.patientHistoryID = patientHistoryID;
  }

  public long getPatientID() {
    return patientID;
  }

  public void setPatientID(long patientID) {
    this.patientID = patientID;
  }

  public long getHistoryID() {
    return historyID;
  }

  public void setHistoryID(long historyID) {
    this.historyID = historyID;
  }

  public String getHistoryResult() {
    return historyResult;
  }

  public void setHistoryResult(String historyResult) {
    this.historyResult = historyResult;
  }
}
