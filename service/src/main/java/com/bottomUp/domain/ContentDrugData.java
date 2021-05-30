package com.bottomUp.domain;

import com.bottomUp.domain.common.BaseData;

public class ContentDrugData extends BaseData {

  private String drugID;
  private Integer typeID;
  private String genericID;
  private String companyID;
  private String drugName;
  private String strength;

  private String drugTypeName;
  private String genericDrugName;
  private String companyName;

  private String displayDrugName;
  private String disDrugCompName;

  public String getDisplayDrugName() {
    if(this.drugName != null && this.strength != null && this.strength.trim().length() > 0){
      return this.drugName + " - " + this.strength;
    }
    return this.drugName;
  }

  public String getDisDrugCompName() {
    return getDisplayDrugName() + " [" + this.companyName + "]";
  }

  public String getDrugID() {
    return drugID;
  }

  public void setDrugID(String drugID) {
    this.drugID = drugID;
  }

  public Integer getTypeID() {
    return typeID;
  }

  public void setTypeID(Integer typeID) {
    this.typeID = typeID;
  }

  public String getGenericID() {
    return genericID;
  }

  public void setGenericID(String genericID) {
    this.genericID = genericID;
  }

  public String getCompanyID() {
    return companyID;
  }

  public void setCompanyID(String companyID) {
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

  public String getDrugTypeName() {
    return drugTypeName;
  }

  public void setDrugTypeName(String drugTypeName) {
    this.drugTypeName = drugTypeName;
  }

  public String getGenericDrugName() {
    return genericDrugName;
  }

  public void setGenericDrugName(String genericDrugName) {
    this.genericDrugName = genericDrugName;
  }

  public String getCompanyName() {
    return companyName;
  }

  public void setCompanyName(String companyName) {
    this.companyName = companyName;
  }
}
