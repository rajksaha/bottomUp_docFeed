package com.bottomUp.domain;


import com.bottomUp.domain.common.BaseData;

public class DoctorDrugDiseaseTemplateData extends BaseData {

  private long templateID;
  private long doctorID;
  private long diseaseID;
  private long drugTypeID;
  private long drugID;
  private long drugTimeID;
  private String drugDoseUnit;
  private long drugWhenID;
  private long drugAdviceID;

  public long getTemplateID() {
    return templateID;
  }

  public void setTemplateID(long templateID) {
    this.templateID = templateID;
  }

  public long getDoctorID() {
    return doctorID;
  }

  public void setDoctorID(long doctorID) {
    this.doctorID = doctorID;
  }

  public long getDiseaseID() {
    return diseaseID;
  }

  public void setDiseaseID(long diseaseID) {
    this.diseaseID = diseaseID;
  }

  public long getDrugTypeID() {
    return drugTypeID;
  }

  public void setDrugTypeID(long drugTypeID) {
    this.drugTypeID = drugTypeID;
  }

  public long getDrugID() {
    return drugID;
  }

  public void setDrugID(long drugID) {
    this.drugID = drugID;
  }

  public long getDrugTimeID() {
    return drugTimeID;
  }

  public void setDrugTimeID(long drugTimeID) {
    this.drugTimeID = drugTimeID;
  }

  public String getDrugDoseUnit() {
    return drugDoseUnit;
  }

  public void setDrugDoseUnit(String drugDoseUnit) {
    this.drugDoseUnit = drugDoseUnit;
  }

  public long getDrugWhenID() {
    return drugWhenID;
  }

  public void setDrugWhenID(long drugWhenID) {
    this.drugWhenID = drugWhenID;
  }

  public long getDrugAdviceID() {
    return drugAdviceID;
  }

  public void setDrugAdviceID(long drugAdviceID) {
    this.drugAdviceID = drugAdviceID;
  }
}
