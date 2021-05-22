package com.bottomUp.myBatis.persistence.migration;


import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.migration.DumpAdvice;
import com.bottomUp.domain.migration.DumpContentdetail;

import java.util.List;
import java.util.Map;

/**
 * Created by raj on 09/08/2020.
 */
public interface DumpContentdetailMapper {

    public void create(DumpContentdetail data) throws BottomUpException;

    public void update(DumpContentdetail data) throws BottomUpException;

    public DumpContentdetail getByID(Long ID) throws BottomUpException;

    public DumpContentdetail getByName(String name)throws BottomUpException;

    public List<DumpContentdetail> getByParam(Map<String, Object> param) throws BottomUpException;

    public void delete(Map<String, Object> param) throws BottomUpException;
}
