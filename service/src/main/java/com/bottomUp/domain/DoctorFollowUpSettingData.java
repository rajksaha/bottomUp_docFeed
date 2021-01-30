package com.bottomUp.domain;


import com.bottomUp.domain.common.BaseData;

public class DoctorFollowUpSettingData extends BaseData {

  private Long followUpSettingID;
  private Long doctorID;
  private Long invID;
  private Long patientTypeID;
  private Integer displayOrder;
  private String invName;

  public Long getFollowUpSettingID() {
    return followUpSettingID;
  }

  public void setFollowUpSettingID(Long followUpSettingID) {
    this.followUpSettingID = followUpSettingID;
  }

  public Long getDoctorID() {
    return doctorID;
  }

  public void setDoctorID(Long doctorID) {
    this.doctorID = doctorID;
  }

  public Long getInvID() {
    return invID;
  }

  public void setInvID(Long invID) {
    this.invID = invID;
  }

  public Long getPatientTypeID() {
    return patientTypeID;
  }

  public void setPatientTypeID(Long patientTypeID) {
    this.patientTypeID = patientTypeID;
  }

  public String getInvName() {
    return invName;
  }

  public void setInvName(String invName) {
    this.invName = invName;
  }

  public Integer getDisplayOrder() {
    return displayOrder;
  }

  public void setDisplayOrder(Integer displayOrder) {
    this.displayOrder = displayOrder;
  }
}
