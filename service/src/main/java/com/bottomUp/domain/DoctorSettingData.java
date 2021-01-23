package com.bottomUp.domain;


import com.bottomUp.domain.common.BaseData;

public class DoctorSettingData extends BaseData {

  private Long doctorSettingID;
  private Long doctorID;
  private Integer hospitalID;
  private Integer state;
  private Integer patientType;
  private Integer patientState;
  private Integer prescriptionStyle;
  private Integer photoSupport;
  private String pdfPage;

  public Long getDoctorSettingID() {
    return doctorSettingID;
  }

  public void setDoctorSettingID(Long doctorSettingID) {
    this.doctorSettingID = doctorSettingID;
  }

  public Long getDoctorID() {
    return doctorID;
  }

  public void setDoctorID(Long doctorID) {
    this.doctorID = doctorID;
  }

  public Integer getHospitalID() {
    return hospitalID;
  }

  public void setHospitalID(Integer hospitalID) {
    this.hospitalID = hospitalID;
  }

  public Integer getState() {
    return state;
  }

  public void setState(Integer state) {
    this.state = state;
  }

  public Integer getPatientType() {
    return patientType;
  }

  public void setPatientType(Integer patientType) {
    this.patientType = patientType;
  }

  public Integer getPatientState() {
    return patientState;
  }

  public void setPatientState(Integer patientState) {
    this.patientState = patientState;
  }

  public Integer getPrescriptionStyle() {
    return prescriptionStyle;
  }

  public void setPrescriptionStyle(Integer prescriptionStyle) {
    this.prescriptionStyle = prescriptionStyle;
  }

  public Integer getPhotoSupport() {
    return photoSupport;
  }

  public void setPhotoSupport(Integer photoSupport) {
    this.photoSupport = photoSupport;
  }

  public String getPdfPage() {
    return pdfPage;
  }

  public void setPdfPage(String pdfPage) {
    this.pdfPage = pdfPage;
  }
}
