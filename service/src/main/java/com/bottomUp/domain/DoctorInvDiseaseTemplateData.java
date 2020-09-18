package com.bottomUp.domain;


import com.bottomUp.domain.common.BaseData;

public class DoctorInvDiseaseTemplateData extends BaseData {

  private long templateID;
  private long doctorID;
  private long diseaseID;
  private long invID;
  private String note;
  private long checked;

  public long getTemplateID() {
    return templateID;
  }

  public void setTemplateID(long templateID) {
    this.templateID = templateID;
  }

  public long getDoctorID() {
    return doctorID;
  }

  public void setDoctorID(long doctorID) {
    this.doctorID = doctorID;
  }

  public long getDiseaseID() {
    return diseaseID;
  }

  public void setDiseaseID(long diseaseID) {
    this.diseaseID = diseaseID;
  }

  public long getInvID() {
    return invID;
  }

  public void setInvID(long invID) {
    this.invID = invID;
  }

  public String getNote() {
    return note;
  }

  public void setNote(String note) {
    this.note = note;
  }

  public long getChecked() {
    return checked;
  }

  public void setChecked(long checked) {
    this.checked = checked;
  }
}
