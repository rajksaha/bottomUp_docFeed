package com.bottomUp.myBatis.persistence;


import com.bottomUp.common.exception.BottomUpException;

import com.bottomUp.domain.ReferredDoctorData;

import java.util.List;
import java.util.Map;

/**
 * Created by raj on 09/08/2020.
 */
public interface ReferredDoctorMapper {

    public void create(ReferredDoctorData data) throws BottomUpException;

    public void update(ReferredDoctorData data) throws BottomUpException;

    public ReferredDoctorData getByID(Long ID) throws BottomUpException;

    public List<ReferredDoctorData> getByParam(Map<String, Object> param) throws BottomUpException;

    public void delete(Map<String, Object> param) throws BottomUpException;
}
