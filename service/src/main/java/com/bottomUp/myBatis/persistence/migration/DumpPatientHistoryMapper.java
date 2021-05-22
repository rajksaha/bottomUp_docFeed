package com.bottomUp.myBatis.persistence.migration;


import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.migration.DumpAdvice;
import com.bottomUp.domain.migration.DumpPatientHistory;

import java.util.List;
import java.util.Map;

/**
 * Created by raj on 09/08/2020.
 */
public interface DumpPatientHistoryMapper {

    public void create(DumpPatientHistory data) throws BottomUpException;

    public void update(DumpPatientHistory data) throws BottomUpException;

    public DumpPatientHistory getByID(Long ID) throws BottomUpException;

    public DumpPatientHistory getByName(String name)throws BottomUpException;

    public List<DumpPatientHistory> getByParam(Map<String, Object> param) throws BottomUpException;

    public void delete(Map<String, Object> param) throws BottomUpException;
}
