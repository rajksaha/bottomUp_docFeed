package com.bottomUp.myBatis.persistence.migration;


import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.migration.DumpAdvice;
import com.bottomUp.domain.migration.DumpSettingsInv;

import java.util.List;
import java.util.Map;

/**
 * Created by raj on 09/08/2020.
 */
public interface DumpSettingsInvMapper {

    public void create(DumpSettingsInv data) throws BottomUpException;

    public void update(DumpSettingsInv data) throws BottomUpException;

    public DumpSettingsInv getByID(Long ID) throws BottomUpException;

    public DumpSettingsInv getByName(String name)throws BottomUpException;

    public List<DumpSettingsInv> getByParam(Map<String, Object> param) throws BottomUpException;

    public void delete(Map<String, Object> param) throws BottomUpException;
}
