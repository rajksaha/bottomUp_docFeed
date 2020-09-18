package com.bottomUp.domain;


import com.bottomUp.domain.common.BaseData;

public class AppointmentTypeData extends BaseData{

  private long appointmentTypeID;
  private String name;
  private String shortName;


  public long getAppointmentTypeID() {
    return appointmentTypeID;
  }

  public void setAppointmentTypeID(long appointmentTypeID) {
    this.appointmentTypeID = appointmentTypeID;
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
}
