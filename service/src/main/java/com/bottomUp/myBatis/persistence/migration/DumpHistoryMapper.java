package com.bottomUp.myBatis.persistence.migration;


import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.migration.DumpAdvice;
import com.bottomUp.domain.migration.DumpHistory;

import java.util.List;
import java.util.Map;

/**
 * Created by raj on 09/08/2020.
 */
public interface DumpHistoryMapper {

    public void create(DumpHistory data) throws BottomUpException;

    public void update(DumpHistory data) throws BottomUpException;

    public DumpHistory getByID(Long ID) throws BottomUpException;

    public DumpHistory getByName(String name)throws BottomUpException;

    public List<DumpHistory> getByParam(Map<String, Object> param) throws BottomUpException;

    public void delete(Map<String, Object> param) throws BottomUpException;
}
