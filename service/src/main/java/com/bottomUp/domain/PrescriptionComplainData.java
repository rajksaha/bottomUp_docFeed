package com.bottomUp.domain;


import com.bottomUp.domain.common.BaseData;

public class PrescriptionComplainData extends BaseData {

  private long complainID;
  private long appointmentID;
  private long symptomID;
  private String symptomName;
  private double durationNum;
  private long durationType;
  private String detail;

  public long getComplainID() {
    return complainID;
  }

  public void setComplainID(long complainID) {
    this.complainID = complainID;
  }

  public long getSymptomID() {
    return symptomID;
  }

  public void setSymptomID(long symptomID) {
    this.symptomID = symptomID;
  }

  public double getDurationNum() {
    return durationNum;
  }

  public void setDurationNum(double durationNum) {
    this.durationNum = durationNum;
  }

  public long getDurationType() {
    return durationType;
  }

  public void setDurationType(long durationType) {
    this.durationType = durationType;
  }

  public String getDetail() {
    return detail;
  }

  public void setDetail(String detail) {
    this.detail = detail;
  }

  public long getAppointmentID() {
    return appointmentID;
  }

  public void setAppointmentID(long appointmentID) {
    this.appointmentID = appointmentID;
  }

  public String getSymptomName() {
    return symptomName;
  }

  public void setSymptomName(String symptomName) {
    this.symptomName = symptomName;
  }
}
