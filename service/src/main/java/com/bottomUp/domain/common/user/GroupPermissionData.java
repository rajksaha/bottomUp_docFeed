package com.bottomUp.domain.common.user;

/**
 * Created by raj on 3/19/2016.
 */
public class GroupPermissionData extends PermissionData {

    private String groupPermissionID;
    private String userGroupID;
    private Integer statusValue;

    public String getGroupPermissionID() {
        return groupPermissionID;
    }

    public void setGroupPermissionID(String groupPermissionID) {
        this.groupPermissionID = groupPermissionID;
    }

    public String getUserGroupID() {
        return userGroupID;
    }

    public void setUserGroupID(String userGroupID) {
        this.userGroupID = userGroupID;
    }

    public Integer getStatusValue() {
        return statusValue;
    }

    public void setStatusValue(Integer statusValue) {
        this.statusValue = statusValue;
    }
}
