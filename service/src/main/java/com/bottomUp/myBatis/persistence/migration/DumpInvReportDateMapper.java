package com.bottomUp.myBatis.persistence.migration;


import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.migration.DumpAdvice;
import com.bottomUp.domain.migration.DumpInvReportDate;

import java.util.List;
import java.util.Map;

/**
 * Created by raj on 09/08/2020.
 */
public interface DumpInvReportDateMapper {

    public void create(DumpInvReportDate data) throws BottomUpException;

    public void update(DumpInvReportDate data) throws BottomUpException;

    public DumpInvReportDate getByID(Long ID) throws BottomUpException;

    public DumpInvReportDate getByName(String name)throws BottomUpException;

    public List<DumpInvReportDate> getByParam(Map<String, Object> param) throws BottomUpException;

    public void delete(Map<String, Object> param) throws BottomUpException;
}
