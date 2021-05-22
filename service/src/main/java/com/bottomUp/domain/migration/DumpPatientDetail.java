package com.bottomUp.domain.migration;

import org.joda.time.DateTime;

import java.util.Date;

/**
 * Created by user on 14-May-21.
 */
public class DumpPatientDetail {

    private Integer id;
    private Integer patientID;
    private Integer type;
    private Integer tri;
    private Integer triStatus;
    private DateTime edb;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPatientID() {
        return patientID;
    }

    public void setPatientID(Integer patientID) {
        this.patientID = patientID;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getTri() {
        return tri;
    }

    public void setTri(Integer tri) {
        this.tri = tri;
    }

    public Integer getTriStatus() {
        return triStatus;
    }

    public void setTriStatus(Integer triStatus) {
        this.triStatus = triStatus;
    }

    public DateTime getEdb() {
        return edb;
    }

    public void setEdb(DateTime edb) {
        this.edb = edb;
    }
}
