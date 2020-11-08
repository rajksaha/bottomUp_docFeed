package com.bottomUp.domain;

import com.bottomUp.domain.common.BaseData;

public class PrescriptionDiagnosisData extends BaseData {

  private long diagnosisID;
  private long appointmentID;
  private long diseaseId;
  private String diseaseName;
  private String note;

  public long getDiagnosisID() {
    return diagnosisID;
  }

  public void setDiagnosisID(long diagnosisID) {
    this.diagnosisID = diagnosisID;
  }

  public long getAppointmentID() {
    return appointmentID;
  }

  public void setAppointmentID(long appointmentID) {
    this.appointmentID = appointmentID;
  }

  public long getDiseaseId() {
    return diseaseId;
  }

  public void setDiseaseId(long diseaseId) {
    this.diseaseId = diseaseId;
  }

  public String getNote() {
    return note;
  }

  public void setNote(String note) {
    this.note = note;
  }

  public String getDiseaseName() {
    return diseaseName;
  }

  public void setDiseaseName(String diseaseName) {
    this.diseaseName = diseaseName;
  }
}
