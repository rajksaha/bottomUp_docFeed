package com.bottomUp.domain;


import com.bottomUp.domain.common.BaseData;

public class ContentVitalData extends BaseData {

  private String vitalID;
  private String vitalName;
  private String shortName;
  private String vitalUnit;

  public String getVitalID() {
    return vitalID;
  }

  public void setVitalID(String vitalID) {
    this.vitalID = vitalID;
  }

  public String getVitalName() {
    return vitalName;
  }

  public void setVitalName(String vitalName) {
    this.vitalName = vitalName;
  }

  public String getShortName() {
    return shortName;
  }

  public void setShortName(String shortName) {
    this.shortName = shortName;
  }

  public String getVitalUnit() {
    return vitalUnit;
  }

  public void setVitalUnit(String vitalUnit) {
    this.vitalUnit = vitalUnit;
  }
}
