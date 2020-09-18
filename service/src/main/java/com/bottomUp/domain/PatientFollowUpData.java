package com.bottomUp.domain;

import com.bottomUp.domain.common.BaseData;

public class PatientFollowUpData extends BaseData {

  private long patientFollowUpID;
  private long patientID;
  private long doctorID;
  private long invId;

  public long getPatientFollowUpID() {
    return patientFollowUpID;
  }

  public void setPatientFollowUpID(long patientFollowUpID) {
    this.patientFollowUpID = patientFollowUpID;
  }

  public long getPatientID() {
    return patientID;
  }

  public void setPatientID(long patientID) {
    this.patientID = patientID;
  }

  public long getDoctorID() {
    return doctorID;
  }

  public void setDoctorID(long doctorID) {
    this.doctorID = doctorID;
  }

  public long getInvId() {
    return invId;
  }

  public void setInvId(long invId) {
    this.invId = invId;
  }
}
