package com.bottomUp.domain;


import com.bottomUp.domain.common.BaseData;

public class PrescriptionInvData extends BaseData {

  private Long presInvID;
  private Long appointmentID;
  private Long invID;
  private String invName;
  private String note;
  private Long checked;

  public Long getPresInvID() {
    return presInvID;
  }

  public void setPresInvID(Long presInvID) {
    this.presInvID = presInvID;
  }

  public Long getAppointmentID() {
    return appointmentID;
  }

  public void setAppointmentID(Long appointmentID) {
    this.appointmentID = appointmentID;
  }

  public Long getInvID() {
    return invID;
  }

  public void setInvID(Long invID) {
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

  public Long getChecked() {
    return checked;
  }

  public void setChecked(Long checked) {
    this.checked = checked;
  }
}
