package com.bottomUp.domain;


import com.bottomUp.domain.common.BaseData;

public class PatientPastDiseaseData extends BaseData {

  private long patientPastDiseaseID;
  private long patientID;
  private long diseaseId;
  private long isPresent;
  private String detail;

  public long getPatientPastDiseaseID() {
    return patientPastDiseaseID;
  }

  public void setPatientPastDiseaseID(long patientPastDiseaseID) {
    this.patientPastDiseaseID = patientPastDiseaseID;
  }

  public long getPatientID() {
    return patientID;
  }

  public void setPatientID(long patientID) {
    this.patientID = patientID;
  }

  public long getDiseaseId() {
    return diseaseId;
  }

  public void setDiseaseId(long diseaseId) {
    this.diseaseId = diseaseId;
  }

  public long getIsPresent() {
    return isPresent;
  }

  public void setIsPresent(long isPresent) {
    this.isPresent = isPresent;
  }

  public String getDetail() {
    return detail;
  }

  public void setDetail(String detail) {
    this.detail = detail;
  }
}
