package com.bottomUp.domain;


import com.bottomUp.domain.common.BaseData;

public class ContentDoctorCategoryData extends BaseData {

  private long categoryID;
  private String categoryName;

  public long getCategoryID() {
    return categoryID;
  }

  public void setCategoryID(long categoryID) {
    this.categoryID = categoryID;
  }

  public String getCategoryName() {
    return categoryName;
  }

  public void setCategoryName(String categoryName) {
    this.categoryName = categoryName;
  }
}
