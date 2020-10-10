package com.bottomUp.myBatis.persistence;


import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.AppointmentData;
import com.bottomUp.domain.ContentSymptomData;

import java.util.List;
import java.util.Map;

/**
 * Created by raj on 09/08/2020.
 */
public interface ContentSymptomMapper {

    public void create(ContentSymptomData data) throws BottomUpException;

    public void update(ContentSymptomData  data) throws BottomUpException;

    public ContentSymptomData  getByID(Long ID) throws BottomUpException;

    public List<ContentSymptomData > getByParam(Map<String, Object> param) throws BottomUpException;

    public void delete(Map<String, Object> param) throws BottomUpException;
}
