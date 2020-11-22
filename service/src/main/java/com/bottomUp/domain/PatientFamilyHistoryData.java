package com.bottomUp.domain;


import com.bottomUp.domain.common.BaseData;

public class PatientFamilyHistoryData extends BaseData {

  private Long familyHistoryID;
  private Long patientID;
  private Long diseaseID;
  private String diseaseName;
  private Integer relation;
  private String relationName;
  private String present;
  private String type;
  private String detail;

  public Long getFamilyHistoryID() {
    return familyHistoryID;
  }

  public void setFamilyHistoryID(Long familyHistoryID) {
    this.familyHistoryID = familyHistoryID;
  }

  public Long getPatientID() {
    return patientID;
  }

  public void setPatientID(Long patientID) {
    this.patientID = patientID;
  }

  public Long getDiseaseID() {
    return diseaseID;
  }

  public void setDiseaseID(Long diseaseID) {
    this.diseaseID = diseaseID;
  }

  public Integer getRelation() {
    return relation;
  }

  public void setRelation(Integer relation) {
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

  public String getDiseaseName() {
    return diseaseName;
  }

  public void setDiseaseName(String diseaseName) {
    this.diseaseName = diseaseName;
  }

  public String getRelationName() {
    return relationName;
  }

  public void setRelationName(String relationName) {
    this.relationName = relationName;
  }
}
