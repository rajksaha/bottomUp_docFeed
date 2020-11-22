package com.bottomUp.domain;


import com.bottomUp.domain.common.BaseData;

public class PrescriptionHistoryData  extends BaseData {

  private Long presHistoryID;
  private Long appointmentID;
  private Long patientHistoryID;
  private String typeCode;
  private String historyName;
  private String historyShortName;
  private String historyResult;

  public Long getPresHistoryID() {
    return presHistoryID;
  }

  public void setPresHistoryID(Long presHistoryID) {
    this.presHistoryID = presHistoryID;
  }

  public Long getAppointmentID() {
    return appointmentID;
  }

  public void setAppointmentID(Long appointmentID) {
    this.appointmentID = appointmentID;
  }

  public Long getPatientHistoryID() {
    return patientHistoryID;
  }

  public void setPatientHistoryID(Long patientHistoryID) {
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
