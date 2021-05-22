package com.bottomUp.myBatis.persistence.migration;


import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.migration.DumpAdvice;
import com.bottomUp.domain.migration.DumpVital;

import java.util.List;
import java.util.Map;

/**
 * Created by raj on 09/08/2020.
 */
public interface DumpVitalMapper {

    public void create(DumpVital data) throws BottomUpException;

    public void update(DumpVital data) throws BottomUpException;

    public DumpVital getByID(Long ID) throws BottomUpException;

    public DumpVital getByName(String name)throws BottomUpException;

    public List<DumpVital> getByParam(Map<String, Object> param) throws BottomUpException;

    public void delete(Map<String, Object> param) throws BottomUpException;
}
