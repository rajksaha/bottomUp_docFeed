package com.bottomUp.domain;


import com.bottomUp.domain.common.BaseData;

public class PatientFamilyHistoryData extends BaseData {

  private long familyHistoryID;
  private long patientID;
  private long diseaseID;
  private long relation;
  private String present;
  private String type;
  private String detail;

  public long getFamilyHistoryID() {
    return familyHistoryID;
  }

  public void setFamilyHistoryID(long familyHistoryID) {
    this.familyHistoryID = familyHistoryID;
  }

  public long getPatientID() {
    return patientID;
  }

  public void setPatientID(long patientID) {
    this.patientID = patientID;
  }

  public long getDiseaseID() {
    return diseaseID;
  }

  public void setDiseaseID(long diseaseID) {
    this.diseaseID = diseaseID;
  }

  public long getRelation() {
    return relation;
  }

  public void setRelation(long relation) {
    this.relation = relation;
  }

  public String getPresent() {
    return present;
  }

  public void setPresent(String present) {
    this.present = present;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getDetail() {
    return detail;
  }

  public void setDetail(String detail) {
    this.detail = detail;
  }
}
