package com.bottomUp.myBatis.persistence;


import com.bottomUp.common.exception.BottomUpException;

import com.bottomUp.domain.DoctorPreferenceAdviceData;

import java.util.List;
import java.util.Map;

/**
 * Created by raj on 09/08/2020.
 */
public interface DoctorPreferenceAdviceMapper {

    public void create(DoctorPreferenceAdviceData data) throws BottomUpException;

    public void update(DoctorPreferenceAdviceData data) throws BottomUpException;

    public DoctorPreferenceAdviceData getByID(Long ID) throws BottomUpException;

    public List<DoctorPreferenceAdviceData> getByParam(Map<String, Object> param) throws BottomUpException;

    public void delete(Map<String, Object> param) throws BottomUpException;
}
