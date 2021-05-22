package com.bottomUp.myBatis.persistence.migration;


import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.migration.DumpAdvice;
import com.bottomUp.domain.migration.DumpDrugHistory;

import java.util.List;
import java.util.Map;

/**
 * Created by raj on 09/08/2020.
 */
public interface DumpDrugHistoryMapper {

    public void create(DumpDrugHistory data) throws BottomUpException;

    public void update(DumpDrugHistory data) throws BottomUpException;

    public DumpDrugHistory getByID(Long ID) throws BottomUpException;

    public DumpDrugHistory getByName(String name)throws BottomUpException;

    public List<DumpDrugHistory> getByParam(Map<String, Object> param) throws BottomUpException;

    public void delete(Map<String, Object> param) throws BottomUpException;
}
