package com.bottomUp.myBatis.persistence;


import com.bottomUp.common.exception.BottomUpException;

import com.bottomUp.domain.HistoryData;

import java.util.List;
import java.util.Map;

/**
 * Created by raj on 09/08/2020.
 */
public interface HistoryMapper {

    public HistoryData create(HistoryData data) throws BottomUpException;

    public HistoryData update(HistoryData data) throws BottomUpException;

    public HistoryData getByID(Long ID) throws BottomUpException;

    public List<HistoryData> getByParam(Map<String, Object> param) throws BottomUpException;

    public void delete(Map<String, Object> param) throws BottomUpException;
}
