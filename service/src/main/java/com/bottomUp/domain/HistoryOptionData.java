package com.bottomUp.domain;


import com.bottomUp.domain.common.BaseData;

public class HistoryOptionData extends BaseData {

  private Long historyID;
  private String optionName;

  public Long getHistoryID() {
    return historyID;
  }

  public void setHistoryID(Long historyID) {
    this.historyID = historyID;
  }

  public String getOptionName() {
    return optionName;
  }

  public void setOptionName(String optionName) {
    this.optionName = optionName;
  }
}
