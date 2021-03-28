package com.bottomUp.myBatis.persistence;


import com.bottomUp.common.exception.BottomUpException;

import com.bottomUp.domain.DoseData;

import java.util.List;
import java.util.Map;

/**
 * Created by raj on 09/08/2020.
 */
public interface DoctorDrugDoseSettingMapper {

    public void create(DoseData data) throws BottomUpException;

    public void update(DoseData data) throws BottomUpException;

    public DoseData getByID(Long ID) throws BottomUpException;

    public List<DoseData> getByParam(Map<String, Object> param) throws BottomUpException;

    public void delete(Map<String, Object> param) throws BottomUpException;
}
