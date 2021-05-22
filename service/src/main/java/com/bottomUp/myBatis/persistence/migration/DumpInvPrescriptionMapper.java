package com.bottomUp.myBatis.persistence.migration;


import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.migration.DumpAdvice;
import com.bottomUp.domain.migration.DumpInvPrescription;

import java.util.List;
import java.util.Map;

/**
 * Created by raj on 09/08/2020.
 */
public interface DumpInvPrescriptionMapper {

    public void create(DumpInvPrescription data) throws BottomUpException;

    public void update(DumpInvPrescription data) throws BottomUpException;

    public DumpInvPrescription getByID(Long ID) throws BottomUpException;

    public DumpInvPrescription getByName(String name)throws BottomUpException;

    public List<DumpInvPrescription> getByParam(Map<String, Object> param) throws BottomUpException;

    public void delete(Map<String, Object> param) throws BottomUpException;
}
