package com.bottomUp.domain.migration;

/**
 * Created by user on 14-May-21.
 */
public class DumpPatientFamilyHistory {

    private Integer id;
    private Integer patientID;
    private Integer diseaseID;
    private Integer relation;
    private String present;
    private String type;
    private String detail;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPatientID() {
        return patientID;
    }

    public void setPatientID(Integer patientID) {
        this.patientID = patientID;
    }

    public Integer getDiseaseID() {
        return diseaseID;
    }

    public void setDiseaseID(Integer diseaseID) {
        this.diseaseID = diseaseID;
    }

    public Integer getRelation() {
        return relation;
    }

    public void setRelation(Integer relation) {
        this.relation = relation;
    }

    public String getPresent() {
        return present;
    }

    public void setPresent(String present) {
        this.present = present;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
