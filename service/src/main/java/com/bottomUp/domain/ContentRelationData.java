package com.bottomUp.domain;

import com.bottomUp.domain.common.BaseData;

public class ContentRelationData  extends BaseData {

  private long relationID;
  private String relationName;

  public long getRelationID() {
    return relationID;
  }

  public void setRelationID(long relationID) {
    this.relationID = relationID;
  }

  public String getRelationName() {
    return relationName;
  }

  public void setRelationName(String relationName) {
    this.relationName = relationName;
  }
}
