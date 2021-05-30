package com.bottomUp.domain;


import com.bottomUp.domain.common.BaseData;

public class PrescriptionPastDiseaseData  extends BaseData {

  private String presPastDiseaseID;
  private String appointmentID;
  private String pastDiseaseID;
  private String diseaseName;
  private Integer isPresent;

  public String getPresPastDiseaseID() {
    return presPastDiseaseID;
  }

  public void setPresPastDiseaseID(String presPastDiseaseID) {
    this.presPastDiseaseID = presPastDiseaseID;
  }

  public String getAppointmentID() {
    return appointmentID;
  }

  public void setAppointmentID(String appointmentID) {
    this.appointmentID = appointmentID;
  }

  public String getPastDiseaseID() {
    return pastDiseaseID;
  }

  public void setPastDiseaseID(String pastDiseaseID) {
    this.pastDiseaseID = pastDiseaseID;
  }

  public String getDiseaseName() {
    return diseaseName;
  }

  public void setDiseaseName(String diseaseName) {
    this.diseaseName = diseaseName;
  }

  public Integer getIsPresent() {
    return isPresent;
  }

  public void setIsPresent(Integer isPresent) {
    this.isPresent = isPresent;
  }
}
