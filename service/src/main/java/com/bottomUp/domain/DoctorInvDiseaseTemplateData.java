package com.bottomUp.domain;


import com.bottomUp.domain.common.BaseData;

public class DoctorInvDiseaseTemplateData extends BaseData {

  private String templateID;
  private String doctorID;
  private String diseaseID;
  private String invID;
  private String note;
  private Integer checked;

  public String getTemplateID() {
    return templateID;
  }

  public void setTemplateID(String templateID) {
    this.templateID = templateID;
  }

  public String getDoctorID() {
    return doctorID;
  }

  public void setDoctorID(String doctorID) {
    this.doctorID = doctorID;
  }

  public String getDiseaseID() {
    return diseaseID;
  }

  public void setDiseaseID(String diseaseID) {
    this.diseaseID = diseaseID;
  }

  public String getInvID() {
    return invID;
  }

  public void setInvID(String invID) {
    this.invID = invID;
  }

  public String getNote() {
    return note;
  }

  public void setNote(String note) {
    this.note = note;
  }

  public Integer getChecked() {
    return checked;
  }

  public void setChecked(Integer checked) {
    this.checked = checked;
  }
}
