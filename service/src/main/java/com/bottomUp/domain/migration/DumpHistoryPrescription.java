package com.bottomUp.domain.migration;

/**
 * Created by user on 14-May-21.
 */
public class DumpHistoryPrescription {

    private Integer id;
    private Integer appointMentID;
    private Integer patientHistoryID;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAppointMentID() {
        return appointMentID;
    }

    public void setAppointMentID(Integer appointMentID) {
        this.appointMentID = appointMentID;
    }

    public Integer getPatientHistoryID() {
        return patientHistoryID;
    }

    public void setPatientHistoryID(Integer patientHistoryID) {
        this.patientHistoryID = patientHistoryID;
    }
}
