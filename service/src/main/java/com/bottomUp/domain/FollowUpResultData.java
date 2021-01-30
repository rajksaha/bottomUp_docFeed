package com.bottomUp.domain;


import com.bottomUp.domain.common.BaseData;
import com.bottomUp.domain.common.FollowUpDetail;

import java.util.Date;
import java.util.List;


public class FollowUpResultData extends BaseData {

  private Long resultID;
  private Long appointmentID;
  private Integer patientTypeID;
  private String jsonData;
  private Integer addedInPres;
  private Date entryDate;
  private String entryDateString;
  private Long contentDetailID;

  private List<FollowUpDetail> followUpDetailList;

  public Long getResultID() {
    return resultID;
  }

  public void setResultID(Long resultID) {
    this.resultID = resultID;
  }

  public Long getAppointmentID() {
    return appointmentID;
  }

  public void setAppointmentID(Long appointmentID) {
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

  public List<FollowUpDetail> getFollowUpDetailList() {
    return followUpDetailList;
  }

  public void setFollowUpDetailList(List<FollowUpDetail> followUpDetailList) {
    this.followUpDetailList = followUpDetailList;
  }

  public String getEntryDateString() {
    return entryDateString;
  }

  public void setEntryDateString(String entryDateString) {
    this.entryDateString = entryDateString;
  }

  public Long getContentDetailID() {
    return contentDetailID;
  }

  public void setContentDetailID(Long contentDetailID) {
    this.contentDetailID = contentDetailID;
  }
}
