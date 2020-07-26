package com.bottomUp.myBatis.persistence;


import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.common.CompanyData;

import java.util.List;
import java.util.Map;

/**
 * Created by raj on 6/1/2016.
 */
public interface CompanyMapper {

    public void create(CompanyData data) throws BottomUpException;

    public void update(CompanyData data) throws BottomUpException;

    public CompanyData getByID(Long ID) throws BottomUpException;

    public List<CompanyData> getByParam(Map<String, Object> param) throws BottomUpException;

    public void delete(Map<String, Object> param) throws BottomUpException;
}
