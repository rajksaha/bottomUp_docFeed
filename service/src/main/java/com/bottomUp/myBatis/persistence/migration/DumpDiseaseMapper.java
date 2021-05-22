package com.bottomUp.myBatis.persistence.migration;


import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.migration.DumpAdvice;
import com.bottomUp.domain.migration.DumpDisease;

import java.util.List;
import java.util.Map;

/**
 * Created by raj on 09/08/2020.
 */
public interface DumpDiseaseMapper {

    public void create(DumpDisease data) throws BottomUpException;

    public void update(DumpDisease data) throws BottomUpException;

    public DumpDisease getByID(Long ID) throws BottomUpException;

    public DumpDisease getByName(String name)throws BottomUpException;

    public List<DumpDisease> getByParam(Map<String, Object> param) throws BottomUpException;

    public void delete(Map<String, Object> param) throws BottomUpException;
}
