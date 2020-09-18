package com.bottomUp.domain;

import com.bottomUp.domain.common.BaseData;

public class ContentDrugData extends BaseData {

  private long drugID;
  private long typeID;
  private long genericID;
  private long companyID;
  private String drugName;
  private String strength;


  public long getDrugID() {
    return drugID;
  }

  public void setDrugID(long drugID) {
    this.drugID = drugID;
  }

  public long getTypeID() {
    return typeID;
  }

  public void setTypeID(long typeID) {
    this.typeID = typeID;
  }

  public long getGenericID() {
    return genericID;
  }

  public void setGenericID(long genericID) {
    this.genericID = genericID;
  }

  public long getCompanyID() {
    return companyID;
  }

  public void setCompanyID(long companyID) {
    this.companyID = companyID;
  }

  public String getDrugName() {
    return drugName;
  }

  public void setDrugName(String drugName) {
    this.drugName = drugName;
  }

  public String getStrength() {
    return strength;
  }

  public void setStrength(String strength) {
    this.strength = strength;
  }
}
