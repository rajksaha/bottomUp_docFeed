package com.bottomUp.domain;

import com.bottomUp.domain.common.BaseData;

public class ContentRelationData  extends BaseData {

  private String relationID;
  private String relationName;

  public String getRelationID() {
    return relationID;
  }

  public void setRelationID(String relationID) {
    this.relationID = relationID;
  }

  public String getRelationName() {
    return relationName;
  }

  public void setRelationName(String relationName) {
    this.relationName = relationName;
  }
}
