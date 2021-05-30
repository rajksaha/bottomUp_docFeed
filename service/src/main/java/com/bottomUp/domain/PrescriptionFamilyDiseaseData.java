package com.bottomUp.domain;


import com.bottomUp.domain.common.BaseData;

public class PrescriptionFamilyDiseaseData extends BaseData {

  private String presFamilyDiseaseID;
  private String appointmentID;
  private String familyDiseaseID;
  private String diseaseID;
  private String diseaseName;
  private Integer relation;
  private String relationName;
  private String present;
  private String type;
  private String detail;

  public String getPresFamilyDiseaseID() {
    return presFamilyDiseaseID;
  }

  public void setPresFamilyDiseaseID(String presFamilyDiseaseID) {
    this.presFamilyDiseaseID = presFamilyDiseaseID;
  }

  public String getAppointmentID() {
    return appointmentID;
  }

  public void setAppointmentID(String appointmentID) {
    this.appointmentID = appointmentID;
  }

  public String getFamilyDiseaseID() {
    return familyDiseaseID;
  }

  public void setFamilyDiseaseID(String familyDiseaseID) {
    this.familyDiseaseID = familyDiseaseID;
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
