package com.bottomUp.myBatis.persistence.migration;


import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.migration.DumpAdvice;
import com.bottomUp.domain.migration.DumpSettingsDoseDrug;

import java.util.List;
import java.util.Map;

/**
 * Created by raj on 09/08/2020.
 */
public interface DumpSettingsDoseDrugMapper {

    public void create(DumpSettingsDoseDrug data) throws BottomUpException;

    public void update(DumpSettingsDoseDrug data) throws BottomUpException;

    public DumpSettingsDoseDrug getByID(Long ID) throws BottomUpException;

    public DumpSettingsDoseDrug getByName(String name)throws BottomUpException;

    public List<DumpSettingsDoseDrug> getByParam(Map<String, Object> param) throws BottomUpException;

    public void delete(Map<String, Object> param) throws BottomUpException;
}
