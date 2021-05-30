package com.bottomUp.myBatis.persistence;


import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.common.user.GroupPermissionData;
import com.bottomUp.domain.common.user.UserData;

import java.util.List;
import java.util.Map;

/**
 * Created by raj on 3/19/2016.
 */
public interface UserMapper {

    public void create(UserData userData) throws BottomUpException;

    public void update(UserData userData) throws BottomUpException;

    public void updatePassword(UserData userData) throws BottomUpException;

    public void updateStatus(UserData userData) throws BottomUpException;

    public UserData getUserByUserName(String userName) throws BottomUpException;

    public List<GroupPermissionData> getUserPermissionByUserID(String userID) throws BottomUpException;

    public List<UserData> getUserByParam(Map<String, Object> param)throws BottomUpException;

}
