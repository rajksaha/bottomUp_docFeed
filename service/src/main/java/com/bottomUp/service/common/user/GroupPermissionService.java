package com.bottomUp.service.common.user;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.common.user.GroupPermissionData;
import com.bottomUp.myBatis.persistence.GroupPermissionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by raj on 6/3/2016.
 */
@Service
public class GroupPermissionService {

    @Autowired
    private GroupPermissionMapper groupPermissionMapper;

    public void create(GroupPermissionData data) throws BottomUpException {
        this.groupPermissionMapper.create(data);
    }

    public void update(GroupPermissionData data) throws BottomUpException {
        this.groupPermissionMapper.update(data);
    }

    public GroupPermissionData getByID(String ID) throws BottomUpException {
        return this.groupPermissionMapper.getByID(ID);
    }

    public List<GroupPermissionData> getByParam(Map<String, Object> param) throws BottomUpException {
        return this.groupPermissionMapper.getByParam(param);
    }


}
