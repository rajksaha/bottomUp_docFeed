package com.bottomUp.domain.migration;

import javax.xml.soap.Text;

/**
 * Created by user on 14-May-21.
 */
public class DumpComplain {

    private Integer id;
    private Integer appointMentID;
    private Integer symptomID;
    private Double durationNum;
    private Integer durationType;
    private String detail;

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

    public Integer getSymptomID() {
        return symptomID;
    }

    public void setSymptomID(Integer symptomID) {
        this.symptomID = symptomID;
    }

    public Double getDurationNum() {
        return durationNum;
    }

    public void setDurationNum(Double durationNum) {
        this.durationNum = durationNum;
    }

    public Integer getDurationType() {
        return durationType;
    }

    public void setDurationType(Integer durationType) {
        this.durationType = durationType;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
