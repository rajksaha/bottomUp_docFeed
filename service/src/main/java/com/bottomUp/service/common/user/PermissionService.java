package com.bottomUp.service.common.user;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.common.user.PermissionData;
import com.bottomUp.myBatis.persistence.PermissionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by raj on 6/1/2016.
 */

@Service
public class PermissionService {

    @Autowired
    private PermissionMapper permissionMapper;

    public void create(PermissionData data) throws BottomUpException {
        permissionMapper.create(data);
    }

    public void update(PermissionData data) throws BottomUpException {
        permissionMapper.update(data);
    }

    public PermissionData getByID(Integer ID)throws BottomUpException {
        return this.permissionMapper.getByID(ID);
    }

    public List<PermissionData> getByParam(Map<String, Object> param) throws BottomUpException {
        return this.permissionMapper.getByParam(param);
    }

    public void delete (Map<String,Object> param) throws BottomUpException {
        this.permissionMapper.delete(param);
    }
}
