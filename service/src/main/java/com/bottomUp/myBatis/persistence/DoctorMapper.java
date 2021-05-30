package com.bottomUp.myBatis.persistence;


import com.bottomUp.common.exception.BottomUpException;

import com.bottomUp.domain.DoctorData;

import java.util.List;
import java.util.Map;

/**
 * Created by raj on 09/08/2020.
 */
public interface DoctorMapper {

    public void create(DoctorData data) throws BottomUpException;

    public void update(DoctorData data) throws BottomUpException;

    public DoctorData getByID(String ID) throws BottomUpException;

    public List<DoctorData> getByParam(Map<String, Object> param) throws BottomUpException;

    public void delete(Map<String, Object> param) throws BottomUpException;
}
