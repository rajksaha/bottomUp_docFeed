package com.bottomUp.domain.common.user;


import com.bottomUp.domain.common.BaseData;

/**
 * Created by raj on 3/19/2016.
 */
public class UserGroupAssignmentData extends BaseData {

    private String userGroupAssignmentID;
    private String userID;
    private String userGroupID;
    private Integer status;

    public String getUserGroupAssignmentID() {
        return userGroupAssignmentID;
    }

    public void setUserGroupAssignmentID(String userGroupAssignmentID) {
        this.userGroupAssignmentID = userGroupAssignmentID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUserGroupID() {
        return userGroupID;
    }

    public void setUserGroupID(String userGroupID) {
        this.userGroupID = userGroupID;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
