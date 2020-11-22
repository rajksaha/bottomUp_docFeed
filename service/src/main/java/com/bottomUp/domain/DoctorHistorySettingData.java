package com.bottomUp.domain;


import com.bottomUp.domain.common.BaseData;

public class DoctorHistorySettingData extends BaseData {

  private Long historySettingID;
  private Long doctorID;
  private Long historyID;
  private Long displayOrder;

  private String typeCode;
  private String name;
  private String shortName;

  private String historyResult;
  private Long presHistoryID;
  private Long appointmentID;
  private Boolean addedInPrescription;

  public Long getHistorySettingID() {
    return historySettingID;
  }

  public void setHistorySettingID(Long historySettingID) {
    this.historySettingID = historySettingID;
  }

  public Long getDoctorID() {
    return doctorID;
  }

  public void setDoctorID(Long doctorID) {
    this.doctorID = doctorID;
  }

  public Long getHistoryID() {
    return historyID;
  }

  public void setHistoryID(Long historyID) {
    this.historyID = historyID;
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

  public Long getDisplayOrder() {
    return displayOrder;
  }

  public void setDisplayOrder(Long displayOrder) {
    this.displayOrder = displayOrder;
  }

  public String getHistoryResult() {
    return historyResult;
  }

  public void setHistoryResult(String historyResult) {
    this.historyResult = historyResult;
  }

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

  public Boolean getAddedInPrescription() {
    return addedInPrescription;
  }

  public void setAddedInPrescription(Boolean addedInPrescription) {
    this.addedInPrescription = addedInPrescription;
  }
}
