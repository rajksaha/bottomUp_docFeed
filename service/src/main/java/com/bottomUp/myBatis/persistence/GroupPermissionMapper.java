package com.bottomUp.myBatis.persistence;


import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.common.user.GroupPermissionData;

import java.util.List;
import java.util.Map;

/**
 * Created by raj on 6/3/2016.
 */
public interface GroupPermissionMapper {

    public void create(GroupPermissionData data) throws BottomUpException;

    public void update(GroupPermissionData data) throws BottomUpException;

    public GroupPermissionData getByID(String ID) throws BottomUpException;

    public void deletePermissionByGroup(String groupID) throws BottomUpException;

    public List<GroupPermissionData> getByParam(Map<String, Object> param) throws BottomUpException;
}
