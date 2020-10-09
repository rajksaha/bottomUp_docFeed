package com.bottomUp.myBatis.persistence;


import com.bottomUp.common.exception.BottomUpException;

import com.bottomUp.domain.ContentDrugAdviceData;

import java.util.List;
import java.util.Map;

/**
 * Created by raj on 09/08/2020.
 */
public interface ContentDrugAdviceMapper {

    public ContentDrugAdviceData create(ContentDrugAdviceData data) throws BottomUpException;

    public ContentDrugAdviceData update(ContentDrugAdviceData data) throws BottomUpException;

    public ContentDrugAdviceData getByID(Long ID) throws BottomUpException;

    public List<ContentDrugAdviceData> getByParam(Map<String, Object> param) throws BottomUpException;

    public void delete(Map<String, Object> param) throws BottomUpException;
}
