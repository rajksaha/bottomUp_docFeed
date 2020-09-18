package com.bottomUp.domain;


import com.bottomUp.domain.common.BaseData;

public class DoctorPreferenceInvData extends BaseData {

  private long invPreferenceID;
  private long doctorID;
  private long invID;
  private long displayOrder;

  public long getInvPreferenceID() {
    return invPreferenceID;
  }

  public void setInvPreferenceID(long invPreferenceID) {
    this.invPreferenceID = invPreferenceID;
  }

  public long getDoctorID() {
    return doctorID;
  }

  public void setDoctorID(long doctorID) {
    this.doctorID = doctorID;
  }

  public long getInvID() {
    return invID;
  }

  public void setInvID(long invID) {
    this.invID = invID;
  }

  public long getDisplayOrder() {
    return displayOrder;
  }

  public void setDisplayOrder(long displayOrder) {
    this.displayOrder = displayOrder;
  }
}
