package com.bottomUp.myBatis.persistence;


import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.AppointmentData;
import com.bottomUp.domain.ContentRelationData;

import java.util.List;
import java.util.Map;

/**
 * Created by raj on 09/08/2020.
 */
public interface ContentRelationMapper {

    public void create(ContentRelationData data) throws BottomUpException;

    public void update(ContentRelationData data) throws BottomUpException;

    public ContentRelationData getByID(Long ID) throws BottomUpException;

    public List<ContentRelationData> getByParam(Map<String, Object> param) throws BottomUpException;

    public void delete(Map<String, Object> param) throws BottomUpException;
}
