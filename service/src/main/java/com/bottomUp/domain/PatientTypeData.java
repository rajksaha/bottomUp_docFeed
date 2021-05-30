package com.bottomUp.domain;


import com.bottomUp.domain.common.BaseData;

public class PatientTypeData extends BaseData {

  private String patientTypeID;
  private String doctorType;
  private String typeName;

  public String getPatientTypeID() {
    return patientTypeID;
  }

  public void setPatientTypeID(String patientTypeID) {
    this.patientTypeID = patientTypeID;
  }

  public String getDoctorType() {
    return doctorType;
  }

  public void setDoctorType(String doctorType) {
    this.doctorType = doctorType;
  }

  public String getTypeName() {
    return typeName;
  }

  public void setTypeName(String typeName) {
    this.typeName = typeName;
  }
}
