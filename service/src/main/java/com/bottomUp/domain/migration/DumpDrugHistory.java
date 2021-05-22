package com.bottomUp.domain.migration;

/**
 * Created by user on 14-May-21.
 */
public class DumpDrugHistory {

    private Integer drugHistoryID;
    private Integer patientID;
    private String drugName;
    private Integer currentStatus;

    public Integer getDrugHistoryID() {
        return drugHistoryID;
    }

    public void setDrugHistoryID(Integer drugHistoryID) {
        this.drugHistoryID = drugHistoryID;
    }

    public Integer getPatientID() {
        return patientID;
    }

    public void setPatientID(Integer patientID) {
        this.patientID = patientID;
    }

    public String getDrugName() {
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }

    public Integer getCurrentStatus() {
        return currentStatus;
    }

    public void setCurrentStatus(Integer currentStatus) {
        this.currentStatus = currentStatus;
    }
}
