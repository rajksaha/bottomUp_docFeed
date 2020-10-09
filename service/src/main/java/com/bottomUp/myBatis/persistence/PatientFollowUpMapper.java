package com.bottomUp.myBatis.persistence;


import com.bottomUp.common.exception.BottomUpException;

import com.bottomUp.domain.PatientFollowUpData;

import java.util.List;
import java.util.Map;

/**
 * Created by raj on 09/08/2020.
 */
public interface PatientFollowUpMapper {

    public PatientFollowUpData create(PatientFollowUpData data) throws BottomUpException;

    public PatientFollowUpData update(PatientFollowUpData data) throws BottomUpException;

    public PatientFollowUpData getByID(Long ID) throws BottomUpException;

    public List<PatientFollowUpData> getByParam(Map<String, Object> param) throws BottomUpException;

    public void delete(Map<String, Object> param) throws BottomUpException;
}
