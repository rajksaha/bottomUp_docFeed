package com.bottomUp.myBatis.persistence;


import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.common.user.UserProfileData;

import java.util.List;
import java.util.Map;

/**
 * Created by raj on 4/28/2016.
 */
public interface UserProfileMapper {


    public void create(UserProfileData userProfileData) throws BottomUpException;

    public void update(UserProfileData userProfileData) throws BottomUpException;

    public UserProfileData getUserProfileByID(String userID) throws BottomUpException;

    public List<UserProfileData> getUserProfileByParam(Map<String, Object> param) throws BottomUpException;

    public Integer getUserCountByParam(Map<String, Object> param) throws BottomUpException;
}
