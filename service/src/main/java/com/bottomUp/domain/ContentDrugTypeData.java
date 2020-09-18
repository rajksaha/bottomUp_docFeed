package com.bottomUp.domain;


import com.bottomUp.domain.common.BaseData;

public class ContentDrugTypeData extends BaseData {

  private long drugTypeID;
  private String name;
  private String initial;
  private String unit;
  private String unitinitial;
  private String optionalUnitInitial;


  public long getDrugTypeID() {
    return drugTypeID;
  }

  public void setDrugTypeID(long drugTypeID) {
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

  public String getUnitinitial() {
    return unitinitial;
  }

  public void setUnitinitial(String unitinitial) {
    this.unitinitial = unitinitial;
  }

  public String getOptionalUnitInitial() {
    return optionalUnitInitial;
  }

  public void setOptionalUnitInitial(String optionalUnitInitial) {
    this.optionalUnitInitial = optionalUnitInitial;
  }
}
