package com.bottomUp.domain;


import com.bottomUp.domain.common.BaseData;

public class PrescriptionInvData extends BaseData {

  private String presInvID;
  private String appointmentID;
  private String invID;
  private String invName;
  private String note;
  private Integer checked;

  public String getPresInvID() {
    return presInvID;
  }

  public void setPresInvID(String presInvID) {
    this.presInvID = presInvID;
  }

  public String getAppointmentID() {
    return appointmentID;
  }

  public void setAppointmentID(String appointmentID) {
    this.appointmentID = appointmentID;
  }

  public String getInvID() {
    return invID;
  }

  public void setInvID(String invID) {
    this.invID = invID;
  }

  public String getInvName() {
    return invName;
  }

  public void setInvName(String invName) {
    this.invName = invName;
  }

  public String getNote() {
    return note;
  }

  public void setNote(String note) {
    this.note = note;
  }

  public Integer getChecked() {
    return checked;
  }

  public void setChecked(Integer checked) {
    this.checked = checked;
  }
}
