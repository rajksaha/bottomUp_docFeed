package com.bottomUp.myBatis.persistence;


import com.bottomUp.common.exception.BottomUpException;

import com.bottomUp.domain.MenuData;

import java.util.List;
import java.util.Map;

/**
 * Created by raj on 09/08/2020.
 */
public interface MenuMapper {

    public void create(MenuData data) throws BottomUpException;

    public void update(MenuData data) throws BottomUpException;

    public MenuData getByID(String ID) throws BottomUpException;

    public List<MenuData> getByParam(Map<String, Object> param) throws BottomUpException;

    public void delete(Map<String, Object> param) throws BottomUpException;
}
