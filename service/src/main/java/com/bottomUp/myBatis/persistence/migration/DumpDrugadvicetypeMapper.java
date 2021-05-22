package com.bottomUp.myBatis.persistence.migration;


import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.migration.DumpAdvice;
import com.bottomUp.domain.migration.DumpDrugadvicetype;

import java.util.List;
import java.util.Map;

/**
 * Created by raj on 09/08/2020.
 */
public interface DumpDrugadvicetypeMapper {

    public void create(DumpDrugadvicetype data) throws BottomUpException;

    public void update(DumpDrugadvicetype data) throws BottomUpException;

    public DumpDrugadvicetype getByID(Long ID) throws BottomUpException;

    public DumpDrugadvicetype getByName(String name)throws BottomUpException;

    public List<DumpDrugadvicetype> getByParam(Map<String, Object> param) throws BottomUpException;

    public void delete(Map<String, Object> param) throws BottomUpException;
}
