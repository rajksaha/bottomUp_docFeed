package com.bottomUp.myBatis.persistence;


import com.bottomUp.common.exception.BottomUpException;

import com.bottomUp.domain.PrescriptionAdviceData;

import java.util.List;
import java.util.Map;

/**
 * Created by raj on 09/08/2020.
 */
public interface PrescriptionAdviceMapper {

    public void create(PrescriptionAdviceData data) throws BottomUpException;

    public void selectInsert(Map<String, Object> param) throws BottomUpException;

    public void update(PrescriptionAdviceData data) throws BottomUpException;

    public PrescriptionAdviceData getByID(Long ID) throws BottomUpException;

    public List<PrescriptionAdviceData> getByParam(Map<String, Object> param) throws BottomUpException;

    public void delete(Map<String, Object> param) throws BottomUpException;
}
