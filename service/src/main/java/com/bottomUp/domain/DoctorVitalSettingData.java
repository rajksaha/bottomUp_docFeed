package com.bottomUp.domain;


import com.bottomUp.domain.common.BaseData;

public class DoctorVitalSettingData extends BaseData {

  private Long vitalSettingID;
  private Long doctorID;
  private Long vitalID;
  private Integer displayOrder;

  private String vitalName;
  private String shortName;
  private String vitalUnit;

  private Long presVitalID;
  private String vitalResult;
  private Boolean addedInPrescription;

  public Long getVitalSettingID() {
    return vitalSettingID;
  }

  public void setVitalSettingID(Long vitalSettingID) {
    this.vitalSettingID = vitalSettingID;
  }

  public Long getDoctorID() {
    return doctorID;
  }

  public void setDoctorID(Long doctorID) {
    this.doctorID = doctorID;
  }

  public Long getVitalID() {
    return vitalID;
  }

  public void setVitalID(Long vitalID) {
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

  public Long getPresVitalID() {
    return presVitalID;
  }

  public void setPresVitalID(Long presVitalID) {
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
