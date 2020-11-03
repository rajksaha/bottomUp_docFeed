package com.bottomUp.domain;


import com.bottomUp.domain.common.BaseData;

public class PatientData extends BaseData {

  private long patientID;
  private long userID;
  private String patientCode;
  private String occupation;
  private String referredBy;
  private String hospitalName;
  private String bedNum;
  private String wardNum;
  private String headOfUnit;

  public long getPatientID() {
    return patientID;
  }

  public void setPatientID(long patientID) {
    this.patientID = patientID;
  }

  public long getUserID() {
    return userID;
  }

  public void setUserID(long userID) {
    this.userID = userID;
  }

  public String getPatientCode() {
    return patientCode;
  }

  public void setPatientCode(String patientCode) {
    this.patientCode = patientCode;
  }

  public String getOccupation() {
    return occupation;
  }

  public void setOccupation(String occupation) {
    this.occupation = occupation;
  }

  public String getReferredBy() {
    return referredBy;
  }

  public void setReferredBy(String referredBy) {
    this.referredBy = referredBy;
  }

  public String getHospitalName() {
    return hospitalName;
  }

  public void setHospitalName(String hospitalName) {
    this.hospitalName = hospitalName;
  }

  public String getBedNum() {
    return bedNum;
  }

  public void setBedNum(String bedNum) {
    this.bedNum = bedNum;
  }

  public String getWardNum() {
    return wardNum;
  }

  public void setWardNum(String wardNum) {
    this.wardNum = wardNum;
  }

  public String getHeadOfUnit() {
    return headOfUnit;
  }

  public void setHeadOfUnit(String headOfUnit) {
    this.headOfUnit = headOfUnit;
  }
}
