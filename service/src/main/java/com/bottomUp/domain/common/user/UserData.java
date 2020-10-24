package com.bottomUp.domain.common.user;


import com.bottomUp.domain.common.BaseData;

import java.sql.Timestamp;

/**
 * Created by raj on 3/19/2016.
 */
public class UserData extends BaseData {

    private Long userID;
    private String userName;
    private String password;
    private Integer status;
    private Boolean isBlocked;
    private Long companyID;
    private String secretKey;
    private Timestamp secretKeyCreatedOn;

    private UserProfileData userProfileData;
    private String appVersion;
    private Boolean isCompanyAdmin;

    public Boolean getCompanyAdmin() {
        return isCompanyAdmin;
    }

    public void setCompanyAdmin(Boolean companyAdmin) {
        isCompanyAdmin = companyAdmin;
    }

    public String getAppVersion() {
        return appVersion;
    }

    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion;
    }

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Boolean getIsBlocked() {
        return isBlocked;
    }

    public void setIsBlocked(Boolean isBlocked) {
        this.isBlocked = isBlocked;
    }

    public Long getCompanyID() {
        return companyID;
    }

    public void setCompanyID(Long companyID) {
        this.companyID = companyID;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public Timestamp getSecretKeyCreatedOn() {
        return secretKeyCreatedOn;
    }

    public void setSecretKeyCreatedOn(Timestamp secretKeyCreatedOn) {
        this.secretKeyCreatedOn = secretKeyCreatedOn;
    }

    public UserProfileData getUserProfileData() {
        return userProfileData;
    }

    public void setUserProfileData(UserProfileData userProfileData) {
        this.userProfileData = userProfileData;
    }

}
