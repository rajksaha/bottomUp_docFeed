package com.bottomUp.domain;


import com.bottomUp.domain.common.BaseData;

public class DoctorPreferenceInvData extends BaseData {

  private long invPreferenceID;
  private long doctorID;
  private long invID;
  private long displayOrder;
  private String invName;
  private Long invCategoryID;
  private Long presInvID;
  private Boolean addedInPrescription;

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

  public String getInvName() {
    return invName;
  }

  public void setInvName(String invName) {
    this.invName = invName;
  }

  public Long getInvCategoryID() {
    return invCategoryID;
  }

  public void setInvCategoryID(Long invCategoryID) {
    this.invCategoryID = invCategoryID;
  }

  public Long getPresInvID() {
    return presInvID;
  }

  public void setPresInvID(Long presInvID) {
    this.presInvID = presInvID;
  }

  public Boolean getAddedInPrescription() {
    return addedInPrescription;
  }

  public void setAddedInPrescription(Boolean addedInPrescription) {
    this.addedInPrescription = addedInPrescription;
  }
}
