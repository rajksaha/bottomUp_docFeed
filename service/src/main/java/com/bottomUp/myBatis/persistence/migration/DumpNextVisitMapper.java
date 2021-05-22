package com.bottomUp.myBatis.persistence.migration;


import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.migration.DumpAdvice;
import com.bottomUp.domain.migration.DumpNextVisit;

import java.util.List;
import java.util.Map;

/**
 * Created by raj on 09/08/2020.
 */
public interface DumpNextVisitMapper {

    public void create(DumpNextVisit data) throws BottomUpException;

    public void update(DumpNextVisit data) throws BottomUpException;

    public DumpNextVisit getByID(Long ID) throws BottomUpException;

    public DumpNextVisit getByName(String name)throws BottomUpException;

    public List<DumpNextVisit> getByParam(Map<String, Object> param) throws BottomUpException;

    public void delete(Map<String, Object> param) throws BottomUpException;
}
