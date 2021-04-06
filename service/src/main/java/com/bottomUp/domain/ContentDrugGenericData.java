package com.bottomUp.domain;

import com.bottomUp.domain.common.BaseData;

import java.util.List;

/**
 * Created by raj on 3/27/2021.
 */
public class ContentDrugGenericData extends BaseData {

    private Long genericID;
    private String genericDrugName;
    private Integer typeID;
    private String drugTypeName;
    private String strength;

    private String displayDrugName;

    public String getDisplayDrugName() {
        if(this.genericDrugName != null && this.strength != null){
            return this.genericDrugName + " - " + this.strength;
        }
        return this.genericDrugName;
    }

    private List<ContentDrugData> compDrugList;

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

    public String getDrugTypeName() {
        return drugTypeName;
    }

    public void setDrugTypeName(String drugTypeName) {
        this.drugTypeName = drugTypeName;
    }

    public List<ContentDrugData> getCompDrugList() {
        return compDrugList;
    }

    public void setCompDrugList(List<ContentDrugData> compDrugList) {
        this.compDrugList = compDrugList;
    }

    public String getStrength() {
        return strength;
    }

    public void setStrength(String strength) {
        this.strength = strength;
    }
}
