package com.bottomUp.domain.migration;

/**
 * Created by user on 14-May-21.
 */
public class DumpDrugPrescription {

    private Integer id;
    private Integer appointMentID;
    private Integer drugTypeID;
    private Integer drugID;
    private Integer drugTimeID;
    private String  drugDoseUnit;
    private Integer drugWhenID;
    private Integer drugAdviceID;
    private Integer presNum;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAppointMentID() {
        return appointMentID;
    }

    public void setAppointMentID(Integer appointMentID) {
        this.appointMentID = appointMentID;
    }

    public Integer getDrugTypeID() {
        return drugTypeID;
    }

    public void setDrugTypeID(Integer drugTypeID) {
        this.drugTypeID = drugTypeID;
    }

    public Integer getDrugID() {
        return drugID;
    }

    public void setDrugID(Integer drugID) {
        this.drugID = drugID;
    }

    public Integer getDrugTimeID() {
        return drugTimeID;
    }

    public void setDrugTimeID(Integer drugTimeID) {
        this.drugTimeID = drugTimeID;
    }

    public String getDrugDoseUnit() {
        return drugDoseUnit;
    }

    public void setDrugDoseUnit(String drugDoseUnit) {
        this.drugDoseUnit = drugDoseUnit;
    }

    public Integer getDrugWhenID() {
        return drugWhenID;
    }

    public void setDrugWhenID(Integer drugWhenID) {
        this.drugWhenID = drugWhenID;
    }

    public Integer getDrugAdviceID() {
        return drugAdviceID;
    }

    public void setDrugAdviceID(Integer drugAdviceID) {
        this.drugAdviceID = drugAdviceID;
    }

    public Integer getPresNum() {
        return presNum;
    }

    public void setPresNum(Integer presNum) {
        this.presNum = presNum;
    }
}
