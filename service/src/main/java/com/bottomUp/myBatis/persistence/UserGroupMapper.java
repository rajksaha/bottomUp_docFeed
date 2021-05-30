package com.bottomUp.myBatis.persistence;


import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.common.user.UserGroupData;

import java.util.List;
import java.util.Map;

/**
 * Created by raj on 4/28/2016.
 */
public interface UserGroupMapper {


    public void create(UserGroupData data) throws BottomUpException;

    public void update(UserGroupData data) throws BottomUpException;

    public UserGroupData getByID(String ID) throws BottomUpException;

    public UserGroupData getSingleByParam(Map<String, Object> param) throws BottomUpException;

    public List<UserGroupData> getByParam(Map<String, Object> param) throws BottomUpException;

    public Integer getCountByParam(Map<String, Object> param) throws BottomUpException;

    public List<UserGroupData> getUserGroupForUser(Map<String, Object> param) throws BottomUpException;

    public void delete(Map<String, Object> param) throws BottomUpException;
}
