package com.bottomUp.myBatis.persistence;


import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.AppointmentData;

import java.util.List;
import java.util.Map;

/**
 * Created by raj on 09/08/2020.
 */
public interface AppointmentMapper {

    public AppointmentData create(AppointmentData data) throws BottomUpException;

    public AppointmentData update(AppointmentData data) throws BottomUpException;

    public AppointmentData getByID(Long ID) throws BottomUpException;

    public List<AppointmentData> getByParam(Map<String, Object> param) throws BottomUpException;

    public void delete(Map<String, Object> param) throws BottomUpException;
}
