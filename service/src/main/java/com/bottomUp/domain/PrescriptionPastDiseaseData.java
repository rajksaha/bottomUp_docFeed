package com.bottomUp.domain;


import com.bottomUp.domain.common.BaseData;

public class PrescriptionPastDiseaseData  extends BaseData {

  private Long presPastDiseaseID;
  private Long appointmentID;
  private Long pastDiseaseID;
  private String diseaseName;

  public Long getPresPastDiseaseID() {
    return presPastDiseaseID;
  }

  public void setPresPastDiseaseID(Long presPastDiseaseID) {
    this.presPastDiseaseID = presPastDiseaseID;
  }

  public Long getAppointmentID() {
    return appointmentID;
  }

  public void setAppointmentID(Long appointmentID) {
    this.appointmentID = appointmentID;
  }

  public Long getPastDiseaseID() {
    return pastDiseaseID;
  }

  public void setPastDiseaseID(Long pastDiseaseID) {
    this.pastDiseaseID = pastDiseaseID;
  }

  public String getDiseaseName() {
    return diseaseName;
  }

  public void setDiseaseName(String diseaseName) {
    this.diseaseName = diseaseName;
  }
}
