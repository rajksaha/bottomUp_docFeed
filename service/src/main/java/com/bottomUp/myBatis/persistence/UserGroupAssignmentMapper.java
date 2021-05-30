package com.bottomUp.myBatis.persistence;


import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.common.user.UserGroupAssignmentData;

import java.util.List;
import java.util.Map;

/**
 * Created by raj on 4/28/2016.
 */
public interface UserGroupAssignmentMapper {


    public void create(UserGroupAssignmentData data) throws BottomUpException;

    public void update(UserGroupAssignmentData data) throws BottomUpException;

    public void deleteByUserID(String userID) throws BottomUpException;

    public UserGroupAssignmentData getByID(Integer userProfileID) throws BottomUpException;

    public List<UserGroupAssignmentData> getByParam(Map<String, Object> param) throws BottomUpException;
}
