package com.bottomUp.domain;

import com.bottomUp.domain.common.BaseData;

import java.math.BigInteger;
import java.util.Date;

/**
 * Created by raj on 4/10/2021.
 */
public class MedicalCertificateData  extends BaseData{

    private BigInteger medicalCertID;
    private String appointmentID;
    private Date startDate;
    private Date endDate;
    private String addComment;

    public BigInteger getMedicalCertID() {
        return medicalCertID;
    }

    public void setMedicalCertID(BigInteger medicalCertID) {
        this.medicalCertID = medicalCertID;
    }

    public String getAppointmentID() {
        return appointmentID;
    }

    public void setAppointmentID(String appointmentID) {
        this.appointmentID = appointmentID;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getAddComment() {
        return addComment;
    }

    public void setAddComment(String addComment) {
        this.addComment = addComment;
    }
}
