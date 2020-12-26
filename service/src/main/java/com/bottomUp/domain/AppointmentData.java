package com.bottomUp.domain;


import com.bottomUp.domain.common.BaseData;

import java.sql.Time;
import java.util.Date;


public class AppointmentData extends BaseData {

  private long appointmentID;
  private long doctorID;
  private long patientID;
  private Date appDate;
  private Time appTime;
  private Integer status;
  private Integer appointmentType;

  public long getAppointmentID() {
    return appointmentID;
  }

  public void setAppointmentID(long appointmentID) {
    this.appointmentID = appointmentID;
  }

  public long getDoctorID() {
    return doctorID;
  }

  public void setDoctorID(long doctorID) {
    this.doctorID = doctorID;
  }

  public long getPatientID() {
    return patientID;
  }

  public void setPatientID(long patientID) {
    this.patientID = patientID;
  }

  public Date getAppDate() {
    return appDate;
  }

  public void setAppDate(Date appDate) {
    this.appDate = appDate;
  }

  public Time getAppTime() {
    return appTime;
  }

  public void setAppTime(Time appTime) {
    this.appTime = appTime;
  }

  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

  public Integer getAppointmentType() {
    return appointmentType;
  }

  public void setAppointmentType(Integer appointmentType) {
    this.appointmentType = appointmentType;
  }
}
