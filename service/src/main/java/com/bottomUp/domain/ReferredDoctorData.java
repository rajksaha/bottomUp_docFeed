package com.bottomUp.domain;


import com.bottomUp.domain.common.BaseData;

public class ReferredDoctorData extends BaseData {

  private String referredDoctorID;
  private String doctorName;
  private String doctorAddress;

  public String getReferredDoctorID() {
    return referredDoctorID;
  }

  public void setReferredDoctorID(String referredDoctorID) {
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
