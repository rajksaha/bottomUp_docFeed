package com.bottomUp.domain;

import com.bottomUp.domain.common.BaseData;

public class PrescriptionDiagnosisData extends BaseData {

  private Long diagnosisID;
  private Long appointmentID;
  private Long diseaseID;
  private String diseaseName;
  private String note;

  public Long getDiagnosisID() {
    return diagnosisID;
  }

  public void setDiagnosisID(Long diagnosisID) {
    this.diagnosisID = diagnosisID;
  }

  public Long getAppointmentID() {
    return appointmentID;
  }

  public void setAppointmentID(Long appointmentID) {
    this.appointmentID = appointmentID;
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

  public String getNote() {
    return note;
  }

  public void setNote(String note) {
    this.note = note;
  }
}
