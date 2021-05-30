package com.bottomUp.myBatis.persistence;



import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.common.CompanyModuleData;

import java.util.List;
import java.util.Map;

/**
 * Created by raj on 6/1/2016.
 */
public interface CompanyModuleMapper {

    public void create(CompanyModuleData data) throws BottomUpException;

    public void update(CompanyModuleData data) throws BottomUpException;

    public CompanyModuleData getByID(String ID) throws BottomUpException;

    public List<CompanyModuleData> getByParam(Map<String, Object> param) throws BottomUpException;

    public void delete(Map<String, Object> param) throws BottomUpException;
}
