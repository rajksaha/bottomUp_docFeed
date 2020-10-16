package com.bottomUp.myBatis.persistence;


import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.AppointmentTypeData;

import java.util.List;
import java.util.Map;

/**
 * Created by raj on 09/08/2020.
 */
public interface AppointmentTypeMapper {

    public void create(AppointmentTypeData data) throws BottomUpException;

    public void update(AppointmentTypeData data) throws BottomUpException;

    public AppointmentTypeData getByID(Long ID) throws BottomUpException;

    public List<AppointmentTypeData> getByParam(Map<String, Object> param) throws BottomUpException;

    public void delete(Map<String, Object> param) throws BottomUpException;
}
