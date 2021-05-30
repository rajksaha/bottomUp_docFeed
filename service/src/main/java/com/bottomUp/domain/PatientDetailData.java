package com.bottomUp.domain;


import com.bottomUp.domain.common.BaseData;

public class PatientDetailData extends BaseData {

  private String patientID;
  private Integer type;

  public String getPatientID() {
    return patientID;
  }

  public void setPatientID(String patientID) {
    this.patientID = patientID;
  }

  public Integer getType() {
    return type;
  }

  public void setType(Integer type) {
    this.type = type;
  }
}
