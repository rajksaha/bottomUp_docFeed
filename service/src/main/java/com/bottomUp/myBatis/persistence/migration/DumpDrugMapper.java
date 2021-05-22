package com.bottomUp.myBatis.persistence.migration;


import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.migration.DumpAdvice;
import com.bottomUp.domain.migration.DumpDrug;

import java.util.List;
import java.util.Map;

/**
 * Created by raj on 09/08/2020.
 */
public interface DumpDrugMapper {

    public void create(DumpDrug data) throws BottomUpException;

    public void update(DumpDrug data) throws BottomUpException;

    public DumpDrug getByID(Long ID) throws BottomUpException;

    public DumpDrug getByName(String name)throws BottomUpException;

    public List<DumpDrug> getByParam(Map<String, Object> param) throws BottomUpException;

    public void delete(Map<String, Object> param) throws BottomUpException;
}
