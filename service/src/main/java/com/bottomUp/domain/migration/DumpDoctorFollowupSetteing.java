package com.bottomUp.domain.migration;

/**
 * Created by user on 14-May-21.
 */
public class DumpDoctorFollowupSetteing {

    private Integer followUpSerttingID;
    private Integer doctorID;
    private Integer invID;
    private Integer patientTypeID;

    public Integer getFollowUpSerttingID() {
        return followUpSerttingID;
    }

    public void setFollowUpSerttingID(Integer followUpSerttingID) {
        this.followUpSerttingID = followUpSerttingID;
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

    public Integer getPatientTypeID() {
        return patientTypeID;
    }

    public void setPatientTypeID(Integer patientTypeID) {
        this.patientTypeID = patientTypeID;
    }
}
