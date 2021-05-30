package com.bottomUp.myBatis.persistence;


import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.ContentVitalOptionData;

import java.util.List;
import java.util.Map;

/**
 * Created by raj on 09/08/2020.
 */
public interface ContentVitalOptionMapper {

    public void create(ContentVitalOptionData data) throws BottomUpException;

    public void update(ContentVitalOptionData data) throws BottomUpException;

    public ContentVitalOptionData  getByID(String ID) throws BottomUpException;

    public List<ContentVitalOptionData> getByParam(Map<String, Object> param) throws BottomUpException;

    public void delete(Map<String, Object> param) throws BottomUpException;

    public List<ContentVitalOptionData> getByVitalID(Long ID)throws BottomUpException;
}
