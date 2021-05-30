package com.bottomUp.myBatis.persistence;


import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.AppointmentData;
import com.bottomUp.domain.ContentInvData;

import java.util.List;
import java.util.Map;

/**
 * Created by raj on 09/08/2020.
 */
public interface ContentInvMapper {

    public void create(ContentInvData data) throws BottomUpException;

    public void update(ContentInvData data) throws BottomUpException;

    public ContentInvData getByID(String ID) throws BottomUpException;

    public ContentInvData getByName(String name) throws BottomUpException;

    public List<ContentInvData> getByParam(Map<String, Object> param) throws BottomUpException;

    public void delete(Map<String, Object> param) throws BottomUpException;
}
