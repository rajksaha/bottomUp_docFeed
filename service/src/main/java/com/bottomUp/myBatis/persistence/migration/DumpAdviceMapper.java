package com.bottomUp.myBatis.persistence.migration;


import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.ContentDiseaseData;
import com.bottomUp.domain.migration.DumpAdvice;

import java.util.List;
import java.util.Map;

/**
 * Created by raj on 09/08/2020.
 */
public interface DumpAdviceMapper {

    public void create(DumpAdvice data) throws BottomUpException;

    public void update(DumpAdvice data) throws BottomUpException;

    public DumpAdvice getByID(Long ID) throws BottomUpException;

    public DumpAdvice getByName(String name)throws BottomUpException;

    public List<DumpAdvice> getByParam(Map<String, Object> param) throws BottomUpException;

    public void delete(Map<String, Object> param) throws BottomUpException;
}
