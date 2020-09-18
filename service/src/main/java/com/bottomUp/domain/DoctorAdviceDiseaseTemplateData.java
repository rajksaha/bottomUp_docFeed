package com.bottomUp.domain;

import com.bottomUp.domain.common.BaseData;

public class DoctorAdviceDiseaseTemplateData  extends BaseData {

  private long templateID;
  private long doctorID;
  private long diseaseID;
  private long adviceID;

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

  public long getAdviceID() {
    return adviceID;
  }

  public void setAdviceID(long adviceID) {
    this.adviceID = adviceID;
  }
}
