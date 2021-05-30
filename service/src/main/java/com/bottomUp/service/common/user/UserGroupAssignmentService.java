package com.bottomUp.service.common.user;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.common.user.UserGroupAssignmentData;
import com.bottomUp.domain.common.user.UserGroupData;
import com.bottomUp.domain.common.user.UserProfileData;
import com.bottomUp.myBatis.persistence.UserGroupAssignmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by raj on 6/3/2016.
 */
@Service
public class UserGroupAssignmentService {

    @Autowired
    private UserGroupAssignmentMapper userGroupAssignmentMapper;

    public void create(UserGroupAssignmentData data) throws BottomUpException {
        this.userGroupAssignmentMapper.create(data);
    }

    public void update(UserGroupAssignmentData data) throws BottomUpException {
        this.userGroupAssignmentMapper.update(data);
    }

    public void deleteByUserID(String userID) throws BottomUpException {
        this.userGroupAssignmentMapper.deleteByUserID(userID);
    }

    public UserGroupAssignmentData getByID(Integer ID) throws BottomUpException {
        return this.userGroupAssignmentMapper.getByID(ID);
    }

    public List<UserGroupAssignmentData> getByParam(Map<String, Object> param) throws BottomUpException {
        return this.userGroupAssignmentMapper.getByParam(param);
    }

    public void updateUserGroupAssignment(UserProfileData userProfileData)throws BottomUpException {

        this.deleteByUserID(userProfileData.getUserID());

        for(UserGroupData group : userProfileData.getUserGroupList()){
            if(group.getAssigned() != null && group.getAssigned()){
                UserGroupAssignmentData assignmentData = new UserGroupAssignmentData();
                assignmentData.setUserGroupID(group.getUserGroupID());
                assignmentData.setUserID(userProfileData.getUserID());
                assignmentData.setStatus(1);
                this.create(assignmentData);
            }
        }
    }

}
