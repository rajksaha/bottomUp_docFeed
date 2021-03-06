package com.bottomUp.myBatis.persistence.migration;


import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.migration.DumpAdvice;
import com.bottomUp.domain.migration.DumpDrugPrescription;

import java.util.List;
import java.util.Map;

/**
 * Created by raj on 09/08/2020.
 */
public interface DumpDrugPrescriptionMapper {

    public void create(DumpDrugPrescription data) throws BottomUpException;

    public void update(DumpDrugPrescription data) throws BottomUpException;

    public DumpDrugPrescription getByID(Long ID) throws BottomUpException;

    public DumpDrugPrescription getByName(String name)throws BottomUpException;

    public List<DumpDrugPrescription> getByParam(Map<String, Object> param) throws BottomUpException;

    public void delete(Map<String, Object> param) throws BottomUpException;
}
