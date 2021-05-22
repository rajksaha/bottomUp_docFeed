package com.bottomUp.domain.migration;

/**
 * Created by user on 14-May-21.
 */
public class DumpPrescriptionReference {

    private Integer id;
    private Integer appointMentID;
    private Integer refferedDoctorID;

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

    public Integer getRefferedDoctorID() {
        return refferedDoctorID;
    }

    public void setRefferedDoctorID(Integer refferedDoctorID) {
        this.refferedDoctorID = refferedDoctorID;
    }
}
