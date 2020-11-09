package com.bottomUp.domain;


import com.bottomUp.domain.common.BaseData;

public class PrescriptionReferenceData extends BaseData {

  private long prescriptionReferenceID;
  private long appointmentID;
  private long referredDoctorID;
  private String doctorName;
  private String doctorAddress;

  public long getPrescriptionReferenceID() {
    return prescriptionReferenceID;
  }

  public void setPrescriptionReferenceID(long prescriptionReferenceID) {
    this.prescriptionReferenceID = prescriptionReferenceID;
  }

  public long getAppointmentID() {
    return appointmentID;
  }

  public void setAppointmentID(long appointmentID) {
    this.appointmentID = appointmentID;
  }

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
