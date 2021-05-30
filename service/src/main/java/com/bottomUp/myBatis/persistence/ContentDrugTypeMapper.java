package com.bottomUp.myBatis.persistence;


import com.bottomUp.common.exception.BottomUpException;

import com.bottomUp.domain.ContentDrugTypeData;

import java.util.List;
import java.util.Map;

/**
 * Created by raj on 09/08/2020.
 */
public interface ContentDrugTypeMapper {

    public void create(ContentDrugTypeData data) throws BottomUpException;

    public void update(ContentDrugTypeData data) throws BottomUpException;

    public ContentDrugTypeData getByID(String ID) throws BottomUpException;

    public List<ContentDrugTypeData> getByParam(Map<String, Object> param) throws BottomUpException;

    public void delete(Map<String, Object> param) throws BottomUpException;
}
