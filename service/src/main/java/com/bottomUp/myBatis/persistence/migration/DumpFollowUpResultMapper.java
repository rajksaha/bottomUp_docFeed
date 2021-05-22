package com.bottomUp.myBatis.persistence.migration;


import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.migration.DumpAdvice;
import com.bottomUp.domain.migration.DumpFollowUpResult;

import java.util.List;
import java.util.Map;

/**
 * Created by raj on 09/08/2020.
 */
public interface DumpFollowUpResultMapper {

    public void create(DumpFollowUpResult data) throws BottomUpException;

    public void update(DumpFollowUpResult data) throws BottomUpException;

    public DumpFollowUpResult getByID(Long ID) throws BottomUpException;

    public DumpFollowUpResult getByName(String name)throws BottomUpException;

    public List<DumpFollowUpResult> getByParam(Map<String, Object> param) throws BottomUpException;

    public void delete(Map<String, Object> param) throws BottomUpException;
}
