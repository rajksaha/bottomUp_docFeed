package com.bottomUp.myBatis.persistence.migration;


import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.migration.DumpAdvice;
import com.bottomUp.domain.migration.DumpSymptom;

import java.util.List;
import java.util.Map;

/**
 * Created by raj on 09/08/2020.
 */
public interface DumpSymptomMapper {

    public void create(DumpSymptom data) throws BottomUpException;

    public void update(DumpSymptom data) throws BottomUpException;

    public DumpSymptom getByID(Long ID) throws BottomUpException;

    public DumpSymptom getByName(String name)throws BottomUpException;

    public List<DumpSymptom> getByParam(Map<String, Object> param) throws BottomUpException;

    public void delete(Map<String, Object> param) throws BottomUpException;
}
