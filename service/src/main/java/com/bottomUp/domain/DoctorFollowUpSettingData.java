package com.bottomUp.domain;


import com.bottomUp.domain.common.BaseData;

public class DoctorFollowUpSettingData extends BaseData {

  private String followUpSettingID;
  private String doctorID;
  private String invID;
  private String patientTypeID;
  private Integer displayOrder;
  private String invName;

  public String getFollowUpSettingID() {
    return followUpSettingID;
  }

  public void setFollowUpSettingID(String followUpSettingID) {
    this.followUpSettingID = followUpSettingID;
  }

  public String getDoctorID() {
    return doctorID;
  }

  public void setDoctorID(String doctorID) {
    this.doctorID = doctorID;
  }

  public String getInvID() {
    return invID;
  }

  public void setInvID(String invID) {
    this.invID = invID;
  }

  public String getPatientTypeID() {
    return patientTypeID;
  }

  public void setPatientTypeID(String patientTypeID) {
    this.patientTypeID = patientTypeID;
  }

  public Integer getDisplayOrder() {
    return displayOrder;
  }

  public void setDisplayOrder(Integer displayOrder) {
    this.displayOrder = displayOrder;
  }

  public String getInvName() {
    return invName;
  }

  public void setInvName(String invName) {
    this.invName = invName;
  }
}
