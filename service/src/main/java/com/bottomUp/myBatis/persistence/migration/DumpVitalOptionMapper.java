package com.bottomUp.myBatis.persistence.migration;


import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.migration.DumpAdvice;
import com.bottomUp.domain.migration.DumpVitalOption;

import java.util.List;
import java.util.Map;

/**
 * Created by raj on 09/08/2020.
 */
public interface DumpVitalOptionMapper {

    public void create(DumpVitalOption data) throws BottomUpException;

    public void update(DumpVitalOption data) throws BottomUpException;

    public DumpVitalOption getByID(Long ID) throws BottomUpException;

    public DumpVitalOption getByName(String name)throws BottomUpException;

    public List<DumpVitalOption> getByParam(Map<String, Object> param) throws BottomUpException;

    public void delete(Map<String, Object> param) throws BottomUpException;
}
