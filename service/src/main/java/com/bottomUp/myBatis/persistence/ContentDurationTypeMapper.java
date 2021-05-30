package com.bottomUp.myBatis.persistence;


import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.ContentDurationTypeData;

import java.util.List;
import java.util.Map;

/**
 * Created by raj on 09/08/2020.
 */
public interface ContentDurationTypeMapper {

    public void create(ContentDurationTypeData data) throws BottomUpException;

    public void update(ContentDurationTypeData data) throws BottomUpException;

    public ContentDurationTypeData getByID(String ID) throws BottomUpException;

    public List<ContentDurationTypeData> getByParam(Map<String, Object> param) throws BottomUpException;

    public void delete(Map<String, Object> param) throws BottomUpException;
}
