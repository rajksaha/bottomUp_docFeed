package com.bottomUp.domain;


import com.bottomUp.domain.common.BaseData;

public class PatientPastDiseaseData extends BaseData {

  private Long patientPastDiseaseID;
  private Long patientID;
  private Long diseaseID;
  private String diseaseName;
  private Integer isPresent;
  private String detail;

  public Long getPatientPastDiseaseID() {
    return patientPastDiseaseID;
  }

  public void setPatientPastDiseaseID(Long patientPastDiseaseID) {
    this.patientPastDiseaseID = patientPastDiseaseID;
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
