package com.bottomUp.myBatis.persistence;


import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.AppointmentData;
import com.bottomUp.domain.ContentVitalData;

import java.util.List;
import java.util.Map;

/**
 * Created by raj on 09/08/2020.
 */
public interface ContentVitalMapper {

    public ContentVitalData create(ContentVitalData data) throws BottomUpException;

    public ContentVitalData update(ContentVitalData data) throws BottomUpException;

    public ContentVitalData getByID(Long ID) throws BottomUpException;

    public List<ContentVitalData> getByParam(Map<String, Object> param) throws BottomUpException;

    public void delete(Map<String, Object> param) throws BottomUpException;
}
