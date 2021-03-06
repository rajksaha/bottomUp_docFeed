package com.bottomUp.common.utility;

import com.bottomUp.domain.*;
import com.bottomUp.domain.common.FollowUpDetail;
import com.bottomUp.domain.common.user.UserProfileData;
import com.bottomUp.domain.common.user.UserProfileDataTest;

import java.util.List;

/**
 * Created by raj on 4/7/2016.
 */
public class SearchData {

    private String entityID;
    private String entityType;
    private String JsonString;
    private String userID;
    private String term;
    private Integer intLang;
    private Integer intType;

    private String appointmentID;
    private Integer intStatus;
    private UserProfileDataTest userProfile;

    private List<PrescriptionComplainData> complainList;
    private List<DoctorVitalSettingData> vitalList;
    private List<DoctorHistorySettingData> historyList;
    private List<PresNoteData> presNoteList;
    private List<DoctorFollowUpSettingData> followUpSettingList;
    private List<FollowUpDetail> followUpDetailList;

    public String getEntityID() {
        return entityID;
    }

    public void setEntityID(String entityID) {
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

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
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

    public String getAppointmentID() {
        return appointmentID;
    }

    public void setAppointmentID(String appointmentID) {
        this.appointmentID = appointmentID;
    }

    public Integer getIntStatus() {
        return intStatus;
    }

    public void setIntStatus(Integer intStatus) {
        this.intStatus = intStatus;
    }

    public UserProfileDataTest getUserProfile() {
        return userProfile;
    }

    public void setUserProfile(UserProfileDataTest userProfile) {
        this.userProfile = userProfile;
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

    public List<PresNoteData> getPresNoteList() {
        return presNoteList;
    }

    public void setPresNoteList(List<PresNoteData> presNoteList) {
        this.presNoteList = presNoteList;
    }

    public List<DoctorFollowUpSettingData> getFollowUpSettingList() {
        return followUpSettingList;
    }

    public void setFollowUpSettingList(List<DoctorFollowUpSettingData> followUpSettingList) {
        this.followUpSettingList = followUpSettingList;
    }

    public List<FollowUpDetail> getFollowUpDetailList() {
        return followUpDetailList;
    }

    public void setFollowUpDetailList(List<FollowUpDetail> followUpDetailList) {
        this.followUpDetailList = followUpDetailList;
    }
}
