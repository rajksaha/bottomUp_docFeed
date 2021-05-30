package com.bottomUp.domain;


import com.bottomUp.domain.common.BaseData;

public class PrescriptionReferenceData extends BaseData {

  private String prescriptionReferenceID;
  private String appointmentID;
  private String referredDoctorID;
  private String doctorName;
  private String doctorAddress;

  public String getPrescriptionReferenceID() {
    return prescriptionReferenceID;
  }

  public void setPrescriptionReferenceID(String prescriptionReferenceID) {
    this.prescriptionReferenceID = prescriptionReferenceID;
  }

  public String getAppointmentID() {
    return appointmentID;
  }

  public void setAppointmentID(String appointmentID) {
    this.appointmentID = appointmentID;
  }

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
