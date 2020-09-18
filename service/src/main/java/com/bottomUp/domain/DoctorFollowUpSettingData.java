package com.bottomUp.domain;


import com.bottomUp.domain.common.BaseData;

public class DoctorFollowUpSettingData extends BaseData {

  private long followUpSettingID;
  private long doctorID;
  private long invID;
  private long patientTypeID;

  public long getFollowUpSettingID() {
    return followUpSettingID;
  }

  public void setFollowUpSettingID(long followUpSettingID) {
    this.followUpSettingID = followUpSettingID;
  }

  public long getDoctorID() {
    return doctorID;
  }

  public void setDoctorID(long doctorID) {
    this.doctorID = doctorID;
  }

  public long getInvID() {
    return invID;
  }

  public void setInvID(long invID) {
    this.invID = invID;
  }

  public long getPatientTypeID() {
    return patientTypeID;
  }

  public void setPatientTypeID(long patientTypeID) {
    this.patientTypeID = patientTypeID;
  }
}
