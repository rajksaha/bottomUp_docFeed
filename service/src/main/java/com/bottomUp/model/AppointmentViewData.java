package com.bottomUp.model;

import utility.DateUtil;

import java.sql.Date;
import java.sql.Time;

/**
 * Created by raj on 10/24/2020.
 */
public class AppointmentViewData {

    private String appointmentID;
    private String doctorID;
    private String patientID;
    private Date appDate;
    private Time appTime;
    private Integer status;
    private Integer appointmentType;
    private String appointmentTypeName;

    private Integer numOfMalePatient;
    private Integer numOfFemalePatient;
    private Integer numOfNewPatient;
    private Integer numOfOldPatient;
    private Integer numOfReportPatient;
    private Integer numOfFreePatient;

    private PatientViewData patient;
    private DoctorViewData doctor;

    private Date lastVisitDate;

    private String lastVisitDiff;

    public String getLastVisitDiff() {
        if(appDate != null && lastVisitDate != null){
            String temp = "" + DateUtil.daysBetween(lastVisitDate, appDate) + " days ago";
            return temp;
        }
        return lastVisitDiff;
    }

    public String getAppointmentID() {
        return appointmentID;
    }

    public void setAppointmentID(String appointmentID) {
        this.appointmentID = appointmentID;
    }

    public String getDoctorID() {
        return doctorID;
    }

    public void setDoctorID(String doctorID) {
        this.doctorID = doctorID;
    }

    public String getPatientID() {
        return patientID;
    }

    public void setPatientID(String patientID) {
        this.patientID = patientID;
    }

    public Date getAppDate() {
        return appDate;
    }

    public void setAppDate(Date appDate) {
        this.appDate = appDate;
    }

    public Time getAppTime() {
        return appTime;
    }

    public void setAppTime(Time appTime) {
        this.appTime = appTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getAppointmentType() {
        return appointmentType;
    }

    public void setAppointmentType(Integer appointmentType) {
        this.appointmentType = appointmentType;
    }

    public PatientViewData getPatient() {
        return patient;
    }

    public void setPatient(PatientViewData patient) {
        this.patient = patient;
    }

    public DoctorViewData getDoctor() {
        return doctor;
    }

    public void setDoctor(DoctorViewData doctor) {
        this.doctor = doctor;
    }

    public String getAppointmentTypeName() {
        return appointmentTypeName;
    }

    public void setAppointmentTypeName(String appointmentTypeName) {
        this.appointmentTypeName = appointmentTypeName;
    }

    public Date getLastVisitDate() {
        return lastVisitDate;
    }

    public void setLastVisitDate(Date lastVisitDate) {
        this.lastVisitDate = lastVisitDate;
    }
}
