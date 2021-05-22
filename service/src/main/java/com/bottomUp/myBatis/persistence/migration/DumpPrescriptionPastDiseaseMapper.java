package com.bottomUp.myBatis.persistence.migration;


import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.migration.DumpAdvice;
import com.bottomUp.domain.migration.DumpPrescriptionPastDisease;

import java.util.List;
import java.util.Map;

/**
 * Created by raj on 09/08/2020.
 */
public interface DumpPrescriptionPastDiseaseMapper {

    public void create(DumpPrescriptionPastDisease data) throws BottomUpException;

    public void update(DumpPrescriptionPastDisease data) throws BottomUpException;

    public DumpPrescriptionPastDisease getByID(Long ID) throws BottomUpException;

    public DumpPrescriptionPastDisease getByName(String name)throws BottomUpException;

    public List<DumpPrescriptionPastDisease> getByParam(Map<String, Object> param) throws BottomUpException;

    public void delete(Map<String, Object> param) throws BottomUpException;
}
