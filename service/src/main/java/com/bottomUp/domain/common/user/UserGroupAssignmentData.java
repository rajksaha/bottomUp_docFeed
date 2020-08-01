package com.bottomUp.domain.common.user;


import com.bottomUp.domain.common.BaseData;

/**
 * Created by raj on 3/19/2016.
 */
public class UserGroupAssignmentData extends BaseData {

    private Long userGroupAssignmentID;
    private Long userID;
    private Long userGroupID;
    private Integer status;

    public Long getUserGroupAssignmentID() {
        return userGroupAssignmentID;
    }

    public void setUserGroupAssignmentID(Long userGroupAssignmentID) {
        this.userGroupAssignmentID = userGroupAssignmentID;
    }

    public Long getUserGroupID() {
        return userGroupID;
    }

    public void setUserGroupID(Long userGroupID) {
        this.userGroupID = userGroupID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public Long getUserID() {
        return userID;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
