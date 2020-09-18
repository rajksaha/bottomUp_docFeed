package com.bottomUp.domain;


import com.bottomUp.domain.common.BaseData;

public class ContentDiseaseData extends BaseData {

  private long diseaseID;
  private String diseaseName;

  public long getDiseaseID() {
    return diseaseID;
  }

  public void setDiseaseID(long diseaseID) {
    this.diseaseID = diseaseID;
  }

  public String getDiseaseName() {
    return diseaseName;
  }

  public void setDiseaseName(String diseaseName) {
    this.diseaseName = diseaseName;
  }
}
