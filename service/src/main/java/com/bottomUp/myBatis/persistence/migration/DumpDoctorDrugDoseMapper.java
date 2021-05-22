package com.bottomUp.myBatis.persistence.migration;


import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.migration.DumpAdvice;
import com.bottomUp.domain.migration.DumpDoctorDrugDose;

import java.util.List;
import java.util.Map;

/**
 * Created by raj on 09/08/2020.
 */
public interface DumpDoctorDrugDoseMapper {

    public void create(DumpDoctorDrugDose data) throws BottomUpException;

    public void update(DumpDoctorDrugDose data) throws BottomUpException;

    public DumpDoctorDrugDose getByID(Long ID) throws BottomUpException;

    public DumpDoctorDrugDose getByName(String name)throws BottomUpException;

    public List<DumpDoctorDrugDose> getByParam(Map<String, Object> param) throws BottomUpException;

    public void delete(Map<String, Object> param) throws BottomUpException;
}
