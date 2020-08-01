package com.bottomUp.domain.common.user;

/**
 * Created by raj on 3/19/2016.
 */
public class GroupPermissionData extends PermissionData {

    private Long groupPermissionID;
    private Long userGroupID;
    private Long permissionID;
    private Integer statusValue;

    public Long getGroupPermissionID() {
        return groupPermissionID;
    }

    public void setGroupPermissionID(Long groupPermissionID) {
        this.groupPermissionID = groupPermissionID;
    }

    public Long getUserGroupID() {
        return userGroupID;
    }

    public void setUserGroupID(Long userGroupID) {
        this.userGroupID = userGroupID;
    }

    public Integer getStatusValue() {
        return statusValue;
    }

    public void setStatusValue(Integer statusValue) {
        this.statusValue = statusValue;
    }
}
