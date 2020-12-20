package com.bottomUp.model;

/**
 * Created by raj on 11/22/2020.
 */
public class DrugHistory {

    private Long drugHistoryID;
    private String drugName;
    private Long appointmentID;
    private Integer currentStatus;

    public Long getDrugHistoryID() {
        return drugHistoryID;
    }

    public void setDrugHistoryID(Long drugHistoryID) {
        this.drugHistoryID = drugHistoryID;
    }

    public String getDrugName() {
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }

    public Long getAppointmentID() {
        return appointmentID;
    }

    public void setAppointmentID(Long appointmentID) {
        this.appointmentID = appointmentID;
    }

    public Integer getCurrentStatus() {
        return currentStatus;
    }

    public void setCurrentStatus(Integer currentStatus) {
        this.currentStatus = currentStatus;
    }
}
