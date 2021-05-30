package com.bottomUp.domain;


import com.bottomUp.domain.common.BaseData;

public class ContentSymptomData  extends BaseData {

  private String symptomID;
  private String symptomName;

  public String getSymptomID() {
    return symptomID;
  }

  public void setSymptomID(String symptomID) {
    this.symptomID = symptomID;
  }

  public String getSymptomName() {
    return symptomName;
  }

  public void setSymptomName(String symptomName) {
    this.symptomName = symptomName;
  }
}
