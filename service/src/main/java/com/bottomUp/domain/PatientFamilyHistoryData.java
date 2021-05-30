package com.bottomUp.domain;


import com.bottomUp.domain.common.BaseData;

public class PatientFamilyHistoryData extends BaseData {

  private String familyHistoryID;
  private String patientID;
  private String diseaseID;
  private String diseaseName;
  private Integer relation;
  private String relationName;
  private String present;
  private String type;
  private String detail;

  public String getFamilyHistoryID() {
    return familyHistoryID;
  }

  public void setFamilyHistoryID(String familyHistoryID) {
    this.familyHistoryID = familyHistoryID;
  }

  public String getPatientID() {
    return patientID;
  }

  public void setPatientID(String patientID) {
    this.patientID = patientID;
  }

  public String getDiseaseID() {
    return diseaseID;
  }

  public void setDiseaseID(String diseaseID) {
    this.diseaseID = diseaseID;
  }

  public String getDiseaseName() {
    return diseaseName;
  }

  public void setDiseaseName(String diseaseName) {
    this.diseaseName = diseaseName;
  }

  public Integer getRelation() {
    return relation;
  }

  public void setRelation(Integer relation) {
    this.relation = relation;
  }

  public String getRelationName() {
    return relationName;
  }

  public void setRelationName(String relationName) {
    this.relationName = relationName;
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
