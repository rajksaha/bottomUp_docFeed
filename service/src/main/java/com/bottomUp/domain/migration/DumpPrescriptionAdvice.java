package com.bottomUp.domain.migration;

/**
 * Created by user on 14-May-21.
 */
public class DumpPrescriptionAdvice {

    private Integer id;
    private Integer appointMentID;
    private Integer adviceID;

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

    public Integer getAdviceID() {
        return adviceID;
    }

    public void setAdviceID(Integer adviceID) {
        this.adviceID = adviceID;
    }
}
