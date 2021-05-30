package com.bottomUp.domain;


import com.bottomUp.domain.common.BaseData;

public class InvReportData extends BaseData {

  private String id;
  private String invPrescribeID;
  private String result;
  private Integer status;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getInvPrescribeID() {
    return invPrescribeID;
  }

  public void setInvPrescribeID(String invPrescribeID) {
    this.invPrescribeID = invPrescribeID;
  }

  public String getResult() {
    return result;
  }

  public void setResult(String result) {
    this.result = result;
  }

  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }
}
