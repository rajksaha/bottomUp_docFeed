package com.bottomUp.myBatis.persistence;


import com.bottomUp.common.exception.BottomUpException;

import com.bottomUp.domain.MenuSettingData;

import java.util.List;
import java.util.Map;

/**
 * Created by raj on 09/08/2020.
 */
public interface MenuSettingMapper {

    public void create(MenuSettingData data) throws BottomUpException;

    public void update(MenuSettingData data) throws BottomUpException;

    public MenuSettingData getByID(String ID) throws BottomUpException;

    public List<MenuSettingData> getByParam(Map<String, Object> param) throws BottomUpException;

    public void delete(Map<String, Object> param) throws BottomUpException;
}
