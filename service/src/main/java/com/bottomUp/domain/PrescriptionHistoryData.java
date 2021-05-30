package com.bottomUp.domain;


import com.bottomUp.domain.common.BaseData;

public class PrescriptionHistoryData  extends BaseData {

  private String presHistoryID;
  private String appointmentID;
  private String patientHistoryID;
  private String typeCode;
  private String historyName;
  private String historyShortName;
  private String historyResult;

  public String getPresHistoryID() {
    return presHistoryID;
  }

  public void setPresHistoryID(String presHistoryID) {
    this.presHistoryID = presHistoryID;
  }

  public String getAppointmentID() {
    return appointmentID;
  }

  public void setAppointmentID(String appointmentID) {
    this.appointmentID = appointmentID;
  }

  public String getPatientHistoryID() {
    return patientHistoryID;
  }

  public void setPatientHistoryID(String patientHistoryID) {
    this.patientHistoryID = patientHistoryID;
  }

  public String getTypeCode() {
    return typeCode;
  }

  public void setTypeCode(String typeCode) {
    this.typeCode = typeCode;
  }

  public String getHistoryName() {
    return historyName;
  }

  public void setHistoryName(String historyName) {
    this.historyName = historyName;
  }

  public String getHistoryShortName() {
    return historyShortName;
  }

  public void setHistoryShortName(String historyShortName) {
    this.historyShortName = historyShortName;
  }

  public String getHistoryResult() {
    return historyResult;
  }

  public void setHistoryResult(String historyResult) {
    this.historyResult = historyResult;
  }
}
