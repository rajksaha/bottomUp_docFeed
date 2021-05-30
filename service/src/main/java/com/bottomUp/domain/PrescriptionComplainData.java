package com.bottomUp.domain;


import com.bottomUp.domain.common.BaseData;

public class PrescriptionComplainData extends BaseData {

  private String complainID;
  private String appointmentID;
  private String symptomID;
  private String symptomName;
  private double durationNum;
  private Integer durationType;
  private String detail;

  public String getComplainID() {
    return complainID;
  }

  public void setComplainID(String complainID) {
    this.complainID = complainID;
  }

  public String getAppointmentID() {
    return appointmentID;
  }

  public void setAppointmentID(String appointmentID) {
    this.appointmentID = appointmentID;
  }

  public String getSymptomID() {
    return symptomID;
  }

  public void setSymptomID(String symptomID) {
    this.symptomID = symptomID;
  }

  public String getSymptomName() {
    return symptomName;
  }

  public void setSymptomName(String symptomName) {
    this.symptomName = symptomName;
  }

  public double getDurationNum() {
    return durationNum;
  }

  public void setDurationNum(double durationNum) {
    this.durationNum = durationNum;
  }

  public Integer getDurationType() {
    return durationType;
  }

  public void setDurationType(Integer durationType) {
    this.durationType = durationType;
  }

  public String getDetail() {
    return detail;
  }

  public void setDetail(String detail) {
    this.detail = detail;
  }
}
