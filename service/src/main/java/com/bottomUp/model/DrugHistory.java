package com.bottomUp.model;

/**
 * Created by raj on 11/22/2020.
 */
public class DrugHistory {

    private String drugHistoryID;
    private String drugName;
    private String appointmentID;
    private Integer currentStatus;

    public String getDrugHistoryID() {
        return drugHistoryID;
    }

    public void setDrugHistoryID(String drugHistoryID) {
        this.drugHistoryID = drugHistoryID;
    }

    public String getDrugName() {
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }

    public String getAppointmentID() {
        return appointmentID;
    }

    public void setAppointmentID(String appointmentID) {
        this.appointmentID = appointmentID;
    }

    public Integer getCurrentStatus() {
        return currentStatus;
    }

    public void setCurrentStatus(Integer currentStatus) {
        this.currentStatus = currentStatus;
    }
}
