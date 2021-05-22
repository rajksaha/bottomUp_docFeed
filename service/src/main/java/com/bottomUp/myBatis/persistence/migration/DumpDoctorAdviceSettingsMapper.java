package com.bottomUp.myBatis.persistence.migration;


import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.migration.DumpAdvice;
import com.bottomUp.domain.migration.DumpDoctorAdviceSettings;

import java.util.List;
import java.util.Map;

/**
 * Created by raj on 09/08/2020.
 */
public interface DumpDoctorAdviceSettingsMapper {

    public void create(DumpDoctorAdviceSettings data) throws BottomUpException;

    public void update(DumpDoctorAdviceSettings data) throws BottomUpException;

    public DumpDoctorAdviceSettings getByID(Long ID) throws BottomUpException;

    public DumpDoctorAdviceSettings getByName(String name)throws BottomUpException;

    public List<DumpDoctorAdviceSettings> getByParam(Map<String, Object> param) throws BottomUpException;

    public void delete(Map<String, Object> param) throws BottomUpException;
}
