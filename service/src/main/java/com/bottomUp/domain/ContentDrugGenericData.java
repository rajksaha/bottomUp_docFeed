package com.bottomUp.domain;

import com.bottomUp.domain.common.BaseData;

/**
 * Created by raj on 3/27/2021.
 */
public class ContentDrugGenericData extends BaseData {

    private Long genericID;
    private String genericDrugName;
    private Integer typeID;
    private String drugTypeName;

    public Long getGenericID() {
        return genericID;
    }

    public void setGenericID(Long genericID) {
        this.genericID = genericID;
    }

    public String getGenericDrugName() {
        return genericDrugName;
    }

    public void setGenericDrugName(String genericDrugName) {
        this.genericDrugName = genericDrugName;
    }

    public Integer getTypeID() {
        return typeID;
    }

    public void setTypeID(Integer typeID) {
        this.typeID = typeID;
    }
}
