package com.prescription.myBatis.persistence;


import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.common.CompanyData;
import com.prescription.domain.AppointmentData;

import java.util.List;
import java.util.Map;

/**
 * Created by raj on 09/08/2020.
 */
public interface AppointmentMapper {

    public void create(AppointmentData data) throws BottomUpException;

    public void update(AppointmentData data) throws BottomUpException;

    public AppointmentData getByID(Long ID) throws BottomUpException;

    public List<AppointmentData> getByParam(Map<String, Object> param) throws BottomUpException;

    public void delete(Map<String, Object> param) throws BottomUpException;
}
