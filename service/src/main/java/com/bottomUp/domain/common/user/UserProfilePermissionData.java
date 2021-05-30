package com.bottomUp.domain.common.user;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by raj on 3/20/2016.
 */
public class UserProfilePermissionData implements Serializable{


    private String userID;
    private String userName;
    private String companyID;
    private Integer status;
    private List<GroupPermissionData> groupPermissionDataList;
    private Map<String, Boolean> permissions;
    private UserProfileData profileData;

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCompanyID() {
        return companyID;
    }

    public void setCompanyID(String companyID) {
        this.companyID = companyID;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<GroupPermissionData> getGroupPermissionDataList() {
        return groupPermissionDataList;
    }

    public void setGroupPermissionDataList(List<GroupPermissionData> groupPermissionDataList) {
        this.groupPermissionDataList = groupPermissionDataList;
    }

    public Map<String, Boolean> getPermissions() {
        return permissions;
    }

    public void setPermissions(Map<String, Boolean> permissions) {
        this.permissions = permissions;
    }

    public UserProfileData getProfileData() {
        return profileData;
    }

    public void setProfileData(UserProfileData profileData) {
        this.profileData = profileData;
    }
}
