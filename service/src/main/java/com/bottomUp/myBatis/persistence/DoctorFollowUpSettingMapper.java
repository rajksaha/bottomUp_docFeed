package com.bottomUp.myBatis.persistence;


import com.bottomUp.common.exception.BottomUpException;

import com.bottomUp.domain.DoctorFollowUpSettingData;

import java.util.List;
import java.util.Map;

/**
 * Created by raj on 09/08/2020.
 */
public interface DoctorFollowUpSettingMapper {

    public void create(DoctorFollowUpSettingData data) throws BottomUpException;

    public void update(DoctorFollowUpSettingData data) throws BottomUpException;

    public void updateDisplayOrder(List<DoctorFollowUpSettingData> followUpList) throws BottomUpException;

    public DoctorFollowUpSettingData getByID(Long ID) throws BottomUpException;

    public List<DoctorFollowUpSettingData> getByParam(Map<String, Object> param) throws BottomUpException;

    public void delete(Map<String, Object> param) throws BottomUpException;
}
