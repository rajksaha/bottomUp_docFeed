package com.bottomUp.domain;


import com.bottomUp.domain.common.BaseData;

public class PatientPastDiseaseData extends BaseData {

  private String patientPastDiseaseID;
  private String patientID;
  private String diseaseID;
  private String diseaseName;
  private Integer isPresent;
  private String detail;

  public String getPatientPastDiseaseID() {
    return patientPastDiseaseID;
  }

  public void setPatientPastDiseaseID(String patientPastDiseaseID) {
    this.patientPastDiseaseID = patientPastDiseaseID;
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

  public Integer getIsPresent() {
    return isPresent;
  }

  public void setIsPresent(Integer isPresent) {
    this.isPresent = isPresent;
  }

  public String getDetail() {
    return detail;
  }

  public void setDetail(String detail) {
    this.detail = detail;
  }
}
