package com.bottomUp.myBatis.persistence;


import com.bottomUp.common.exception.BottomUpException;

import com.bottomUp.domain.FollowUpResultData;

import java.util.List;
import java.util.Map;

/**
 * Created by raj on 09/08/2020.
 */
public interface FollowUpResultMapper {

    public FollowUpResultData create(FollowUpResultData data) throws BottomUpException;

    public FollowUpResultData update(FollowUpResultData data) throws BottomUpException;

    public FollowUpResultData getByID(Long ID) throws BottomUpException;

    public List<FollowUpResultData> getByParam(Map<String, Object> param) throws BottomUpException;

    public void delete(Map<String, Object> param) throws BottomUpException;
}
