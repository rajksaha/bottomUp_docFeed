package com.bottomUp.myBatis.persistence;


import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.AppointmentData;
import com.bottomUp.model.AppointmentViewData;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by raj on 09/08/2020.
 */
@Repository
public interface AppointmentMapper {

    void create(AppointmentData data) throws BottomUpException;

    void update(AppointmentData data) throws BottomUpException;

    void updateStatusByID(AppointmentData data) throws BottomUpException;

    void updateAppTypeByID(AppointmentData data) throws BottomUpException;

    AppointmentData getByID(Long ID) throws BottomUpException;

    List<AppointmentData> getByParam(Map<String, Object> param) throws BottomUpException;

    List<AppointmentViewData> getAppPatientDetail(Map<String, Object> param) throws BottomUpException;

    Integer getCountByParam(Map<String, Object> param) throws BottomUpException;

    void delete(Map<String, Object> param) throws BottomUpException;
}
