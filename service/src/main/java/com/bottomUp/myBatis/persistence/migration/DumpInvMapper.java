package com.bottomUp.myBatis.persistence.migration;


import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.migration.DumpAdvice;
import com.bottomUp.domain.migration.DumpInv;

import java.util.List;
import java.util.Map;

/**
 * Created by raj on 09/08/2020.
 */
public interface DumpInvMapper {

    public void create(DumpInv data) throws BottomUpException;

    public void update(DumpInv data) throws BottomUpException;

    public DumpInv getByID(Long ID) throws BottomUpException;

    public DumpInv getByName(String name)throws BottomUpException;

    public List<DumpInv> getByParam(Map<String, Object> param) throws BottomUpException;

    public void delete(Map<String, Object> param) throws BottomUpException;
}
