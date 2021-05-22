package com.bottomUp.myBatis.persistence.migration;


import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.migration.DumpAdvice;
import com.bottomUp.domain.migration.DumpPatientFollowUP;

import java.util.List;
import java.util.Map;

/**
 * Created by raj on 09/08/2020.
 */
public interface DumpPatientFollowUpMapper {

    public void create(DumpPatientFollowUP data) throws BottomUpException;

    public void update(DumpPatientFollowUP data) throws BottomUpException;

    public DumpPatientFollowUP getByID(Long ID) throws BottomUpException;

    public DumpPatientFollowUP getByName(String name)throws BottomUpException;

    public List<DumpPatientFollowUP> getByParam(Map<String, Object> param) throws BottomUpException;

    public void delete(Map<String, Object> param) throws BottomUpException;
}
