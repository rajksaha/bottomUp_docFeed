package com.bottomUp.domain;


import com.bottomUp.domain.common.BaseData;

public class DoctorVitalSettingData extends BaseData {

  private String vitalSettingID;
  private String doctorID;
  private String vitalID;
  private Integer displayOrder;

  private String vitalName;
  private String shortName;
  private String vitalUnit;

  private String presVitalID;
  private String vitalResult;
  private Boolean addedInPrescription;

  public String getVitalSettingID() {
    return vitalSettingID;
  }

  public void setVitalSettingID(String vitalSettingID) {
    this.vitalSettingID = vitalSettingID;
  }

  public String getDoctorID() {
    return doctorID;
  }

  public void setDoctorID(String doctorID) {
    this.doctorID = doctorID;
  }

  public String getVitalID() {
    return vitalID;
  }

  public void setVitalID(String vitalID) {
    this.vitalID = vitalID;
  }

  public Integer getDisplayOrder() {
    return displayOrder;
  }

  public void setDisplayOrder(Integer displayOrder) {
    this.displayOrder = displayOrder;
  }

  public String getVitalName() {
    return vitalName;
  }

  public void setVitalName(String vitalName) {
    this.vitalName = vitalName;
  }

  public String getShortName() {
    return shortName;
  }

  public void setShortName(String shortName) {
    this.shortName = shortName;
  }

  public String getVitalUnit() {
    return vitalUnit;
  }

  public void setVitalUnit(String vitalUnit) {
    this.vitalUnit = vitalUnit;
  }

  public String getPresVitalID() {
    return presVitalID;
  }

  public void setPresVitalID(String presVitalID) {
    this.presVitalID = presVitalID;
  }

  public String getVitalResult() {
    return vitalResult;
  }

  public void setVitalResult(String vitalResult) {
    this.vitalResult = vitalResult;
  }

  public Boolean getAddedInPrescription() {
    return addedInPrescription;
  }

  public void setAddedInPrescription(Boolean addedInPrescription) {
    this.addedInPrescription = addedInPrescription;
  }
}
