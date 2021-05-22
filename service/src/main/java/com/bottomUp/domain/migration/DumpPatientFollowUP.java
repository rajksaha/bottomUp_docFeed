package com.bottomUp.domain.migration;

/**
 * Created by user on 14-May-21.
 */
public class DumpPatientFollowUP {

    private Integer patientFollowUpID;
    private Integer patientID;
    private Integer doctorID;
    private Integer invID;

    public Integer getPatientFollowUpID() {
        return patientFollowUpID;
    }

    public void setPatientFollowUpID(Integer patientFollowUpID) {
        this.patientFollowUpID = patientFollowUpID;
    }

    public Integer getPatientID() {
        return patientID;
    }

    public void setPatientID(Integer patientID) {
        this.patientID = patientID;
    }

    public Integer getDoctorID() {
        return doctorID;
    }

    public void setDoctorID(Integer doctorID) {
        this.doctorID = doctorID;
    }

    public Integer getInvID() {
        return invID;
    }

    public void setInvID(Integer invID) {
        this.invID = invID;
    }
}
