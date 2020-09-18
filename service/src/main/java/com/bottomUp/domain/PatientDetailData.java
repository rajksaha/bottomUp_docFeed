package com.bottomUp.domain;


import com.bottomUp.domain.common.BaseData;

public class PatientDetailData extends BaseData {

  private long patientID;
  private long type;

  public long getPatientID() {
    return patientID;
  }

  public void setPatientID(long patientID) {
    this.patientID = patientID;
  }

  public long getType() {
    return type;
  }

  public void setType(long type) {
    this.type = type;
  }
}
