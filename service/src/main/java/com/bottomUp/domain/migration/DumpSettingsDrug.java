package com.bottomUp.domain.migration;

/**
 * Created by user on 14-May-21.
 */
public class DumpSettingsDrug {

    private Integer id;
    private Integer doctorID;
    private Integer diseaseID;
    private Integer drugTypeID;
    private Integer drugID;
    private Integer drugTimeID;
    private String  drugDoseUnit;
    private Integer drugWhenID;
    private Integer drugAdviceID;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDoctorID() {
        return doctorID;
    }

    public void setDoctorID(Integer doctorID) {
        this.doctorID = doctorID;
    }

    public Integer getDiseaseID() {
        return diseaseID;
    }

    public void setDiseaseID(Integer diseaseID) {
        this.diseaseID = diseaseID;
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
}
