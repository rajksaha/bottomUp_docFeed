package com.sample;


public class Appointment_Type {

  private long appointmenttypeid;
  private String name;
  private String shortname;
  private String updatedby;
  private java.sql.Timestamp updatedon;
  private String createdby;
  private java.sql.Timestamp createdon;


  public long getAppointmenttypeid() {
    return appointmenttypeid;
  }

  public void setAppointmenttypeid(long appointmenttypeid) {
    this.appointmenttypeid = appointmenttypeid;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public String getShortname() {
    return shortname;
  }

  public void setShortname(String shortname) {
    this.shortname = shortname;
  }


  public String getUpdatedby() {
    return updatedby;
  }

  public void setUpdatedby(String updatedby) {
    this.updatedby = updatedby;
  }


  public java.sql.Timestamp getUpdatedon() {
    return updatedon;
  }

  public void setUpdatedon(java.sql.Timestamp updatedon) {
    this.updatedon = updatedon;
  }


  public String getCreatedby() {
    return createdby;
  }

  public void setCreatedby(String createdby) {
    this.createdby = createdby;
  }


  public java.sql.Timestamp getCreatedon() {
    return createdon;
  }

  public void setCreatedon(java.sql.Timestamp createdon) {
    this.createdon = createdon;
  }

}
