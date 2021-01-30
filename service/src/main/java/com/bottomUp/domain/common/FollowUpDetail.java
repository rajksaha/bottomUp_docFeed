package com.bottomUp.domain.common;

/**
 * Created by raj on 1/29/2021.
 */
public class FollowUpDetail {

    private String result;
    private String followUpInvName;
    private Long followUpID;
    private Integer displayOrder;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getFollowUpInvName() {
        return followUpInvName;
    }

    public void setFollowUpInvName(String followUpInvName) {
        this.followUpInvName = followUpInvName;
    }

    public Long getFollowUpID() {
        return followUpID;
    }

    public void setFollowUpID(Long followUpID) {
        this.followUpID = followUpID;
    }

    public Integer getDisplayOrder() {
        return displayOrder;
    }

    public void setDisplayOrder(Integer displayOrder) {
        this.displayOrder = displayOrder;
    }
}
