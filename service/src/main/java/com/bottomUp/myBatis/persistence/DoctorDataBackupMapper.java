package com.bottomUp.myBatis.persistence;


import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.AppointmentData;
import com.bottomUp.domain.DoctorDataBackupData;

import java.util.List;
import java.util.Map;

/**
 * Created by raj on 09/08/2020.
 */
public interface DoctorDataBackupMapper {

    public void create(DoctorDataBackupData data) throws BottomUpException;

    public void update(DoctorDataBackupData data) throws BottomUpException;

    public DoctorDataBackupData getByID(Long ID) throws BottomUpException;

    public List<DoctorDataBackupData> getByParam(Map<String, Object> param) throws BottomUpException;

    public void delete(Map<String, Object> param) throws BottomUpException;
}
