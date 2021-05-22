package com.bottomUp.myBatis.persistence.migration;


import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.migration.DumpAdvice;
import com.bottomUp.domain.migration.DumpPatientPastDisease;

import java.util.List;
import java.util.Map;

/**
 * Created by raj on 09/08/2020.
 */
public interface DumpPatientPastDiseaseMapper {

    public void create(DumpPatientPastDisease data) throws BottomUpException;

    public void update(DumpPatientPastDisease data) throws BottomUpException;

    public DumpPatientPastDisease getByID(Long ID) throws BottomUpException;

    public DumpPatientPastDisease getByName(String name)throws BottomUpException;

    public List<DumpPatientPastDisease> getByParam(Map<String, Object> param) throws BottomUpException;

    public void delete(Map<String, Object> param) throws BottomUpException;
}
