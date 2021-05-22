package com.bottomUp.myBatis.persistence.migration;


import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.migration.DumpAdvice;
import com.bottomUp.domain.migration.DumpDoctorVitalSettings;

import java.util.List;
import java.util.Map;

/**
 * Created by raj on 09/08/2020.
 */
public interface DumpDoctorVitalSettingsMapper {

    public void create(DumpDoctorVitalSettings data) throws BottomUpException;

    public void update(DumpDoctorVitalSettings data) throws BottomUpException;

    public DumpDoctorVitalSettings getByID(Long ID) throws BottomUpException;

    public DumpDoctorVitalSettings getByName(String name)throws BottomUpException;

    public List<DumpDoctorVitalSettings> getByParam(Map<String, Object> param) throws BottomUpException;

    public void delete(Map<String, Object> param) throws BottomUpException;
}
