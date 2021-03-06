package com.bottomUp.myBatis.persistence;


import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.DrugDefaultSetupData;

import java.util.List;
import java.util.Map;

/**
 * Created by raj on 09/08/2020.
 */
public interface DrugDefaultSetupMapper {

    public void create(DrugDefaultSetupData data) throws BottomUpException;

    public void update(DrugDefaultSetupData data) throws BottomUpException;

    public DrugDefaultSetupData getByID(String ID) throws BottomUpException;

    public DrugDefaultSetupData getSingleByParam(Map<String, Object> param) throws BottomUpException;

    public List<DrugDefaultSetupData> getByParam(Map<String, Object> param) throws BottomUpException;

    public void delete(Map<String, Object> param) throws BottomUpException;
}
