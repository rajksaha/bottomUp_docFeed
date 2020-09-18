package com.bottomUp.domain;


import com.bottomUp.domain.common.BaseData;

import java.sql.Date;

public class FollowUpResultData extends BaseData {

  private long resultID;
  private long appID;
  private long followupID;
  private String data;
  private java.sql.Date entryDate;

  public long getResultID() {
    return resultID;
  }

  public void setResultID(long resultID) {
    this.resultID = resultID;
  }

  public long getAppID() {
    return appID;
  }

  public void setAppID(long appID) {
    this.appID = appID;
  }

  public long getFollowupID() {
    return followupID;
  }

  public void setFollowupID(long followupID) {
    this.followupID = followupID;
  }

  public String getData() {
    return data;
  }

  public void setData(String data) {
    this.data = data;
  }

  public Date getEntryDate() {
    return entryDate;
  }

  public void setEntryDate(Date entryDate) {
    this.entryDate = entryDate;
  }
}
