package com.bottomUp.myBatis.persistence;


import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.common.ModuleData;

import java.util.List;
import java.util.Map;

/**
 * Created by raj on 6/1/2016.
 */
public interface ModuleMapper {

    public void create(ModuleData data) throws BottomUpException;

    public void update(ModuleData data) throws BottomUpException;

    public ModuleData getByID(String ID) throws BottomUpException;

    public List<ModuleData> getByParam(Map<String, Object> param) throws BottomUpException;

    public void delete(Map<String, Object> param) throws BottomUpException;
}
