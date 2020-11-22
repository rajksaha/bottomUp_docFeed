package com.bottomUp.domain;


import com.bottomUp.domain.common.BaseData;

public class PrescriptionFamilyDiseaseData extends BaseData {

  private Long presFamilyDiseaseID;
  private Long appointmentID;
  private Long familyDiseaseID;
  private Long diseaseID;
  private String diseaseName;
  private Integer relation;
  private String present;
  private String type;
  private String detail;

  public Long getPresFamilyDiseaseID() {
    return presFamilyDiseaseID;
  }

  public void setPresFamilyDiseaseID(Long presFamilyDiseaseID) {
    this.presFamilyDiseaseID = presFamilyDiseaseID;
  }

  public Long getAppointmentID() {
    return appointmentID;
  }

  public void setAppointmentID(Long appointmentID) {
    this.appointmentID = appointmentID;
  }

  public Long getFamilyDiseaseID() {
    return familyDiseaseID;
  }

  public void setFamilyDiseaseID(Long familyDiseaseID) {
    this.familyDiseaseID = familyDiseaseID;
  }

  public Long getDiseaseID() {
    return diseaseID;
  }

  public void setDiseaseID(Long diseaseID) {
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
