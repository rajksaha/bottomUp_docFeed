package com.bottomUp.domain;


import com.bottomUp.domain.common.BaseData;

public class PrescriptionReferenceData extends BaseData {

  private long prescriptionReferenceID;
  private long appointMentID;
  private long refferedDoctorId;

  public long getPrescriptionReferenceID() {
    return prescriptionReferenceID;
  }

  public void setPrescriptionReferenceID(long prescriptionReferenceID) {
    this.prescriptionReferenceID = prescriptionReferenceID;
  }

  public long getAppointMentID() {
    return appointMentID;
  }

  public void setAppointMentID(long appointMentID) {
    this.appointMentID = appointMentID;
  }

  public long getRefferedDoctorId() {
    return refferedDoctorId;
  }

  public void setRefferedDoctorId(long refferedDoctorId) {
    this.refferedDoctorId = refferedDoctorId;
  }
}
