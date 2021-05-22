package com.bottomUp.myBatis.persistence.migration;


import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.migration.DumpAdvice;
import com.bottomUp.domain.migration.DumpPrescriptionAdvice;

import java.util.List;
import java.util.Map;

/**
 * Created by raj on 09/08/2020.
 */
public interface DumpPrescriptionAdviceMapper {

    public void create(DumpPrescriptionAdvice data) throws BottomUpException;

    public void update(DumpPrescriptionAdvice data) throws BottomUpException;

    public DumpPrescriptionAdvice getByID(Long ID) throws BottomUpException;

    public DumpPrescriptionAdvice getByName(String name)throws BottomUpException;

    public List<DumpPrescriptionAdvice> getByParam(Map<String, Object> param) throws BottomUpException;

    public void delete(Map<String, Object> param) throws BottomUpException;
}
