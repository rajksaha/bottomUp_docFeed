package com.bottomUp.myBatis.persistence.migration;


import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.migration.DumpAdvice;
import com.bottomUp.domain.migration.DumpPatient;

import java.util.List;
import java.util.Map;

/**
 * Created by raj on 09/08/2020.
 */
public interface DumpPatientMapper {

    public void create(DumpPatient data) throws BottomUpException;

    public void update(DumpPatient data) throws BottomUpException;

    public DumpPatient getByID(Long ID) throws BottomUpException;

    public DumpPatient getByName(String name)throws BottomUpException;

    public List<DumpPatient> getByParam(Map<String, Object> param) throws BottomUpException;

    public void delete(Map<String, Object> param) throws BottomUpException;
}
