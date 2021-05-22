package com.bottomUp.myBatis.persistence.migration;


import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.migration.DumpAdvice;
import com.bottomUp.domain.migration.DumpPrescriptionReference;

import java.util.List;
import java.util.Map;

/**
 * Created by raj on 09/08/2020.
 */
public interface DumpPrescriptionReferenceMapper {

    public void create(DumpPrescriptionReference data) throws BottomUpException;

    public void update(DumpPrescriptionReference data) throws BottomUpException;

    public DumpPrescriptionReference getByID(Long ID) throws BottomUpException;

    public DumpPrescriptionReference getByName(String name)throws BottomUpException;

    public List<DumpPrescriptionReference> getByParam(Map<String, Object> param) throws BottomUpException;

    public void delete(Map<String, Object> param) throws BottomUpException;
}
