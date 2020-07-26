package com.bottomUp.domain.common.user;


import com.bottomUp.domain.common.BaseData;

/**
 * Created by raj on 3/19/2016.
 */
public class UserGroupAssignmentData extends BaseData {

    private Integer userGroupAssignmentID;
    private Long userID;
    private Integer userGroupID;
    private Integer status;

    public Integer getUserGroupAssignmentID() {
        return userGroupAssignmentID;
    }

    public void setUserGroupAssignmentID(Integer userGroupAssignmentID) {
        this.userGroupAssignmentID = userGroupAssignmentID;
    }



    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public Integer getUserGroupID() {
        return userGroupID;
    }

    public void setUserGroupID(Integer userGroupID) {
        this.userGroupID = userGroupID;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
