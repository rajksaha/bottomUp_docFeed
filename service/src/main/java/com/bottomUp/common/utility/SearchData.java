package com.bottomUp.common.utility;

/**
 * Created by raj on 4/7/2016.
 */
public class SearchData {

    private Long entityID;
    private String entityType;
    private String JsonString;
    private Long userID;
    private String term;
    private Integer intLang;
    private Integer intType;

    private Long appointmentID;
    private Integer intStatus;

    public Long getAppointmentID() {
        return appointmentID;
    }

    public Integer getIntStatus() {
        return intStatus;
    }

    public void setIntStatus(Integer intStatus) {
        this.intStatus = intStatus;
    }

    public void setAppointmentID(Long appointmentID) {
        this.appointmentID = appointmentID;
    }

    public Long getEntityID() {
        return entityID;
    }

    public void setEntityID(Long entityID) {
        this.entityID = entityID;
    }

    public String getEntityType() {
        return entityType;
    }

    public void setEntityType(String entityType) {
        this.entityType = entityType;
    }

    public String getJsonString() {
        return JsonString;
    }

    public void setJsonString(String jsonString) {
        JsonString = jsonString;
    }

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public Integer getIntLang() {
        return intLang;
    }

    public void setIntLang(Integer intLang) {
        this.intLang = intLang;
    }

    public Integer getIntType() {
        return intType;
    }

    public void setIntType(Integer intType) {
        this.intType = intType;
    }
}
