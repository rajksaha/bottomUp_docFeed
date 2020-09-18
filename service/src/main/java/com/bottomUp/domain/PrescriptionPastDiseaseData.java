package com.bottomUp.domain;


import com.bottomUp.domain.common.BaseData;

public class PrescriptionPastDiseaseData  extends BaseData {

  private long presPastDiseaseId;
  private long appointMentId;
  private long pastDiseaseId;

  public long getPresPastDiseaseId() {
    return presPastDiseaseId;
  }

  public void setPresPastDiseaseId(long presPastDiseaseId) {
    this.presPastDiseaseId = presPastDiseaseId;
  }

  public long getAppointMentId() {
    return appointMentId;
  }

  public void setAppointMentId(long appointMentId) {
    this.appointMentId = appointMentId;
  }

  public long getPastDiseaseId() {
    return pastDiseaseId;
  }

  public void setPastDiseaseId(long pastDiseaseId) {
    this.pastDiseaseId = pastDiseaseId;
  }
}
