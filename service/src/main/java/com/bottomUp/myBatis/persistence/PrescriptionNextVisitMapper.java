package com.bottomUp.myBatis.persistence;


import com.bottomUp.common.exception.BottomUpException;

import com.bottomUp.domain.PrescriptionNextVisitData;

import java.util.List;
import java.util.Map;

/**
 * Created by raj on 09/08/2020.
 */
public interface PrescriptionNextVisitMapper {

    public void create(PrescriptionNextVisitData data) throws BottomUpException;

    public void update(PrescriptionNextVisitData data) throws BottomUpException;

    public PrescriptionNextVisitData getByID(String ID) throws BottomUpException;

    public List<PrescriptionNextVisitData> getByParam(Map<String, Object> param) throws BottomUpException;

    public void delete(Map<String, Object> param) throws BottomUpException;
}
