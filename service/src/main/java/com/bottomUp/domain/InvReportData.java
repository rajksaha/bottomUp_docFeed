package com.bottomUp.domain;


import com.bottomUp.domain.common.BaseData;

public class InvReportData extends BaseData {

  private long id;
  private long invPrescribeID;
  private String result;
  private long status;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public long getInvPrescribeID() {
    return invPrescribeID;
  }

  public void setInvPrescribeID(long invPrescribeID) {
    this.invPrescribeID = invPrescribeID;
  }

  public String getResult() {
    return result;
  }

  public void setResult(String result) {
    this.result = result;
  }

  public long getStatus() {
    return status;
  }

  public void setStatus(long status) {
    this.status = status;
  }
}
