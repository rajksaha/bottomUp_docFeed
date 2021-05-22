package com.bottomUp.myBatis.persistence.migration;


import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.migration.DumpComplain;

import java.util.List;
import java.util.Map;

/**
 * Created by raj on 09/08/2020.
 */
public interface DumpComplainMapper {

    public void create(DumpComplain data) throws BottomUpException;

    public void update(DumpComplain data) throws BottomUpException;

    public DumpComplain getByID(Long ID) throws BottomUpException;

    public DumpComplain getByName(String name)throws BottomUpException;

    public List<DumpComplain> getByParam(Map<String, Object> param) throws BottomUpException;

    public void delete(Map<String, Object> param) throws BottomUpException;
}
