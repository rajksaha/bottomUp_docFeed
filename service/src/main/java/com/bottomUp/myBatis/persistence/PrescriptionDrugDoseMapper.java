package com.bottomUp.myBatis.persistence;


import com.bottomUp.common.exception.BottomUpException;

import com.bottomUp.domain.PrescriptionDrugDoseData;

import java.util.List;
import java.util.Map;

/**
 * Created by raj on 09/08/2020.
 */
public interface PrescriptionDrugDoseMapper {

    public PrescriptionDrugDoseData create(PrescriptionDrugDoseData data) throws BottomUpException;

    public PrescriptionDrugDoseData update(PrescriptionDrugDoseData data) throws BottomUpException;

    public PrescriptionDrugDoseData getByID(Long ID) throws BottomUpException;

    public List<PrescriptionDrugDoseData> getByParam(Map<String, Object> param) throws BottomUpException;

    public void delete(Map<String, Object> param) throws BottomUpException;
}
