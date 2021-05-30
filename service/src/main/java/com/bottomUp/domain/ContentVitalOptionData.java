package com.bottomUp.domain;


import com.bottomUp.domain.common.BaseData;

public class ContentVitalOptionData  extends BaseData {

  private String vitalOptionID;
  private String vitalID;
  private String optionName;

  public String getVitalOptionID() {
    return vitalOptionID;
  }

  public void setVitalOptionID(String vitalOptionID) {
    this.vitalOptionID = vitalOptionID;
  }

  public String getVitalID() {
    return vitalID;
  }

  public void setVitalID(String vitalID) {
    this.vitalID = vitalID;
  }

  public String getOptionName() {
    return optionName;
  }

  public void setOptionName(String optionName) {
    this.optionName = optionName;
  }
}
