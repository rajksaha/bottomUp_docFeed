package com.bottomUp.domain.migration;

/**
 * Created by user on 14-May-21.
 */
public class DumpVitalPrescription {

    private Integer id;
    private Integer appointMentID;
    private Integer vitalID;
    private String vitalResult;

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

    public Integer getVitalID() {
        return vitalID;
    }

    public void setVitalID(Integer vitalID) {
        this.vitalID = vitalID;
    }

    public String getVitalResult() {
        return vitalResult;
    }

    public void setVitalResult(String vitalResult) {
        this.vitalResult = vitalResult;
    }
}
