package com.bottomUp.myBatis.persistence.migration;


import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.migration.DumpAdvice;
import com.bottomUp.domain.migration.DumpDosePeriod;

import java.util.List;
import java.util.Map;

/**
 * Created by raj on 09/08/2020.
 */
public interface DumpDosePeriodMapper {

    public void create(DumpDosePeriod data) throws BottomUpException;

    public void update(DumpDosePeriod data) throws BottomUpException;

    public DumpDosePeriod getByID(Long ID) throws BottomUpException;

    public DumpDosePeriod getByName(String name)throws BottomUpException;

    public List<DumpDosePeriod> getByParam(Map<String, Object> param) throws BottomUpException;

    public void delete(Map<String, Object> param) throws BottomUpException;
}
