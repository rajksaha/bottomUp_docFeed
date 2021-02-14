package com.bottomUp.domain;


import com.bottomUp.domain.common.BaseData;
import com.bottomUp.model.AttachmentData;

import java.util.Date;
import java.util.List;

public class InvReportDateData extends BaseData {

  private Date reportDate;
  private List<AttachmentData> reportList;

  public Date getReportDate() {
    return reportDate;
  }

  public void setReportDate(Date reportDate) {
    this.reportDate = reportDate;
  }

  public List<AttachmentData> getReportList() {
    return reportList;
  }

  public void setReportList(List<AttachmentData> reportList) {
    this.reportList = reportList;
  }
}
