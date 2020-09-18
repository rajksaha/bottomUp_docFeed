package com.bottomUp.domain;


import com.bottomUp.domain.common.BaseData;

public class DoctorVitalSettingData extends BaseData {

  private long vitalSettingID;
  private long doctorID;
  private long vitalID;
  private long displayOrder;

  public long getVitalSettingID() {
    return vitalSettingID;
  }

  public void setVitalSettingID(long vitalSettingID) {
    this.vitalSettingID = vitalSettingID;
  }

  public long getDoctorID() {
    return doctorID;
  }

  public void setDoctorID(long doctorID) {
    this.doctorID = doctorID;
  }

  public long getVitalID() {
    return vitalID;
  }

  public void setVitalID(long vitalID) {
    this.vitalID = vitalID;
  }

  public long getDisplayOrder() {
    return displayOrder;
  }

  public void setDisplayOrder(long displayOrder) {
    this.displayOrder = displayOrder;
  }
}
