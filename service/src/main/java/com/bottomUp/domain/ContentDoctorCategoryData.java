package com.bottomUp.domain;


import com.bottomUp.domain.common.BaseData;

public class ContentDoctorCategoryData extends BaseData {

  private long categoryID;
  private String categortName;

  public long getCategoryID() {
    return categoryID;
  }

  public void setCategoryID(long categoryID) {
    this.categoryID = categoryID;
  }

  public String getCategortName() {
    return categortName;
  }

  public void setCategortName(String categortName) {
    this.categortName = categortName;
  }
}
