package com.bottomUp.myBatis.persistence;


import com.bottomUp.common.exception.BottomUpException;

import com.bottomUp.domain.PrescriptionVitalData;

import java.util.List;
import java.util.Map;

/**
 * Created by raj on 09/08/2020.
 */
public interface PrescriptionVitalMapper {

    public PrescriptionVitalData create(PrescriptionVitalData data) throws BottomUpException;

    public PrescriptionVitalData update(PrescriptionVitalData data) throws BottomUpException;

    public PrescriptionVitalData getByID(Long ID) throws BottomUpException;

    public List<PrescriptionVitalData> getByParam(Map<String, Object> param) throws BottomUpException;

    public void delete(Map<String, Object> param) throws BottomUpException;
}
