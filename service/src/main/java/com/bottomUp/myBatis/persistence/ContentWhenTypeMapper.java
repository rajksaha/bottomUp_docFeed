package com.bottomUp.myBatis.persistence;


import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.AppointmentData;
import com.bottomUp.domain.ContentWhenTypeData;

import java.util.List;
import java.util.Map;

/**
 * Created by raj on 09/08/2020.
 */
public interface ContentWhenTypeMapper {

    public ContentWhenTypeData create(ContentWhenTypeData data) throws BottomUpException;

    public ContentWhenTypeData update(ContentWhenTypeData  data) throws BottomUpException;

    public ContentWhenTypeData  getByID(Long ID) throws BottomUpException;

    public List<ContentWhenTypeData > getByParam(Map<String, Object> param) throws BottomUpException;

    public void delete(Map<String, Object> param) throws BottomUpException;
}
