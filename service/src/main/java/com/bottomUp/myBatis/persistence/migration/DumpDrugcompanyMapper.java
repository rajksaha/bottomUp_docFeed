package com.bottomUp.myBatis.persistence.migration;


import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.migration.DumpAdvice;
import com.bottomUp.domain.migration.DumpDrugcompany;

import java.util.List;
import java.util.Map;

/**
 * Created by raj on 09/08/2020.
 */
public interface DumpDrugcompanyMapper {

    public void create(DumpDrugcompany data) throws BottomUpException;

    public void update(DumpDrugcompany data) throws BottomUpException;

    public DumpDrugcompany getByID(Long ID) throws BottomUpException;

    public DumpDrugcompany getByName(String name)throws BottomUpException;

    public List<DumpDrugcompany> getByParam(Map<String, Object> param) throws BottomUpException;

    public void delete(Map<String, Object> param) throws BottomUpException;
}
