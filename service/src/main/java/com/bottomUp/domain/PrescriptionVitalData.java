package com.bottomUp.domain;


import com.bottomUp.domain.common.BaseData;

public class PrescriptionVitalData extends BaseData {

  private Long presVitalID;
  private Long appointmentID;
  private Long vitalID;
  private String vitalResult;
  private String vitalName;
  private String vitalUnit;

  public Long getPresVitalID() {
    return presVitalID;
  }

  public void setPresVitalID(Long presVitalID) {
    this.presVitalID = presVitalID;
  }

  public Long getAppointmentID() {
    return appointmentID;
  }

  public void setAppointmentID(Long appointmentID) {
    this.appointmentID = appointmentID;
  }

  public Long getVitalID() {
    return vitalID;
  }

  public void setVitalID(Long vitalID) {
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
