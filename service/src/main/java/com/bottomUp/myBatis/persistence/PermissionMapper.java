package com.bottomUp.myBatis.persistence;


import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.common.user.PermissionData;

import java.util.List;
import java.util.Map;

/**
 * Created by raj on 6/3/2016.
 */
public interface PermissionMapper {

    public void create(PermissionData data) throws BottomUpException;

    public void update(PermissionData data) throws BottomUpException;

    public PermissionData getByID(Integer ID) throws BottomUpException;

    public List<PermissionData> getByParam(Map<String, Object> param) throws BottomUpException;

    public List<PermissionData> getCompanyModulePermission(Map<String, Object> param) throws BottomUpException;
}
