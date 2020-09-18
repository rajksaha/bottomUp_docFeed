package com.bottomUp.domain;


import com.bottomUp.domain.common.BaseData;

public class ContentVitalOptionData  extends BaseData {

  private long vitalOptionID;
  private long vitalID;
  private String optionName;

  public long getVitalOptionID() {
    return vitalOptionID;
  }

  public void setVitalOptionID(long vitalOptionID) {
    this.vitalOptionID = vitalOptionID;
  }

  public long getVitalID() {
    return vitalID;
  }

  public void setVitalID(long vitalID) {
    this.vitalID = vitalID;
  }

  public String getOptionName() {
    return optionName;
  }

  public void setOptionName(String optionName) {
    this.optionName = optionName;
  }
}
