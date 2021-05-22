package com.bottomUp.myBatis.persistence.migration;


import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.migration.DumpAdvice;
import com.bottomUp.domain.migration.DumpPatientType;

import java.util.List;
import java.util.Map;

/**
 * Created by raj on 09/08/2020.
 */
public interface DumpPatientTypeMapper {

    public void create(DumpPatientType data) throws BottomUpException;

    public void update(DumpPatientType data) throws BottomUpException;

    public DumpPatientType getByID(Long ID) throws BottomUpException;

    public DumpPatientType getByName(String name)throws BottomUpException;

    public List<DumpPatientType> getByParam(Map<String, Object> param) throws BottomUpException;

    public void delete(Map<String, Object> param) throws BottomUpException;
}
