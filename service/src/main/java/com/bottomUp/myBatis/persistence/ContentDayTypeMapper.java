package com.bottomUp.myBatis.persistence;


import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.ContentDayTypeData;

import java.util.List;
import java.util.Map;

/**
 * Created by raj on 09/08/2020.
 */
public interface ContentDayTypeMapper {

    public void create(ContentDayTypeData data) throws BottomUpException;

    public void update(ContentDayTypeData data) throws BottomUpException;

    public ContentDayTypeData getByID(Long ID) throws BottomUpException;

    public List<ContentDayTypeData> getByParam(Map<String, Object> param) throws BottomUpException;

    public void delete(Map<String, Object> param) throws BottomUpException;
}
