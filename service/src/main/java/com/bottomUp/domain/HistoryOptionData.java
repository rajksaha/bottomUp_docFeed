package com.bottomUp.domain;


import com.bottomUp.domain.common.BaseData;

public class HistoryOptionData extends BaseData {

  private long historyID;
  private String optionName;

  public long getHistoryID() {
    return historyID;
  }

  public void setHistoryID(long historyID) {
    this.historyID = historyID;
  }

  public String getOptionName() {
    return optionName;
  }

  public void setOptionName(String optionName) {
    this.optionName = optionName;
  }
}
