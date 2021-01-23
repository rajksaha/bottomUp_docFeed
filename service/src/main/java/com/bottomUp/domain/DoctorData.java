package com.bottomUp.domain;


import com.bottomUp.domain.common.BaseData;

public class DoctorData extends BaseData {

  private Long userID;
  private Long doctorID;
  private String doctorCode;
  private Integer categoryID;
  private String firstName;


  public Long getUserID() {
    return userID;
  }

  public void setUserID(Long userID) {
    this.userID = userID;
  }

  public Long getDoctorID() {
    return doctorID;
  }

  public void setDoctorID(Long doctorID) {
    this.doctorID = doctorID;
  }

  public String getDoctorCode() {
    return doctorCode;
  }

  public void setDoctorCode(String doctorCode) {
    this.doctorCode = doctorCode;
  }

  public Integer getCategoryID() {
    return categoryID;
  }

  public void setCategoryID(Integer categoryID) {
    this.categoryID = categoryID;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }
}
