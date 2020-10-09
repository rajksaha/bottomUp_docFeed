package com.bottomUp.myBatis.persistence;


import com.bottomUp.common.exception.BottomUpException;

import com.bottomUp.domain.InvReportData;

import java.util.List;
import java.util.Map;

/**
 * Created by raj on 09/08/2020.
 */
public interface InvReportMapper {

    public InvReportData create(InvReportData data) throws BottomUpException;

    public InvReportData update(InvReportData data) throws BottomUpException;

    public InvReportData getByID(Long ID) throws BottomUpException;

    public List<InvReportData> getByParam(Map<String, Object> param) throws BottomUpException;

    public void delete(Map<String, Object> param) throws BottomUpException;
}
