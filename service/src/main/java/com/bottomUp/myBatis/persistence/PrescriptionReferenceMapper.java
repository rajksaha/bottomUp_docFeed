package com.bottomUp.myBatis.persistence;


import com.bottomUp.common.exception.BottomUpException;

import com.bottomUp.domain.PrescriptionReferenceData;

import java.util.List;
import java.util.Map;

/**
 * Created by raj on 09/08/2020.
 */
public interface PrescriptionReferenceMapper {

    public PrescriptionReferenceData create(PrescriptionReferenceData data) throws BottomUpException;

    public PrescriptionReferenceData update(PrescriptionReferenceData data) throws BottomUpException;

    public PrescriptionReferenceData getByID(Long ID) throws BottomUpException;

    public List<PrescriptionReferenceData> getByParam(Map<String, Object> param) throws BottomUpException;

    public void delete(Map<String, Object> param) throws BottomUpException;
}
