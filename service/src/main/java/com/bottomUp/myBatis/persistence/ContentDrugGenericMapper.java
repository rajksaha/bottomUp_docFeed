package com.bottomUp.myBatis.persistence;


import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.ContentDrugGenericData;

import java.util.List;
import java.util.Map;

/**
 * Created by raj on 09/08/2020.
 */
public interface ContentDrugGenericMapper {

    public void create(ContentDrugGenericData data) throws BottomUpException;

    public void update(ContentDrugGenericData data) throws BottomUpException;

    public ContentDrugGenericData getByID(Long ID) throws BottomUpException;

    public ContentDrugGenericData getByName(String name) throws BottomUpException;

    public List<ContentDrugGenericData> getByParam(Map<String, Object> param) throws BottomUpException;

    public void delete(Map<String, Object> param) throws BottomUpException;
}
