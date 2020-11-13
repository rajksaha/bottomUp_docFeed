package com.bottomUp.model;

/**
 * Created by raj on 11/9/2020.
 */
public class DietData {

    private Long dietID;
    private String dietName;
    private Long appointmentID;

    public Long getDietID() {
        return dietID;
    }

    public void setDietID(Long dietID) {
        this.dietID = dietID;
    }

    public String getDietName() {
        return dietName;
    }

    public void setDietName(String dietName) {
        this.dietName = dietName;
    }

    public Long getAppointmentID() {
        return appointmentID;
    }

    public void setAppointmentID(Long appointmentID) {
        this.appointmentID = appointmentID;
    }
}
