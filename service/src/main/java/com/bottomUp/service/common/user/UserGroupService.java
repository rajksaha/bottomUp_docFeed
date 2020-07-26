package com.bottomUp.service.common.user;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.common.user.GroupPermissionData;
import com.bottomUp.domain.common.user.PermissionData;
import com.bottomUp.domain.common.user.UserGroupData;
import com.bottomUp.myBatis.persistence.GroupPermissionMapper;
import com.bottomUp.myBatis.persistence.PermissionMapper;
import com.bottomUp.myBatis.persistence.UserGroupMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by raj on 6/3/2016.
 */
@Service
public class UserGroupService {

    @Autowired
    private UserGroupMapper userGroupMapper;

    @Autowired
    private PermissionMapper permissionMapper;

    @Autowired
    private GroupPermissionMapper groupPermissionMapper;

    public void create(UserGroupData data) throws BottomUpException {
        this.userGroupMapper.create(data);
    }

    public void update(UserGroupData data) throws BottomUpException {
        this.userGroupMapper.update(data);
    }

    public UserGroupData getByID(Integer ID) throws BottomUpException {
        return this.userGroupMapper.getByID(ID);
    }

    public List<UserGroupData> getByParam(Map<String, Object> param) throws BottomUpException {
        return this.userGroupMapper.getByParam(param);
    }

    public Integer getCountByParam(Map<String, Object> param) throws BottomUpException {
        return this.userGroupMapper.getCountByParam(param);
    }

    public List<UserGroupData> getUserGroupForUser(Map<String, Object> param) throws BottomUpException {
        return this.userGroupMapper.getUserGroupForUser(param);
    }

    public List<PermissionData> getCompanyModulePermission(Map<String, Object> param) throws BottomUpException {
        return this.permissionMapper.getCompanyModulePermission(param);
    }

    public void updateGroupPermission(UserGroupData userGroupData) throws BottomUpException {

        //Delete all assigned permission
        this.groupPermissionMapper.deletePermissionByGroup(userGroupData.getUserGroupID());

        for(PermissionData permission : userGroupData.getGroupPermissionList()){
            if(permission.getIsAssigned() != null && permission.getIsAssigned()){
                GroupPermissionData groupPermissionData = new GroupPermissionData();
                groupPermissionData.setUserGroupID(userGroupData.getUserGroupID());
                groupPermissionData.setStatusValue(1);
                groupPermissionData.setPermissionID(permission.getPermissionID());
                this.groupPermissionMapper.create(groupPermissionData);
            }
        }
    }

    public List<PermissionData> getPermissionByParam (Map<String, Object> param) throws BottomUpException {
        return this.permissionMapper.getByParam(param);
    }




}
