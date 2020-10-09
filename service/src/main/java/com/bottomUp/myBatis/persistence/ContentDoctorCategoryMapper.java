package com.bottomUp.myBatis.persistence;


import com.bottomUp.common.exception.BottomUpException;

import com.bottomUp.domain.ContentDoctorCategoryData;

import java.util.List;
import java.util.Map;

/**
 * Created by raj on 09/08/2020.
 */
public interface ContentDoctorCategoryMapper {

    public ContentDoctorCategoryData create(ContentDoctorCategoryData data) throws BottomUpException;

    public ContentDoctorCategoryData update(ContentDoctorCategoryData data) throws BottomUpException;

    public ContentDoctorCategoryData getByID(Long ID) throws BottomUpException;

    public List<ContentDoctorCategoryData> getByParam(Map<String, Object> param) throws BottomUpException;

    public void delete(Map<String, Object> param) throws BottomUpException;
}
