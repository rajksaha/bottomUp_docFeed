package com.bottomUp.domain;


import com.bottomUp.domain.common.BaseData;

public class PrescriptionVitalData extends BaseData {

  private long presVitalId;
  private long appointMentId;
  private long vitalId;
  private String vitalResult;

  public long getPresVitalId() {
    return presVitalId;
  }

  public void setPresVitalId(long presVitalId) {
    this.presVitalId = presVitalId;
  }

  public long getAppointMentId() {
    return appointMentId;
  }

  public void setAppointMentId(long appointMentId) {
    this.appointMentId = appointMentId;
  }

  public long getVitalId() {
    return vitalId;
  }

  public void setVitalId(long vitalId) {
    this.vitalId = vitalId;
  }

  public String getVitalResult() {
    return vitalResult;
  }

  public void setVitalResult(String vitalResult) {
    this.vitalResult = vitalResult;
  }
}
