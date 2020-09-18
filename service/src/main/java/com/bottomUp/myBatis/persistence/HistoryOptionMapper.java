package com.bottomUp.myBatis.persistence;


import com.bottomUp.common.exception.BottomUpException;

import com.bottomUp.domain.HistoryOptionData;

import java.util.List;
import java.util.Map;

/**
 * Created by raj on 09/08/2020.
 */
public interface HistoryOptionMapper {

    public void create(HistoryOptionData data) throws BottomUpException;

    public void update(HistoryOptionData data) throws BottomUpException;

    public HistoryOptionData getByID(Long ID) throws BottomUpException;

    public List<HistoryOptionData> getByParam(Map<String, Object> param) throws BottomUpException;

    public void delete(Map<String, Object> param) throws BottomUpException;
}
