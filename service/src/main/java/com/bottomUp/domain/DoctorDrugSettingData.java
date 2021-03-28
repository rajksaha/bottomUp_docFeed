package com.bottomUp.domain;


import com.bottomUp.domain.common.BaseData;

import java.util.List;

public class DoctorDrugSettingData extends BaseData {

  private Long drugSettingID;
  private Long doctorID;
  private Long drugID;
  private Integer doseTypeCode;
  private String drugDoseUnit;
  private Integer drugWhenID;
  private Integer drugAdviceID;
  private String doseString;
  private String drugStrength;
  private String drugTypeInitial;
  private String drugName;
  private String drugTypeName;
  private String drugTimeName;
  private String drugWhenName;
  private String drugAdviceName;
  private String doseTypeBngName;
  private String doseTypeEngName;

  private List<DoseData> periodList;

  public Long getDrugSettingID() {
    return drugSettingID;
  }

  public void setDrugSettingID(Long drugSettingID) {
    this.drugSettingID = drugSettingID;
  }

  public Long getDoctorID() {
    return doctorID;
  }

  public void setDoctorID(Long doctorID) {
    this.doctorID = doctorID;
  }

  public Long getDrugID() {
    return drugID;
  }

  public void setDrugID(Long drugID) {
    this.drugID = drugID;
  }

  public Integer getDoseTypeCode() {
    return doseTypeCode;
  }

  public void setDoseTypeCode(Integer doseTypeCode) {
    this.doseTypeCode = doseTypeCode;
  }

  public String getDrugDoseUnit() {
    return drugDoseUnit;
  }

  public void setDrugDoseUnit(String drugDoseUnit) {
    this.drugDoseUnit = drugDoseUnit;
  }

  public Integer getDrugWhenID() {
    return drugWhenID;
  }

  public void setDrugWhenID(Integer drugWhenID) {
    this.drugWhenID = drugWhenID;
  }

  public Integer getDrugAdviceID() {
    return drugAdviceID;
  }

  public void setDrugAdviceID(Integer drugAdviceID) {
    this.drugAdviceID = drugAdviceID;
  }

  public List<DoseData> getPeriodList() {
    return periodList;
  }

  public void setPeriodList(List<DoseData> periodList) {
    this.periodList = periodList;
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

  public String getDoseString() {
    return doseString;
  }

  public void setDoseString(String doseString) {
    this.doseString = doseString;
  }
}
