package com.bottomUp.domain;


import com.bottomUp.domain.common.BaseData;

public class ContentSymptomData  extends BaseData {

  private long symptomID;
  private String symptomName;

  public long getSymptomID() {
    return symptomID;
  }

  public void setSymptomID(long symptomID) {
    this.symptomID = symptomID;
  }

  public String getSymptomName() {
    return symptomName;
  }

  public void setSymptomName(String symptomName) {
    this.symptomName = symptomName;
  }
}
