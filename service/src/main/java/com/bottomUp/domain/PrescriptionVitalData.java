package com.bottomUp.domain;


import com.bottomUp.domain.common.BaseData;

public class PrescriptionVitalData extends BaseData {

  private String presVitalID;
  private String appointmentID;
  private String vitalID;
  private String vitalResult;
  private String vitalName;
  private String vitalUnit;

  public String getPresVitalID() {
    return presVitalID;
  }

  public void setPresVitalID(String presVitalID) {
    this.presVitalID = presVitalID;
  }

  public String getAppointmentID() {
    return appointmentID;
  }

  public void setAppointmentID(String appointmentID) {
    this.appointmentID = appointmentID;
  }

  public String getVitalID() {
    return vitalID;
  }

  public void setVitalID(String vitalID) {
    this.vitalID = vitalID;
  }

  public String getVitalResult() {
    return vitalResult;
  }

  public void setVitalResult(String vitalResult) {
    this.vitalResult = vitalResult;
  }

  public String getVitalName() {
    return vitalName;
  }

  public void setVitalName(String vitalName) {
    this.vitalName = vitalName;
  }

  public String getVitalUnit() {
    return vitalUnit;
  }

  public void setVitalUnit(String vitalUnit) {
    this.vitalUnit = vitalUnit;
  }
}
