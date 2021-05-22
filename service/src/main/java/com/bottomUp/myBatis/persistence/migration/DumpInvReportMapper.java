package com.bottomUp.myBatis.persistence.migration;


import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.migration.DumpAdvice;
import com.bottomUp.domain.migration.DumpInvReport;

import java.util.List;
import java.util.Map;

/**
 * Created by raj on 09/08/2020.
 */
public interface DumpInvReportMapper {

    public void create(DumpInvReport data) throws BottomUpException;

    public void update(DumpInvReport data) throws BottomUpException;

    public DumpInvReport getByID(Long ID) throws BottomUpException;

    public DumpInvReport getByName(String name)throws BottomUpException;

    public List<DumpInvReport> getByParam(Map<String, Object> param) throws BottomUpException;

    public void delete(Map<String, Object> param) throws BottomUpException;
}
