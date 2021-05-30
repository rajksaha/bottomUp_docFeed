package com.bottomUp.domain;


import com.bottomUp.domain.common.BaseData;

public class DoctorDrugDiseaseTemplateData extends BaseData {

  private String templateID;
  private String doctorID;
  private String diseaseID;
  private String drugTypeID;
  private String drugID;
  private String drugTimeID;
  private String drugDoseUnit;
  private String drugWhenID;
  private String drugAdviceID;

  public String getTemplateID() {
    return templateID;
  }

  public void setTemplateID(String templateID) {
    this.templateID = templateID;
  }

  public String getDoctorID() {
    return doctorID;
  }

  public void setDoctorID(String doctorID) {
    this.doctorID = doctorID;
  }

  public String getDiseaseID() {
    return diseaseID;
  }

  public void setDiseaseID(String diseaseID) {
    this.diseaseID = diseaseID;
  }

  public String getDrugTypeID() {
    return drugTypeID;
  }

  public void setDrugTypeID(String drugTypeID) {
    this.drugTypeID = drugTypeID;
  }

  public String getDrugID() {
    return drugID;
  }

  public void setDrugID(String drugID) {
    this.drugID = drugID;
  }

  public String getDrugTimeID() {
    return drugTimeID;
  }

  public void setDrugTimeID(String drugTimeID) {
    this.drugTimeID = drugTimeID;
  }

  public String getDrugDoseUnit() {
    return drugDoseUnit;
  }

  public void setDrugDoseUnit(String drugDoseUnit) {
    this.drugDoseUnit = drugDoseUnit;
  }

  public String getDrugWhenID() {
    return drugWhenID;
  }

  public void setDrugWhenID(String drugWhenID) {
    this.drugWhenID = drugWhenID;
  }

  public String getDrugAdviceID() {
    return drugAdviceID;
  }

  public void setDrugAdviceID(String drugAdviceID) {
    this.drugAdviceID = drugAdviceID;
  }
}
