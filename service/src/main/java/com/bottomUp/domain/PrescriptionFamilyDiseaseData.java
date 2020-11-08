package com.bottomUp.domain;


import com.bottomUp.domain.common.BaseData;

public class PrescriptionFamilyDiseaseData extends BaseData {

  private long presFamilyDiseaseID;
  private long appointmentID;
  private long familyDiseaseID;
  private long diseaseID;
  private String diseaseName;
  private long relation;
  private String present;
  private String type;
  private String detail;

  public long getPresFamilyDiseaseID() {
    return presFamilyDiseaseID;
  }

  public void setPresFamilyDiseaseID(long presFamilyDiseaseID) {
    this.presFamilyDiseaseID = presFamilyDiseaseID;
  }

  public long getAppointmentID() {
    return appointmentID;
  }

  public void setAppointmentID(long appointmentID) {
    this.appointmentID = appointmentID;
  }

  public long getFamilyDiseaseID() {
    return familyDiseaseID;
  }

  public void setFamilyDiseaseID(long familyDiseaseID) {
    this.familyDiseaseID = familyDiseaseID;
  }

  public long getDiseaseID() {
    return diseaseID;
  }

  public void setDiseaseID(long diseaseID) {
    this.diseaseID = diseaseID;
  }

  public String getDiseaseName() {
    return diseaseName;
  }

  public void setDiseaseName(String diseaseName) {
    this.diseaseName = diseaseName;
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
