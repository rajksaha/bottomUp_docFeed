package com.bottomUp.myBatis.persistence.migration;


import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.migration.DumpAdvice;
import com.bottomUp.domain.migration.DumpPatientFamilyHistory;

import java.util.List;
import java.util.Map;

/**
 * Created by raj on 09/08/2020.
 */
public interface DumpPatientFamilyHistoryMapper {

    public void create(DumpPatientFamilyHistory data) throws BottomUpException;

    public void update(DumpPatientFamilyHistory data) throws BottomUpException;

    public DumpPatientFamilyHistory getByID(Long ID) throws BottomUpException;

    public DumpPatientFamilyHistory getByName(String name)throws BottomUpException;

    public List<DumpPatientFamilyHistory> getByParam(Map<String, Object> param) throws BottomUpException;

    public void delete(Map<String, Object> param) throws BottomUpException;
}
