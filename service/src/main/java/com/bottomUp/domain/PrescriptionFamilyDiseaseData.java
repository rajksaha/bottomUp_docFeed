package com.bottomUp.domain;


import com.bottomUp.domain.common.BaseData;

public class PrescriptionFamilyDiseaseData extends BaseData {

  private long presFamilyDiseaseID;
  private long appointMentID;
  private long familydiseaseID;

  public long getPresFamilyDiseaseID() {
    return presFamilyDiseaseID;
  }

  public void setPresFamilyDiseaseID(long presFamilyDiseaseID) {
    this.presFamilyDiseaseID = presFamilyDiseaseID;
  }

  public long getAppointMentID() {
    return appointMentID;
  }

  public void setAppointMentID(long appointMentID) {
    this.appointMentID = appointMentID;
  }

  public long getFamilydiseaseID() {
    return familydiseaseID;
  }

  public void setFamilydiseaseID(long familydiseaseID) {
    this.familydiseaseID = familydiseaseID;
  }
}
