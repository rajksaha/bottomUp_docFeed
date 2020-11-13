package com.bottomUp.domain;


import com.bottomUp.domain.common.BaseData;

public class PrescriptionComplainData extends BaseData {

  private Long complainID;
  private Long appointmentID;
  private Long symptomID;
  private String symptomName;
  private double durationNum;
  private Long durationType;
  private String detail;

  public Long getComplainID() {
    return complainID;
  }

  public void setComplainID(Long complainID) {
    this.complainID = complainID;
  }

  public Long getSymptomID() {
    return symptomID;
  }

  public void setSymptomID(Long symptomID) {
    this.symptomID = symptomID;
  }

  public double getDurationNum() {
    return durationNum;
  }

  public void setDurationNum(double durationNum) {
    this.durationNum = durationNum;
  }

  public Long getDurationType() {
    return durationType;
  }

  public void setDurationType(Long durationType) {
    this.durationType = durationType;
  }

  public String getDetail() {
    return detail;
  }

  public void setDetail(String detail) {
    this.detail = detail;
  }

  public Long getAppointmentID() {
    return appointmentID;
  }

  public void setAppointmentID(Long appointmentID) {
    this.appointmentID = appointmentID;
  }

  public String getSymptomName() {
    return symptomName;
  }

  public void setSymptomName(String symptomName) {
    this.symptomName = symptomName;
  }
}
