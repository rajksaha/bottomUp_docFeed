package com.bottomUp.domain.migration;

/**
 * Created by user on 14-May-21.
 */
public class DumpPatientHistory {

    private Integer id;
    private Integer patientID;
    private Integer historyID;
    private String historyResult;

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

    public Integer getHistoryID() {
        return historyID;
    }

    public void setHistoryID(Integer historyID) {
        this.historyID = historyID;
    }

    public String getHistoryResult() {
        return historyResult;
    }

    public void setHistoryResult(String historyResult) {
        this.historyResult = historyResult;
    }
}
