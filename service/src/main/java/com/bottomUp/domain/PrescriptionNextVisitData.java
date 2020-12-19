package com.bottomUp.domain;


import com.bottomUp.domain.common.BaseData;

import java.util.Date;


public class PrescriptionNextVisitData  extends BaseData {

  private Long presNextVisitID;
  private Long appointmentID;
  private Integer nextVisitType;
  private Date visitDate;
  private String stringDate;
  private Integer numOfDay;
  private Integer durationType;

  public Long getPresNextVisitID() {
    return presNextVisitID;
  }

  public void setPresNextVisitID(Long presNextVisitID) {
    this.presNextVisitID = presNextVisitID;
  }

  public Long getAppointmentID() {
    return appointmentID;
  }

  public void setAppointmentID(Long appointmentID) {
    this.appointmentID = appointmentID;
  }

  public Integer getNextVisitType() {
    return nextVisitType;
  }

  public void setNextVisitType(Integer nextVisitType) {
    this.nextVisitType = nextVisitType;
  }

  public Date getVisitDate() {
    return visitDate;
  }

  public void setVisitDate(Date visitDate) {
    this.visitDate = visitDate;
  }

  public String getStringDate() {
    return stringDate;
  }

  public void setStringDate(String stringDate) {
    this.stringDate = stringDate;
  }

  public Integer getNumOfDay() {
    return numOfDay;
  }

  public void setNumOfDay(Integer numOfDay) {
    this.numOfDay = numOfDay;
  }

  public Integer getDurationType() {
    return durationType;
  }

  public void setDurationType(Integer durationType) {
    this.durationType = durationType;
  }
}
