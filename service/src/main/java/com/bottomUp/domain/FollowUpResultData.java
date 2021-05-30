package com.bottomUp.domain;


import com.bottomUp.domain.common.BaseData;
import com.bottomUp.domain.common.FollowUpDetail;

import java.util.Date;
import java.util.List;


public class FollowUpResultData extends BaseData {

  private String resultID;
  private String appointmentID;
  private Integer patientTypeID;
  private String jsonData;
  private Integer addedInPres;
  private Date entryDate;
  private String entryDateString;
  private String contentDetailID;

  private List<FollowUpDetail> followUpDetailList;

  public String getResultID() {
    return resultID;
  }

  public void setResultID(String resultID) {
    this.resultID = resultID;
  }

  public String getAppointmentID() {
    return appointmentID;
  }

  public void setAppointmentID(String appointmentID) {
    this.appointmentID = appointmentID;
  }

  public Integer getPatientTypeID() {
    return patientTypeID;
  }

  public void setPatientTypeID(Integer patientTypeID) {
    this.patientTypeID = patientTypeID;
  }

  public String getJsonData() {
    return jsonData;
  }

  public void setJsonData(String jsonData) {
    this.jsonData = jsonData;
  }

  public Integer getAddedInPres() {
    return addedInPres;
  }

  public void setAddedInPres(Integer addedInPres) {
    this.addedInPres = addedInPres;
  }

  public Date getEntryDate() {
    return entryDate;
  }

  public void setEntryDate(Date entryDate) {
    this.entryDate = entryDate;
  }

  public String getEntryDateString() {
    return entryDateString;
  }

  public void setEntryDateString(String entryDateString) {
    this.entryDateString = entryDateString;
  }

  public String getContentDetailID() {
    return contentDetailID;
  }

  public void setContentDetailID(String contentDetailID) {
    this.contentDetailID = contentDetailID;
  }

  public List<FollowUpDetail> getFollowUpDetailList() {
    return followUpDetailList;
  }

  public void setFollowUpDetailList(List<FollowUpDetail> followUpDetailList) {
    this.followUpDetailList = followUpDetailList;
  }
}
