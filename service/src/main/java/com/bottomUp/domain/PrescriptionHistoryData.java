package com.bottomUp.domain;


import com.bottomUp.domain.common.BaseData;

public class PrescriptionHistoryData  extends BaseData {

  private long presHistoryID;
  private long appointmentID;
  private long patientHistoryId;
  private String typeCode;
  private String historyName;
  private String historyShortName;
  private String historyResult;

  public long getPresHistoryID() {
    return presHistoryID;
  }

  public void setPresHistoryID(long presHistoryID) {
    this.presHistoryID = presHistoryID;
  }

  public long getPatientHistoryId() {
    return patientHistoryId;
  }

  public void setPatientHistoryId(long patientHistoryId) {
    this.patientHistoryId = patientHistoryId;
  }

  public long getAppointmentID() {
    return appointmentID;
  }

  public void setAppointmentID(long appointmentID) {
    this.appointmentID = appointmentID;
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
