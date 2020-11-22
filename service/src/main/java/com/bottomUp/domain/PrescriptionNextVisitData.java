package com.bottomUp.domain;


import com.bottomUp.domain.common.BaseData;

import java.util.Date;


public class PrescriptionNextVisitData  extends BaseData {

  private Long appointmentID;
  private Integer nextVisitType;
  private Date date;
  private String stringDate;
  private Integer numOfDay;
  private Integer dayType;

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

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
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

  public Integer getDayType() {
    return dayType;
  }

  public void setDayType(Integer dayType) {
    this.dayType = dayType;
  }
}
