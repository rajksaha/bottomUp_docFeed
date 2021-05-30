package com.bottomUp.domain;


import com.bottomUp.domain.common.BaseData;

import java.util.List;

public class PrescriptionDrugData extends BaseData {

  private String presDrugID;
  private String appointmentID;
  private String doctorID;
  private String drugTypeID;
  private String drugID;
  private String genericID;
  private String genericDrugName;
  private Integer doseTypeCode;
  private String drugWhenID;
  private String drugAdviceID;
  private String drugDoseUnit;
  private Integer presNum;
  private String drugStrength;
  private String drugTypeInitial;
  private String drugName;
  private String drugTypeName;
  private String drugTimeName;
  private String drugWhenName;
  private String drugAdviceName;
  private String doseTypeBngName;
  private String doseTypeEngName;
  private Integer hasDefaultSetup;
  private String doseString;

  private List<DoseData> periodList;

  public String getPresDrugID() {
    return presDrugID;
  }

  public void setPresDrugID(String presDrugID) {
    this.presDrugID = presDrugID;
  }

  public String getAppointmentID() {
    return appointmentID;
  }

  public void setAppointmentID(String appointmentID) {
    this.appointmentID = appointmentID;
  }

  public String getDoctorID() {
    return doctorID;
  }

  public void setDoctorID(String doctorID) {
    this.doctorID = doctorID;
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

  public String getGenericID() {
    return genericID;
  }

  public void setGenericID(String genericID) {
    this.genericID = genericID;
  }

  public String getGenericDrugName() {
    return genericDrugName;
  }

  public void setGenericDrugName(String genericDrugName) {
    this.genericDrugName = genericDrugName;
  }

  public Integer getDoseTypeCode() {
    return doseTypeCode;
  }

  public void setDoseTypeCode(Integer doseTypeCode) {
    this.doseTypeCode = doseTypeCode;
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

  public String getDrugDoseUnit() {
    return drugDoseUnit;
  }

  public void setDrugDoseUnit(String drugDoseUnit) {
    this.drugDoseUnit = drugDoseUnit;
  }

  public Integer getPresNum() {
    return presNum;
  }

  public void setPresNum(Integer presNum) {
    this.presNum = presNum;
  }

  public String getDrugStrength() {
    return drugStrength;
  }

  public void setDrugStrength(String drugStrength) {
    this.drugStrength = drugStrength;
  }

  public String getDrugTypeInitial() {
    return drugTypeInitial;
  }

  public void setDrugTypeInitial(String drugTypeInitial) {
    this.drugTypeInitial = drugTypeInitial;
  }

  public String getDrugName() {
    return drugName;
  }

  public void setDrugName(String drugName) {
    this.drugName = drugName;
  }

  public String getDrugTypeName() {
    return drugTypeName;
  }

  public void setDrugTypeName(String drugTypeName) {
    this.drugTypeName = drugTypeName;
  }

  public String getDrugTimeName() {
    return drugTimeName;
  }

  public void setDrugTimeName(String drugTimeName) {
    this.drugTimeName = drugTimeName;
  }

  public String getDrugWhenName() {
    return drugWhenName;
  }

  public void setDrugWhenName(String drugWhenName) {
    this.drugWhenName = drugWhenName;
  }

  public String getDrugAdviceName() {
    return drugAdviceName;
  }

  public void setDrugAdviceName(String drugAdviceName) {
    this.drugAdviceName = drugAdviceName;
  }

  public String getDoseTypeBngName() {
    return doseTypeBngName;
  }

  public void setDoseTypeBngName(String doseTypeBngName) {
    this.doseTypeBngName = doseTypeBngName;
  }

  public String getDoseTypeEngName() {
    return doseTypeEngName;
  }

  public void setDoseTypeEngName(String doseTypeEngName) {
    this.doseTypeEngName = doseTypeEngName;
  }

  public Integer getHasDefaultSetup() {
    return hasDefaultSetup;
  }

  public void setHasDefaultSetup(Integer hasDefaultSetup) {
    this.hasDefaultSetup = hasDefaultSetup;
  }

  public String getDoseString() {
    return doseString;
  }

  public void setDoseString(String doseString) {
    this.doseString = doseString;
  }

  public List<DoseData> getPeriodList() {
    return periodList;
  }

  public void setPeriodList(List<DoseData> periodList) {
    this.periodList = periodList;
  }
}
