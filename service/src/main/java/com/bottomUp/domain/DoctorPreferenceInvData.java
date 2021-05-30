package com.bottomUp.domain;


import com.bottomUp.domain.common.BaseData;

public class DoctorPreferenceInvData extends BaseData {

  private String invPreferenceID;
  private String doctorID;
  private String invID;
  private Integer displayOrder;
  private String invName;
  private String invCategoryID;
  private String presInvID;
  private Boolean addedInPrescription;

  public String getInvPreferenceID() {
    return invPreferenceID;
  }

  public void setInvPreferenceID(String invPreferenceID) {
    this.invPreferenceID = invPreferenceID;
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

  public String getInvCategoryID() {
    return invCategoryID;
  }

  public void setInvCategoryID(String invCategoryID) {
    this.invCategoryID = invCategoryID;
  }

  public String getPresInvID() {
    return presInvID;
  }

  public void setPresInvID(String presInvID) {
    this.presInvID = presInvID;
  }

  public Boolean getAddedInPrescription() {
    return addedInPrescription;
  }

  public void setAddedInPrescription(Boolean addedInPrescription) {
    this.addedInPrescription = addedInPrescription;
  }
}
