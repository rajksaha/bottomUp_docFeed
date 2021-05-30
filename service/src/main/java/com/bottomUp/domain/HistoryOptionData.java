package com.bottomUp.domain;


import com.bottomUp.domain.common.BaseData;

public class HistoryOptionData extends BaseData {

  private String historyID;
  private String optionName;

  public String getHistoryID() {
    return historyID;
  }

  public void setHistoryID(String historyID) {
    this.historyID = historyID;
  }

  public String getOptionName() {
    return optionName;
  }

  public void setOptionName(String optionName) {
    this.optionName = optionName;
  }
}
