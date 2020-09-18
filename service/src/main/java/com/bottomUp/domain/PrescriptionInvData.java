package com.bottomUp.domain;


import com.bottomUp.domain.common.BaseData;

public class PrescriptionInvData extends BaseData {

  private long presInvID;
  private long appointMentID;
  private long invID;
  private String note;
  private long checked;

  public long getPresInvID() {
    return presInvID;
  }

  public void setPresInvID(long presInvID) {
    this.presInvID = presInvID;
  }

  public long getAppointMentID() {
    return appointMentID;
  }

  public void setAppointMentID(long appointMentID) {
    this.appointMentID = appointMentID;
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
}
