package com.bottomUp.myBatis.persistence.migration;


import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.migration.DumpAdvice;
import com.bottomUp.domain.migration.DumpHistoryPrescription;

import java.util.List;
import java.util.Map;

/**
 * Created by raj on 09/08/2020.
 */
public interface DumpHistoryPrescriptionMapper {

    public void create(DumpHistoryPrescription data) throws BottomUpException;

    public void update(DumpHistoryPrescription data) throws BottomUpException;

    public DumpHistoryPrescription getByID(Long ID) throws BottomUpException;

    public DumpHistoryPrescription getByName(String name)throws BottomUpException;

    public List<DumpHistoryPrescription> getByParam(Map<String, Object> param) throws BottomUpException;

    public void delete(Map<String, Object> param) throws BottomUpException;
}
