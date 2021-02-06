package com.bottomUp.myBatis.persistence;


import com.bottomUp.common.exception.BottomUpException;

import com.bottomUp.domain.PrescriptionDrugData;

import java.util.List;
import java.util.Map;

/**
 * Created by raj on 09/08/2020.
 */
public interface PrescriptionDrugMapper {

    public void create(PrescriptionDrugData data) throws BottomUpException;

    public void selectInsert(Map<String, Object> param) throws BottomUpException;

    public void update(PrescriptionDrugData data) throws BottomUpException;

    public PrescriptionDrugData getByID(Long ID) throws BottomUpException;

    public List<PrescriptionDrugData> getByParam(Map<String, Object> param) throws BottomUpException;

    public List<PrescriptionDrugData> getSimpleByParam(Map<String, Object> param) throws BottomUpException;

    public void delete(Map<String, Object> param) throws BottomUpException;
}
