package com.bottomUp.myBatis.persistence;


import com.bottomUp.common.exception.BottomUpException;

import com.bottomUp.domain.InvReportDateData;

import java.util.List;
import java.util.Map;

/**
 * Created by raj on 09/08/2020.
 */
public interface InvReportDateMapper {

    public void create(InvReportDateData data) throws BottomUpException;

    public void update(InvReportDateData data) throws BottomUpException;

    public InvReportDateData getByID(String ID) throws BottomUpException;

    public List<InvReportDateData> getByParam(Map<String, Object> param) throws BottomUpException;

    public void delete(Map<String, Object> param) throws BottomUpException;
}
