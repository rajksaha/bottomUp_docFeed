package com.bottomUp.domain.migration;

import java.util.Date;

/**
 * Created by user on 14-May-21.
 */
public class DumpFollowUpResult {

    private Integer resultID;
    private Integer appID;
    private Integer followUpID;
    private String data;
    private Date entryDate;

    public Integer getResultID() {
        return resultID;
    }

    public void setResultID(Integer resultID) {
        this.resultID = resultID;
    }

    public Integer getAppID() {
        return appID;
    }

    public void setAppID(Integer appID) {
        this.appID = appID;
    }

    public Integer getFollowUpID() {
        return followUpID;
    }

    public void setFollowUpID(Integer followUpID) {
        this.followUpID = followUpID;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Date getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }
}
