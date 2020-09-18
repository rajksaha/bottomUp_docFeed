package com.bottomUp.domain;


import com.bottomUp.domain.common.BaseData;

public class DoctorPreferenceAdviceData extends BaseData {

  private long advicePreferenceID;
  private long doctorID;
  private long adviceID;
  private long displayOrder;

  public long getAdvicePreferenceID() {
    return advicePreferenceID;
  }

  public void setAdvicePreferenceID(long advicePreferenceID) {
    this.advicePreferenceID = advicePreferenceID;
  }

  public long getDoctorID() {
    return doctorID;
  }

  public void setDoctorID(long doctorID) {
    this.doctorID = doctorID;
  }

  public long getAdviceID() {
    return adviceID;
  }

  public void setAdviceID(long adviceID) {
    this.adviceID = adviceID;
  }

  public long getDisplayOrder() {
    return displayOrder;
  }

  public void setDisplayOrder(long displayOrder) {
    this.displayOrder = displayOrder;
  }
}
