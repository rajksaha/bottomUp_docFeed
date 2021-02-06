package com.bottomUp.myBatis.persistence;


import com.bottomUp.common.exception.BottomUpException;

import com.bottomUp.domain.PrescriptionHistoryData;

import java.util.List;
import java.util.Map;

/**
 * Created by raj on 09/08/2020.
 */
public interface PrescriptionHistoryMapper {

    public void create(PrescriptionHistoryData data) throws BottomUpException;

    public void selectInsert(Map<String, Object> param) throws BottomUpException;

    public void update(PrescriptionHistoryData data) throws BottomUpException;

    public PrescriptionHistoryData getByID(Long ID) throws BottomUpException;

    public List<PrescriptionHistoryData> getByParam(Map<String, Object> param) throws BottomUpException;

    public void delete(Map<String, Object> param) throws BottomUpException;
}
