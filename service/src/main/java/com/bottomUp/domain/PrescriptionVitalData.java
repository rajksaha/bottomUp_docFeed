package com.bottomUp.domain;


import com.bottomUp.domain.common.BaseData;

public class PrescriptionVitalData extends BaseData {

  private long presVitalId;
  private long appointmentId;
  private long vitalId;
  private String vitalResult;
  private String vitalName;
  private String vitalUnit;

  public long getPresVitalId() {
    return presVitalId;
  }

  public void setPresVitalId(long presVitalId) {
    this.presVitalId = presVitalId;
  }

  public long getVitalId() {
    return vitalId;
  }

  public void setVitalId(long vitalId) {
    this.vitalId = vitalId;
  }

  public String getVitalResult() {
    return vitalResult;
  }

  public void setVitalResult(String vitalResult) {
    this.vitalResult = vitalResult;
  }

  public long getAppointmentId() {
    return appointmentId;
  }

  public void setAppointmentId(long appointmentId) {
    this.appointmentId = appointmentId;
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
