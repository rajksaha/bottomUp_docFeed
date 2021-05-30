package com.bottomUp.domain;

import com.bottomUp.domain.common.BaseData;

public class DoctorAdviceDiseaseTemplateData  extends BaseData {

  private String templateID;
  private String doctorID;
  private String diseaseID;
  private String adviceID;

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

  public String getAdviceID() {
    return adviceID;
  }

  public void setAdviceID(String adviceID) {
    this.adviceID = adviceID;
  }
}
