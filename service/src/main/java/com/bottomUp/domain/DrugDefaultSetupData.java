package com.bottomUp.domain;

import com.bottomUp.domain.common.BaseData;

import java.util.List;

/**
 * Created by raj on 3/27/2021.
 */
public class DrugDefaultSetupData extends BaseData {

    private String drugSettingID;
    private String drugID;
    private String doctorID;
    private Integer doseTypeCode;
    private String drugDoseUnit;
    private Integer drugTypeID;
    private Integer drugWhenID;
    private Integer drugAdviceID;
    private String doseString;

    private List<DoseData> periodList;

    private String drugTypeInitial;
    private String drugTypeName;
    private String drugAdviceName;
    private String drugWhenName;
    private String doseTypeBngName;
    private String doseTypeEngName;
    private String entryType;
    private String genericID;

    public String getDrugSettingID() {
        return drugSettingID;
    }

    public void setDrugSettingID(String drugSettingID) {
        this.drugSettingID = drugSettingID;
    }

    public String getDrugID() {
        return drugID;
    }

    public void setDrugID(String drugID) {
        this.drugID = drugID;
    }

    public String getDoctorID() {
        return doctorID;
    }

    public void setDoctorID(String doctorID) {
        this.doctorID = doctorID;
    }

    public Integer getDoseTypeCode() {
        return doseTypeCode;
    }

    public void setDoseTypeCode(Integer doseTypeCode) {
        this.doseTypeCode = doseTypeCode;
    }

    public String getDrugDoseUnit() {
        return drugDoseUnit;
    }

    public void setDrugDoseUnit(String drugDoseUnit) {
        this.drugDoseUnit = drugDoseUnit;
    }

    public Integer getDrugTypeID() {
        return drugTypeID;
    }

    public void setDrugTypeID(Integer drugTypeID) {
        this.drugTypeID = drugTypeID;
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

    public String getDoseString() {
        return doseString;
    }

    public void setDoseString(String doseString) {
        this.doseString = doseString;
    }

    public List<DoseData> getPeriodList() {
        return periodList;
    }

    public void setPeriodList(List<DoseData> periodList) {
        this.periodList = periodList;
    }

    public String getDrugTypeInitial() {
        return drugTypeInitial;
    }

    public void setDrugTypeInitial(String drugTypeInitial) {
        this.drugTypeInitial = drugTypeInitial;
    }

    public String getDrugTypeName() {
        return drugTypeName;
    }

    public void setDrugTypeName(String drugTypeName) {
        this.drugTypeName = drugTypeName;
    }

    public String getDrugAdviceName() {
        return drugAdviceName;
    }

    public void setDrugAdviceName(String drugAdviceName) {
        this.drugAdviceName = drugAdviceName;
    }

    public String getDrugWhenName() {
        return drugWhenName;
    }

    public void setDrugWhenName(String drugWhenName) {
        this.drugWhenName = drugWhenName;
    }

    public String getDoseTypeBngName() {
        return doseTypeBngName;
    }

    public void setDoseTypeBngName(String doseTypeBngName) {
        this.doseTypeBngName = doseTypeBngName;
    }

    public String getDoseTypeEngName() {
        return doseTypeEngName;
    }

    public void setDoseTypeEngName(String doseTypeEngName) {
        this.doseTypeEngName = doseTypeEngName;
    }

    public String getEntryType() {
        return entryType;
    }

    public void setEntryType(String entryType) {
        this.entryType = entryType;
    }

    public String getGenericID() {
        return genericID;
    }

    public void setGenericID(String genericID) {
        this.genericID = genericID;
    }
}
