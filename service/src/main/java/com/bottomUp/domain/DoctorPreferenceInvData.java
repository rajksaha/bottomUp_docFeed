package com.bottomUp.domain;


import com.bottomUp.domain.common.BaseData;

public class DoctorPreferenceInvData extends BaseData {

  private Long invPreferenceID;
  private Long doctorID;
  private Long invID;
  private Long displayOrder;
  private String invName;
  private Long invCategoryID;
  private Long presInvID;
  private Boolean addedInPrescription;

  public Long getInvPreferenceID() {
    return invPreferenceID;
  }

  public void setInvPreferenceID(Long invPreferenceID) {
    this.invPreferenceID = invPreferenceID;
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

  public Long getDisplayOrder() {
    return displayOrder;
  }

  public void setDisplayOrder(Long displayOrder) {
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
