package com.bottomUp.domain;


import com.bottomUp.domain.common.BaseData;

public class PrescriptionInvData extends BaseData {

  private long presInvID;
  private long appointmentID;
  private long invID;
  private String invName;
  private String note;
  private long checked;

  public long getPresInvID() {
    return presInvID;
  }

  public void setPresInvID(long presInvID) {
    this.presInvID = presInvID;
  }

  public long getInvID() {
    return invID;
  }

  public void setInvID(long invID) {
    this.invID = invID;
  }

  public String getNote() {
    return note;
  }

  public void setNote(String note) {
    this.note = note;
  }

  public long getChecked() {
    return checked;
  }

  public void setChecked(long checked) {
    this.checked = checked;
  }

  public long getAppointmentID() {
    return appointmentID;
  }

  public void setAppointmentID(long appointmentID) {
    this.appointmentID = appointmentID;
  }

  public String getInvName() {
    return invName;
  }

  public void setInvName(String invName) {
    this.invName = invName;
  }
}
