package com.bottomUp.domain;


import com.bottomUp.domain.common.BaseData;

import java.util.List;

public class PrescriptionDrugData extends BaseData {

  private long presDrugID;
  private long appointmentID ;
  private long drugTypeID;
  private long drugID;
  private long drugTimeID;
  private String drugDoseUnit;
  private long drugWhenID;
  private long drugAdviceID;
  private long presNum;

  private List<PrescriptionDrugDoseData> doseList;

  public long getPresDrugID() {
    return presDrugID;
  }

  public void setPresDrugID(long presDrugID) {
    this.presDrugID = presDrugID;
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

  public long getPresNum() {
    return presNum;
  }

  public void setPresNum(long presNum) {
    this.presNum = presNum;
  }

  public List<PrescriptionDrugDoseData> getDoseList() {
    return doseList;
  }

  public void setDoseList(List<PrescriptionDrugDoseData> doseList) {
    this.doseList = doseList;
  }

  public long getAppointmentID() {
    return appointmentID;
  }

  public void setAppointmentID(long appointmentID) {
    this.appointmentID = appointmentID;
  }
}
