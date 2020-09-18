package com.bottomUp.domain;

import com.bottomUp.domain.common.BaseData;

public class PrescriptionDiagnosisData extends BaseData {

  private long diagnosisID;
  private long appointMentId;
  private long diseaseId;
  private String note;

  public long getDiagnosisID() {
    return diagnosisID;
  }

  public void setDiagnosisID(long diagnosisID) {
    this.diagnosisID = diagnosisID;
  }

  public long getAppointMentId() {
    return appointMentId;
  }

  public void setAppointMentId(long appointMentId) {
    this.appointMentId = appointMentId;
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
}
