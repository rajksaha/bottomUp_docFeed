package com.bottomUp.domain;


import com.bottomUp.domain.common.BaseData;

public class PrescriptionAdviceData extends BaseData {

  private long presAdviceIS;
  private long appointMentID;
  private long adviceId;

  public long getPresAdviceIS() {
    return presAdviceIS;
  }

  public void setPresAdviceIS(long presAdviceIS) {
    this.presAdviceIS = presAdviceIS;
  }

  public long getAppointMentID() {
    return appointMentID;
  }

  public void setAppointMentID(long appointMentID) {
    this.appointMentID = appointMentID;
  }

  public long getAdviceId() {
    return adviceId;
  }

  public void setAdviceId(long adviceId) {
    this.adviceId = adviceId;
  }
}
