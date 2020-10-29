package com.bottomUp.model;

import java.sql.Date;
import java.sql.Time;

/**
 * Created by raj on 10/24/2020.
 */
public class AppointmentViewData {

    private long appointmentID;
    private long doctorID;
    private long patientID;
    private Date date;
    private Time time;
    private Integer status;
    private Integer appointmentType;

    private PatientViewData patient;
    private DoctorViewData doctor;

    public long getAppointmentID() {
        return appointmentID;
    }

    public void setAppointmentID(long appointmentID) {
        this.appointmentID = appointmentID;
    }

    public long getDoctorID() {
        return doctorID;
    }

    public void setDoctorID(long doctorID) {
        this.doctorID = doctorID;
    }

    public long getPatientID() {
        return patientID;
    }

    public void setPatientID(long patientID) {
        this.patientID = patientID;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
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
}
