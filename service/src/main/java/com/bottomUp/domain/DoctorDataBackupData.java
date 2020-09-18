package com.bottomUp.domain;


import com.bottomUp.domain.common.BaseData;

import java.sql.Date;

public class DoctorDataBackupData extends BaseData {

  private long doctorID;
  private java.sql.Date lastBackupDate;

  public long getDoctorID() {
    return doctorID;
  }

  public void setDoctorID(long doctorID) {
    this.doctorID = doctorID;
  }

  public Date getLastBackupDate() {
    return lastBackupDate;
  }

  public void setLastBackupDate(Date lastBackupDate) {
    this.lastBackupDate = lastBackupDate;
  }
}
