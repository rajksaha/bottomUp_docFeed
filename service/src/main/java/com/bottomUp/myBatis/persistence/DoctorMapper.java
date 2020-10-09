package com.bottomUp.myBatis.persistence;


import com.bottomUp.common.exception.BottomUpException;

import com.bottomUp.domain.DoctorData;

import java.util.List;
import java.util.Map;

/**
 * Created by raj on 09/08/2020.
 */
public interface DoctorMapper {

    public DoctorData create(DoctorData data) throws BottomUpException;

    public DoctorData update(DoctorData data) throws BottomUpException;

    public DoctorData getByID(Long ID) throws BottomUpException;

    public List<DoctorData> getByParam(Map<String, Object> param) throws BottomUpException;

    public void delete(Map<String, Object> param) throws BottomUpException;
}
