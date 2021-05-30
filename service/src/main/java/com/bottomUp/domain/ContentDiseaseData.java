package com.bottomUp.domain;


import com.bottomUp.domain.common.BaseData;

public class ContentDiseaseData extends BaseData {

  private String diseaseID;
  private String diseaseName;

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
}
