package com.bottomUp.domain;


import com.bottomUp.domain.common.BaseData;

public class ReferredDoctorData extends BaseData {

  private long referredDoctorID;
  private String doctorName;
  private String doctorAddress;

  public long getReferredDoctorID() {
    return referredDoctorID;
  }

  public void setReferredDoctorID(long referredDoctorID) {
    this.referredDoctorID = referredDoctorID;
  }

  public String getDoctorName() {
    return doctorName;
  }

  public void setDoctorName(String doctorName) {
    this.doctorName = doctorName;
  }

  public String getDoctorAddress() {
    return doctorAddress;
  }

  public void setDoctorAddress(String doctorAddress) {
    this.doctorAddress = doctorAddress;
  }
}
