package com.bottomUp.myBatis.persistence.migration;


import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.migration.DumpAdvice;
import com.bottomUp.domain.migration.DumpVitalPrescription;

import java.util.List;
import java.util.Map;

/**
 * Created by raj on 09/08/2020.
 */
public interface DumpVitalPrescriptionMapper {

    public void create(DumpVitalPrescription data) throws BottomUpException;

    public void update(DumpVitalPrescription data) throws BottomUpException;

    public DumpVitalPrescription getByID(Long ID) throws BottomUpException;

    public DumpVitalPrescription getByName(String name)throws BottomUpException;

    public List<DumpVitalPrescription> getByParam(Map<String, Object> param) throws BottomUpException;

    public void delete(Map<String, Object> param) throws BottomUpException;
}
