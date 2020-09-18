package com.bottomUp.domain;


import com.bottomUp.domain.common.BaseData;

public class DoctorSettingData extends BaseData {

  private long doctorSettingID;
  private long doctorID;
  private long category;
  private long state;
  private long patientType;
  private long patientState;
  private long prescriptionStyle;
  private long companyID;
  private long photoSupport;
  private long personCodeinitial;
  private String pdfPage;

  public long getDoctorSettingID() {
    return doctorSettingID;
  }

  public void setDoctorSettingID(long doctorSettingID) {
    this.doctorSettingID = doctorSettingID;
  }

  public long getDoctorID() {
    return doctorID;
  }

  public void setDoctorID(long doctorID) {
    this.doctorID = doctorID;
  }

  public long getCategory() {
    return category;
  }

  public void setCategory(long category) {
    this.category = category;
  }

  public long getState() {
    return state;
  }

  public void setState(long state) {
    this.state = state;
  }

  public long getPatientType() {
    return patientType;
  }

  public void setPatientType(long patientType) {
    this.patientType = patientType;
  }

  public long getPatientState() {
    return patientState;
  }

  public void setPatientState(long patientState) {
    this.patientState = patientState;
  }

  public long getPrescriptionStyle() {
    return prescriptionStyle;
  }

  public void setPrescriptionStyle(long prescriptionStyle) {
    this.prescriptionStyle = prescriptionStyle;
  }

  public long getCompanyID() {
    return companyID;
  }

  public void setCompanyID(long companyID) {
    this.companyID = companyID;
  }

  public long getPhotoSupport() {
    return photoSupport;
  }

  public void setPhotoSupport(long photoSupport) {
    this.photoSupport = photoSupport;
  }

  public long getPersonCodeinitial() {
    return personCodeinitial;
  }

  public void setPersonCodeinitial(long personCodeinitial) {
    this.personCodeinitial = personCodeinitial;
  }

  public String getPdfPage() {
    return pdfPage;
  }

  public void setPdfPage(String pdfPage) {
    this.pdfPage = pdfPage;
  }
}
