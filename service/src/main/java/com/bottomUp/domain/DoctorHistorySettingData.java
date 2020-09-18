package com.bottomUp.domain;


import com.bottomUp.domain.common.BaseData;

public class DoctorHistorySettingData extends BaseData {

  private long historySettingID;
  private long doctorID;
  private long historyID;
  private long displayOrder;

  public long getHistorySettingID() {
    return historySettingID;
  }

  public void setHistorySettingID(long historySettingID) {
    this.historySettingID = historySettingID;
  }

  public long getDoctorID() {
    return doctorID;
  }

  public void setDoctorID(long doctorID) {
    this.doctorID = doctorID;
  }

  public long getHistoryID() {
    return historyID;
  }

  public void setHistoryID(long historyID) {
    this.historyID = historyID;
  }

  public long getDisplayOrder() {
    return displayOrder;
  }

  public void setDisplayOrder(long displayOrder) {
    this.displayOrder = displayOrder;
  }
}
