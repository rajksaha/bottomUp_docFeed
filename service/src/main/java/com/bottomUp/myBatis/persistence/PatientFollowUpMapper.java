package com.bottomUp.myBatis.persistence;


import com.bottomUp.common.exception.BottomUpException;

import com.bottomUp.domain.PatientFollowUpData;

import java.util.List;
import java.util.Map;

/**
 * Created by raj on 09/08/2020.
 */
public interface PatientFollowUpMapper {

    public void create(PatientFollowUpData data) throws BottomUpException;

    public void update(PatientFollowUpData data) throws BottomUpException;

    public PatientFollowUpData getByID(String ID) throws BottomUpException;

    public List<PatientFollowUpData> getByParam(Map<String, Object> param) throws BottomUpException;

    public void delete(Map<String, Object> param) throws BottomUpException;
}
