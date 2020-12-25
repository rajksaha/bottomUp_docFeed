package com.bottomUp.common.utility;

import com.bottomUp.domain.DoctorHistorySettingData;
import com.bottomUp.domain.DoctorVitalSettingData;
import com.bottomUp.domain.PrescriptionComplainData;
import com.bottomUp.domain.PrescriptionVitalData;
import com.bottomUp.domain.common.user.UserProfileData;
import com.bottomUp.domain.common.user.UserProfileDataTest;

import java.util.List;

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
    private UserProfileDataTest userProfile;

    private List<PrescriptionComplainData> complainList;
    private List<DoctorVitalSettingData> vitalList;
    private List<DoctorHistorySettingData> historyList;

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

    public List<PrescriptionComplainData> getComplainList() {
        return complainList;
    }

    public void setComplainList(List<PrescriptionComplainData> complainList) {
        this.complainList = complainList;
    }

    public List<DoctorVitalSettingData> getVitalList() {
        return vitalList;
    }

    public void setVitalList(List<DoctorVitalSettingData> vitalList) {
        this.vitalList = vitalList;
    }

    public List<DoctorHistorySettingData> getHistoryList() {
        return historyList;
    }

    public void setHistoryList(List<DoctorHistorySettingData> historyList) {
        this.historyList = historyList;
    }

    public UserProfileDataTest getUserProfile() {
        return userProfile;
    }

    public void setUserProfile(UserProfileDataTest userProfile) {
        this.userProfile = userProfile;
    }
}
