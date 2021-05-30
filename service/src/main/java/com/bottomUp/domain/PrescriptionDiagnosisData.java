package com.bottomUp.domain;

import com.bottomUp.domain.common.BaseData;

public class PrescriptionDiagnosisData extends BaseData {

  private String diagnosisID;
  private String appointmentID;
  private String diseaseID;
  private String diseaseName;
  private String note;

  public String getDiagnosisID() {
    return diagnosisID;
  }

  public void setDiagnosisID(String diagnosisID) {
    this.diagnosisID = diagnosisID;
  }

  public String getAppointmentID() {
    return appointmentID;
  }

  public void setAppointmentID(String appointmentID) {
    this.appointmentID = appointmentID;
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

  public String getNote() {
    return note;
  }

  public void setNote(String note) {
    this.note = note;
  }
}
