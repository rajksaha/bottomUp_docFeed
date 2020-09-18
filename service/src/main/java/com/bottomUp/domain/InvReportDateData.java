package com.bottomUp.domain;


import com.bottomUp.domain.common.BaseData;

import java.sql.Date;

public class InvReportDateData extends BaseData {

  private long invReportDateID;
  private long patientID;
  private java.sql.Date reportDate;
  private String reportLocation;
  private String filename;
  private String ext;


  public long getInvReportDateID() {
    return invReportDateID;
  }

  public void setInvReportDateID(long invReportDateID) {
    this.invReportDateID = invReportDateID;
  }

  public long getPatientID() {
    return patientID;
  }

  public void setPatientID(long patientID) {
    this.patientID = patientID;
  }

  public Date getReportDate() {
    return reportDate;
  }

  public void setReportDate(Date reportDate) {
    this.reportDate = reportDate;
  }

  public String getReportLocation() {
    return reportLocation;
  }

  public void setReportLocation(String reportLocation) {
    this.reportLocation = reportLocation;
  }

  public String getFilename() {
    return filename;
  }

  public void setFilename(String filename) {
    this.filename = filename;
  }

  public String getExt() {
    return ext;
  }

  public void setExt(String ext) {
    this.ext = ext;
  }
}
