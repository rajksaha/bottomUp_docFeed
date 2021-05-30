package com.bottomUp.domain;

import com.bottomUp.domain.common.BaseData;

public class PatientFollowUpData extends BaseData {

  private String patientFollowUpID;
  private String patientID;
  private String doctorID;
  private String invId;

  public String getPatientFollowUpID() {
    return patientFollowUpID;
  }

  public void setPatientFollowUpID(String patientFollowUpID) {
    this.patientFollowUpID = patientFollowUpID;
  }

  public String getPatientID() {
    return patientID;
  }

  public void setPatientID(String patientID) {
    this.patientID = patientID;
  }

  public String getDoctorID() {
    return doctorID;
  }

  public void setDoctorID(String doctorID) {
    this.doctorID = doctorID;
  }

  public String getInvId() {
    return invId;
  }

  public void setInvId(String invId) {
    this.invId = invId;
  }
}
