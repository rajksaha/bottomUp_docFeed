package com.bottomUp.service.docFeed.crud;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.AppointmentTypeData;
import com.bottomUp.domain.FollowUpResultData;
import com.bottomUp.myBatis.persistence.AppointmentTypeMapper;
import com.bottomUp.myBatis.persistence.FollowUpResultMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by raj on 09/08/2020.
 */

@Service
public class FollowUpResultService {

    @Autowired
    private FollowUpResultMapper followUpResultMapper;

    public void create(FollowUpResultData data) throws BottomUpException {
        followUpResultMapper.create(data);
    }

    public void update(FollowUpResultData data) throws BottomUpException {
        followUpResultMapper.update(data);
    }

    public FollowUpResultData getByID(Long ID)throws BottomUpException {
        return this.followUpResultMapper.getByID(ID);
    }

    public List<FollowUpResultData> getByParam(Map<String, Object> param) throws BottomUpException {
        return this.followUpResultMapper.getByParam(param);
    }

    public void delete (Map<String,Object> param) throws BottomUpException {
        this.followUpResultMapper.delete(param);
    }
}
