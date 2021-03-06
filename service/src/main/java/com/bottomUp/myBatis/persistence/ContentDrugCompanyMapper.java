package com.bottomUp.myBatis.persistence;


import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.AppointmentData;
import com.bottomUp.domain.ContentDrugCompanyData;

import java.util.List;
import java.util.Map;

/**
 * Created by raj on 09/08/2020.
 */
public interface ContentDrugCompanyMapper {

    public void create(ContentDrugCompanyData data) throws BottomUpException;

    public void update(ContentDrugCompanyData data) throws BottomUpException;

    public ContentDrugCompanyData getByID(String ID) throws BottomUpException;

    public List<ContentDrugCompanyData> getByParam(Map<String, Object> param) throws BottomUpException;

    public void delete(Map<String, Object> param) throws BottomUpException;
}
