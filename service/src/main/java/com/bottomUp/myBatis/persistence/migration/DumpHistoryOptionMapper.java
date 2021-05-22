package com.bottomUp.myBatis.persistence.migration;


import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.migration.DumpAdvice;
import com.bottomUp.domain.migration.DumpHistoryOption;

import java.util.List;
import java.util.Map;

/**
 * Created by raj on 09/08/2020.
 */
public interface DumpHistoryOptionMapper {

    public void create(DumpHistoryOption data) throws BottomUpException;

    public void update(DumpHistoryOption data) throws BottomUpException;

    public DumpHistoryOption getByID(Long ID) throws BottomUpException;

    public DumpHistoryOption getByName(String name)throws BottomUpException;

    public List<DumpHistoryOption> getByParam(Map<String, Object> param) throws BottomUpException;

    public void delete(Map<String, Object> param) throws BottomUpException;
}
