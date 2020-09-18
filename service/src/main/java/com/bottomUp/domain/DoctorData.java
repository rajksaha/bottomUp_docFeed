package com.bottomUp.domain;


import com.bottomUp.domain.common.BaseData;

public class DoctorData extends BaseData {

  private long userID;
  private long doctorID;
  private String doctorCode;
  private long hospitalID;


  public long getUserID() {
    return userID;
  }

  public void setUserID(long userID) {
    this.userID = userID;
  }

  public long getDoctorID() {
    return doctorID;
  }

  public void setDoctorID(long doctorID) {
    this.doctorID = doctorID;
  }

  public String getDoctorCode() {
    return doctorCode;
  }

  public void setDoctorCode(String doctorCode) {
    this.doctorCode = doctorCode;
  }

  public long getHospitalID() {
    return hospitalID;
  }

  public void setHospitalID(long hospitalID) {
    this.hospitalID = hospitalID;
  }
}
