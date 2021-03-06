package com.bottomUp.myBatis.persistence;


import com.bottomUp.common.exception.BottomUpException;

import com.bottomUp.domain.ContentDiseaseData;

import java.util.List;
import java.util.Map;

/**
 * Created by raj on 09/08/2020.
 */
public interface ContentDiseaseMapper {

    public void create(ContentDiseaseData data) throws BottomUpException;

    public void update(ContentDiseaseData data) throws BottomUpException;

    public ContentDiseaseData getByID(String ID) throws BottomUpException;

    public ContentDiseaseData getByName(String name)throws BottomUpException;

    public List<ContentDiseaseData> getByParam(Map<String, Object> param) throws BottomUpException;

    public void delete(Map<String, Object> param) throws BottomUpException;
}
