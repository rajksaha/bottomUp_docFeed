package com.bottomUp.domain;


import com.bottomUp.domain.common.BaseData;

import java.util.Date;


public class DoctorDataBackupData extends BaseData {

  private String doctorID;
  private Date lastBackupDate;

  public String getDoctorID() {
    return doctorID;
  }

  public void setDoctorID(String doctorID) {
    this.doctorID = doctorID;
  }

  public Date getLastBackupDate() {
    return lastBackupDate;
  }

  public void setLastBackupDate(Date lastBackupDate) {
    this.lastBackupDate = lastBackupDate;
  }
}
