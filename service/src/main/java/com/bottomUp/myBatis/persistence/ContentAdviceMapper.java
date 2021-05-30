package com.bottomUp.myBatis.persistence;


import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.AppointmentTypeData;
import com.bottomUp.domain.ContentAdviceData;
import com.bottomUp.domain.ContentSymptomData;

import java.util.List;
import java.util.Map;

/**
 * Created by raj on 09/08/2020.
 */
public interface ContentAdviceMapper {

    public void create(ContentAdviceData data) throws BottomUpException;

    public void update(ContentAdviceData data) throws BottomUpException;

    public ContentAdviceData getByID(String ID) throws BottomUpException;

    public ContentAdviceData getByName(String symptomName)throws BottomUpException;

    public List<ContentAdviceData> getByParam(Map<String, Object> param) throws BottomUpException;

    public void delete(Map<String, Object> param) throws BottomUpException;
}
