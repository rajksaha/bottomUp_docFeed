package com.bottomUp.myBatis.persistence.migration;


import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.migration.DumpAdvice;
import com.bottomUp.domain.migration.DumpDiagnosis;

import java.util.List;
import java.util.Map;

/**
 * Created by raj on 09/08/2020.
 */
public interface DumpDiagnosisMapper {

    public void create(DumpDiagnosis data) throws BottomUpException;

    public void update(DumpDiagnosis data) throws BottomUpException;

    public DumpDiagnosis getByID(Long ID) throws BottomUpException;

    public DumpDiagnosis getByName(String name)throws BottomUpException;

    public List<DumpDiagnosis> getByParam(Map<String, Object> param) throws BottomUpException;

    public void delete(Map<String, Object> param) throws BottomUpException;
}
