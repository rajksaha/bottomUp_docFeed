package com.bottomUp.domain;


import com.bottomUp.domain.common.BaseData;

public class PrescriptionPastDiseaseData  extends BaseData {

  private long presPastDiseaseId;
  private long appointmentId;
  private long pastDiseaseId;
  private String diseaseName;

  public long getPresPastDiseaseId() {
    return presPastDiseaseId;
  }

  public void setPresPastDiseaseId(long presPastDiseaseId) {
    this.presPastDiseaseId = presPastDiseaseId;
  }

  public long getPastDiseaseId() {
    return pastDiseaseId;
  }

  public void setPastDiseaseId(long pastDiseaseId) {
    this.pastDiseaseId = pastDiseaseId;
  }

  public long getAppointmentId() {
    return appointmentId;
  }

  public void setAppointmentId(long appointmentId) {
    this.appointmentId = appointmentId;
  }

  public String getDiseaseName() {
    return diseaseName;
  }

  public void setDiseaseName(String diseaseName) {
    this.diseaseName = diseaseName;
  }
}
