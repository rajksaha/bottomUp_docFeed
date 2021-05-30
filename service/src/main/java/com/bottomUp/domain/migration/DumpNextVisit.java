package com.bottomUp.domain.migration;

import java.util.Date;

/**
 * Created by user on 14-May-21.
 */
public class DumpNextVisit {

    private Integer appointmentID;
    private Integer nextVisitType;
    private Date date;
    private Integer numOfDay;
    private Integer dayType;

    public Integer getAppointmentID() {
        return appointmentID;
    }

    public void setAppointmentID(Integer appointmentID) {
        this.appointmentID = appointmentID;
    }

    public Integer getNextVisitType() {
        return nextVisitType;
    }

    public void setNextVisitType(Integer nextVisitType) {
        this.nextVisitType = nextVisitType;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getNumOfDay() {
        return numOfDay;
    }

    public void setNumOfDay(Integer numOfDay) {
        this.numOfDay = numOfDay;
    }

    public Integer getDayType() {
        return dayType;
    }

    public void setDayType(Integer dayType) {
        this.dayType = dayType;
    }
}
