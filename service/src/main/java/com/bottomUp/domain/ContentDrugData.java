package com.bottomUp.domain;

import com.bottomUp.domain.common.BaseData;

public class ContentDrugData extends BaseData {

  private Long drugID;
  private Integer typeID;
  private Long genericID;
  private Long companyID;
  private String drugName;
  private String strength;

  private String drugTypeName;
  private String genericDrugName;
  private String companyName;


  public Long getDrugID() {
    return drugID;
  }

  public void setDrugID(Long drugID) {
    this.drugID = drugID;
  }

  public Integer getTypeID() {
    return typeID;
  }

  public void setTypeID(Integer typeID) {
    this.typeID = typeID;
  }

  public Long getGenericID() {
    return genericID;
  }

  public void setGenericID(Long genericID) {
    this.genericID = genericID;
  }

  public Long getCompanyID() {
    return companyID;
  }

  public void setCompanyID(Long companyID) {
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
