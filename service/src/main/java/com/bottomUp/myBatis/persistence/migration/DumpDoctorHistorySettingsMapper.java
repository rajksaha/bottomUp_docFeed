package com.bottomUp.myBatis.persistence.migration;


import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.migration.DumpAdvice;
import com.bottomUp.domain.migration.DumpDoctorHistorySettings;

import java.util.List;
import java.util.Map;

/**
 * Created by raj on 09/08/2020.
 */
public interface DumpDoctorHistorySettingsMapper {

    public void create(DumpDoctorHistorySettings data) throws BottomUpException;

    public void update(DumpDoctorHistorySettings data) throws BottomUpException;

    public DumpDoctorHistorySettings getByID(Long ID) throws BottomUpException;

    public DumpDoctorHistorySettings getByName(String name)throws BottomUpException;

    public List<DumpDoctorHistorySettings> getByParam(Map<String, Object> param) throws BottomUpException;

    public void delete(Map<String, Object> param) throws BottomUpException;
}
