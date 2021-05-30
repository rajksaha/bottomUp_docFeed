package com.bottomUp.domain;


import com.bottomUp.domain.common.BaseData;

public class ContentDrugTypeData extends BaseData {

  private String drugTypeID;
  private String name;
  private String initial;
  private String unit;
  private String unitInitial;
  private String optionalUnitInitial;

  public String getDrugTypeID() {
    return drugTypeID;
  }

  public void setDrugTypeID(String drugTypeID) {
    this.drugTypeID = drugTypeID;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getInitial() {
    return initial;
  }

  public void setInitial(String initial) {
    this.initial = initial;
  }

  public String getUnit() {
    return unit;
  }

  public void setUnit(String unit) {
    this.unit = unit;
  }

  public String getUnitInitial() {
    return unitInitial;
  }

  public void setUnitInitial(String unitInitial) {
    this.unitInitial = unitInitial;
  }

  public String getOptionalUnitInitial() {
    return optionalUnitInitial;
  }

  public void setOptionalUnitInitial(String optionalUnitInitial) {
    this.optionalUnitInitial = optionalUnitInitial;
  }
}
