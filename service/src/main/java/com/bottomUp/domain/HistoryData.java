package com.bottomUp.domain;


import com.bottomUp.domain.common.BaseData;

public class HistoryData extends BaseData {

  private String historyID;
  private String typeCode;
  private String name;
  private String shortName;

  public String getHistoryID() {
    return historyID;
  }

  public void setHistoryID(String historyID) {
    this.historyID = historyID;
  }

  public String getTypeCode() {
    return typeCode;
  }

  public void setTypeCode(String typeCode) {
    this.typeCode = typeCode;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getShortName() {
    return shortName;
  }

  public void setShortName(String shortName) {
    this.shortName = shortName;
  }
}
