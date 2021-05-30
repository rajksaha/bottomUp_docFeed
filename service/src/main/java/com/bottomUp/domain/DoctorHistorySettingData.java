package com.bottomUp.domain;


import com.bottomUp.domain.common.BaseData;

public class DoctorHistorySettingData extends BaseData {

  private String historySettingID;
  private String doctorID;
  private String historyID;
  private Integer displayOrder;

  private String typeCode;
  private String name;
  private String shortName;

  private String historyResult;
  private String presHistoryID;
  private String appointmentID;
  private Boolean addedInPrescription;

  public String getHistorySettingID() {
    return historySettingID;
  }

  public void setHistorySettingID(String historySettingID) {
    this.historySettingID = historySettingID;
  }

  public String getDoctorID() {
    return doctorID;
  }

  public void setDoctorID(String doctorID) {
    this.doctorID = doctorID;
  }

  public String getHistoryID() {
    return historyID;
  }

  public void setHistoryID(String historyID) {
    this.historyID = historyID;
  }

  public Integer getDisplayOrder() {
    return displayOrder;
  }

  public void setDisplayOrder(Integer displayOrder) {
    this.displayOrder = displayOrder;
  }

  public String getTypeCode() {
    return typeCode;
  }

  public void setTypeCode(String typeCode) {
    this.typeCode = typeCode;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getShortName() {
    return shortName;
  }

  public void setShortName(String shortName) {
    this.shortName = shortName;
  }

  public String getHistoryResult() {
    return historyResult;
  }

  public void setHistoryResult(String historyResult) {
    this.historyResult = historyResult;
  }

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

  public Boolean getAddedInPrescription() {
    return addedInPrescription;
  }

  public void setAddedInPrescription(Boolean addedInPrescription) {
    this.addedInPrescription = addedInPrescription;
  }
}
