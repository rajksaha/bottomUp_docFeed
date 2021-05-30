package com.bottomUp.domain.migration;


import java.sql.Time;
import java.util.Date;

/**
 * Created by user on 14-May-21.
 */
public class DumpAppointment {

    private Integer appointmentID;
    private String doctorCode;
    private String PatientCode;
    private Date date;
    private Time time;
    private Integer status;
    private Integer appointmentType;
    private String addedBy;

    public Integer getAppointmentID() {
        return appointmentID;
    }

    public void setAppointmentID(Integer appointmentID) {
        this.appointmentID = appointmentID;
    }

    public String getDoctorCode() {
        return doctorCode;
    }

    public void setDoctorCode(String doctorCode) {
        this.doctorCode = doctorCode;
    }

    public String getPatientCode() {
        return PatientCode;
    }

    public void setPatientCode(String patientCode) {
        PatientCode = patientCode;
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

    public String getAddedBy() {
        return addedBy;
    }

    public void setAddedBy(String addedBy) {
        this.addedBy = addedBy;
    }
}
