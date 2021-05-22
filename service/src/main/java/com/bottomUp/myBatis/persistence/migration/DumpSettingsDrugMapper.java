package com.bottomUp.myBatis.persistence.migration;


import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.migration.DumpAdvice;
import com.bottomUp.domain.migration.DumpSettingsDrug;

import java.util.List;
import java.util.Map;

/**
 * Created by raj on 09/08/2020.
 */
public interface DumpSettingsDrugMapper {

    public void create(DumpSettingsDrug data) throws BottomUpException;

    public void update(DumpSettingsDrug data) throws BottomUpException;

    public DumpSettingsDrug getByID(Long ID) throws BottomUpException;

    public DumpSettingsDrug getByName(String name)throws BottomUpException;

    public List<DumpSettingsDrug> getByParam(Map<String, Object> param) throws BottomUpException;

    public void delete(Map<String, Object> param) throws BottomUpException;
}
