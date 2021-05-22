package com.bottomUp.domain.migration;

/**
 * Created by user on 14-May-21.
 */
public class DumpPrescriptionPastDisease {

    private Integer id;
    private Integer appointMentID;
    private Integer pastDiseaseID;

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

    public Integer getPastDiseaseID() {
        return pastDiseaseID;
    }

    public void setPastDiseaseID(Integer pastDiseaseID) {
        this.pastDiseaseID = pastDiseaseID;
    }
}
