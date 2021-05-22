package com.bottomUp.myBatis.persistence.migration;


import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.migration.DumpAdvice;
import com.bottomUp.domain.migration.DumpPatientDetail;

import java.util.List;
import java.util.Map;

/**
 * Created by raj on 09/08/2020.
 */
public interface DumpPatientDetailMapper {

    public void create(DumpPatientDetail data) throws BottomUpException;

    public void update(DumpPatientDetail data) throws BottomUpException;

    public DumpPatientDetail getByID(Long ID) throws BottomUpException;

    public DumpPatientDetail getByName(String name)throws BottomUpException;

    public List<DumpPatientDetail> getByParam(Map<String, Object> param) throws BottomUpException;

    public void delete(Map<String, Object> param) throws BottomUpException;
}
