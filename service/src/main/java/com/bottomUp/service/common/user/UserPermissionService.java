package com.bottomUp.service.common.user;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.common.user.GroupPermissionData;
import com.bottomUp.myBatis.persistence.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by raj on 3/19/2016.
 */
@Service
public class UserPermissionService {

    @Autowired
    private UserMapper userMapper;

    public List<GroupPermissionData> getUserPermissionByUserID (Long userID) throws BottomUpException {
        return userMapper.getUserPermissionByUserID(userID);
    }
}
