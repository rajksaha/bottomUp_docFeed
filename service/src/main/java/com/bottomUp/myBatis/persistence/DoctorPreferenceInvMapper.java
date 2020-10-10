package com.bottomUp.myBatis.persistence;


import com.bottomUp.common.exception.BottomUpException;

import com.bottomUp.domain.DoctorPreferenceInvData;

import java.util.List;
import java.util.Map;

/**
 * Created by raj on 09/08/2020.
 */
public interface DoctorPreferenceInvMapper {

    public void create(DoctorPreferenceInvData data) throws BottomUpException;

    public void update(DoctorPreferenceInvData data) throws BottomUpException;

    public DoctorPreferenceInvData getByID(Long ID) throws BottomUpException;

    public List<DoctorPreferenceInvData> getByParam(Map<String, Object> param) throws BottomUpException;

    public void delete(Map<String, Object> param) throws BottomUpException;
}
