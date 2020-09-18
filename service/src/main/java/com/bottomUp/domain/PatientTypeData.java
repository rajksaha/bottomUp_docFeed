package com.bottomUp.domain;


import com.bottomUp.domain.common.BaseData;

public class PatientTypeData extends BaseData {

  private long patientTypeID;
  private long doctorType;
  private String typeName;

  public long getPatientTypeID() {
    return patientTypeID;
  }

  public void setPatientTypeID(long patientTypeID) {
    this.patientTypeID = patientTypeID;
  }

  public long getDoctorType() {
    return doctorType;
  }

  public void setDoctorType(long doctorType) {
    this.doctorType = doctorType;
  }

  public String getTypeName() {
    return typeName;
  }

  public void setTypeName(String typeName) {
    this.typeName = typeName;
  }
}
