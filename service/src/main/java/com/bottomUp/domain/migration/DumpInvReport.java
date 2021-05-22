package com.bottomUp.domain.migration;

/**
 * Created by user on 14-May-21.
 */
public class DumpInvReport {

    private Integer id;
    private Integer invPrescribeID;
    private String result;
    private Integer status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getInvPrescribeID() {
        return invPrescribeID;
    }

    public void setInvPrescribeID(Integer invPrescribeID) {
        this.invPrescribeID = invPrescribeID;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
