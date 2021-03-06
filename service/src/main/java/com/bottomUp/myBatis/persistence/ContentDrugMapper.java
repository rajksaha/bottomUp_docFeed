package com.bottomUp.myBatis.persistence;


import com.bottomUp.common.exception.BottomUpException;

import com.bottomUp.domain.ContentDrugData;

import java.util.List;
import java.util.Map;

/**
 * Created by raj on 09/08/2020.
 */
public interface ContentDrugMapper {

    public void create(ContentDrugData data) throws BottomUpException;

    public void update(ContentDrugData data) throws BottomUpException;

    public void updateGeneric(Map<String, Object> param) throws BottomUpException;

    public ContentDrugData getByID(String ID) throws BottomUpException;

    public ContentDrugData getByName(String name) throws BottomUpException;

    public List<ContentDrugData> getByParam(Map<String, Object> param) throws BottomUpException;

    public Integer getCountByParam(Map<String, Object> param) throws BottomUpException;

    public void delete(Map<String, Object> param) throws BottomUpException;
}
