package com.bottomUp.domain;


import com.bottomUp.domain.common.BaseData;

import java.sql.Date;

public class PrescriptionNextVisitData  extends BaseData {

  private long appointmentID;
  private long nextVisitType;
  private java.sql.Date date;
  private long numOfDay;
  private long daytype;

  public long getAppointmentID() {
    return appointmentID;
  }

  public void setAppointmentID(long appointmentID) {
    this.appointmentID = appointmentID;
  }

  public long getNextVisitType() {
    return nextVisitType;
  }

  public void setNextVisitType(long nextVisitType) {
    this.nextVisitType = nextVisitType;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public long getNumOfDay() {
    return numOfDay;
  }

  public void setNumOfDay(long numOfDay) {
    this.numOfDay = numOfDay;
  }

  public long getDaytype() {
    return daytype;
  }

  public void setDaytype(long daytype) {
    this.daytype = daytype;
  }
}
