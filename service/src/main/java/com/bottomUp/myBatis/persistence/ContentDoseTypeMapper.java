package com.bottomUp.myBatis.persistence;


import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.ContentDoseTypeData;

import java.util.List;
import java.util.Map;

/**
 * Created by raj on 09/08/2020.
 */
public interface ContentDoseTypeMapper {

    public void create(ContentDoseTypeData data) throws BottomUpException;

    public void update(ContentDoseTypeData data) throws BottomUpException;

    public ContentDoseTypeData  getByID(String ID) throws BottomUpException;

    public List<ContentDoseTypeData> getByParam(Map<String, Object> param) throws BottomUpException;

    public void delete(Map<String, Object> param) throws BottomUpException;
}
