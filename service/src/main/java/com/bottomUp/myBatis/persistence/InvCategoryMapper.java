package com.bottomUp.myBatis.persistence;


import com.bottomUp.common.exception.BottomUpException;

import com.bottomUp.domain.InvCategoryData;

import java.util.List;
import java.util.Map;

/**
 * Created by raj on 09/08/2020.
 */
public interface InvCategoryMapper {

    public void create(InvCategoryData data) throws BottomUpException;

    public void update(InvCategoryData data) throws BottomUpException;

    public InvCategoryData getByID(Long ID) throws BottomUpException;

    public List<InvCategoryData> getByParam(Map<String, Object> param) throws BottomUpException;

    public void delete(Map<String, Object> param) throws BottomUpException;
}
