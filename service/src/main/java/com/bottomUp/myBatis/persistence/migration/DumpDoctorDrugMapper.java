package com.bottomUp.myBatis.persistence.migration;


import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.migration.DumpAdvice;
import com.bottomUp.domain.migration.DumpDoctorDrug;

import java.util.List;
import java.util.Map;

/**
 * Created by raj on 09/08/2020.
 */
public interface DumpDoctorDrugMapper {

    public void create(DumpDoctorDrug data) throws BottomUpException;

    public void update(DumpDoctorDrug data) throws BottomUpException;

    public DumpDoctorDrug getByID(Long ID) throws BottomUpException;

    public DumpDoctorDrug getByName(String name)throws BottomUpException;

    public List<DumpDoctorDrug> getByParam(Map<String, Object> param) throws BottomUpException;

    public void delete(Map<String, Object> param) throws BottomUpException;
}
