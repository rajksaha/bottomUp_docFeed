package com.bottomUp.myBatis.persistence.migration;


import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.migration.DumpAdvice;
import com.bottomUp.domain.migration.DumpPrescriptionFamilyDisease;

import java.util.List;
import java.util.Map;

/**
 * Created by raj on 09/08/2020.
 */
public interface DumpPrescriptionFamilyDiseaseMapper {

    public void create(DumpPrescriptionFamilyDisease data) throws BottomUpException;

    public void update(DumpPrescriptionFamilyDisease data) throws BottomUpException;

    public DumpPrescriptionFamilyDisease getByID(Long ID) throws BottomUpException;

    public DumpPrescriptionFamilyDisease getByName(String name)throws BottomUpException;

    public List<DumpPrescriptionFamilyDisease> getByParam(Map<String, Object> param) throws BottomUpException;

    public void delete(Map<String, Object> param) throws BottomUpException;
}
