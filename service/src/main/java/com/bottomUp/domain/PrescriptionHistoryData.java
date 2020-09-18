package com.bottomUp.domain;


import com.bottomUp.domain.common.BaseData;

public class PrescriptionHistoryData  extends BaseData {

  private long presHistoryID;
  private long appointMentID;
  private long patientHistoryId;

  public long getPresHistoryID() {
    return presHistoryID;
  }

  public void setPresHistoryID(long presHistoryID) {
    this.presHistoryID = presHistoryID;
  }

  public long getAppointMentID() {
    return appointMentID;
  }

  public void setAppointMentID(long appointMentID) {
    this.appointMentID = appointMentID;
  }

  public long getPatientHistoryId() {
    return patientHistoryId;
  }

  public void setPatientHistoryId(long patientHistoryId) {
    this.patientHistoryId = patientHistoryId;
  }
}
