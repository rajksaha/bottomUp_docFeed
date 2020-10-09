package com.bottomUp.myBatis.persistence;


import com.bottomUp.common.exception.BottomUpException;

import com.bottomUp.domain.PrescriptionComplainData;

import java.util.List;
import java.util.Map;

/**
 * Created by raj on 09/08/2020.
 */
public interface PrescriptionComplainMapper {

    public PrescriptionComplainData create(PrescriptionComplainData data) throws BottomUpException;

    public PrescriptionComplainData update(PrescriptionComplainData data) throws BottomUpException;

    public PrescriptionComplainData getByID(Long ID) throws BottomUpException;

    public List<PrescriptionComplainData> getByParam(Map<String, Object> param) throws BottomUpException;

    public void delete(Map<String, Object> param) throws BottomUpException;
}
