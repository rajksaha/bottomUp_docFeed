package com.bottomUp.service.docFeed.crud;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.MenuSettingData;
import com.bottomUp.myBatis.persistence.MenuSettingMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by raj on 09/08/2020.
 */

@Service
public class MenuSettingService {

    @Autowired
    private MenuSettingMapper menuSettingMapper;

    public void create(MenuSettingData data) throws BottomUpException {
        menuSettingMapper.create(data);
    }

    public void update(MenuSettingData data) throws BottomUpException {
        menuSettingMapper.update(data);
    }

    public MenuSettingData getByID(Long ID)throws BottomUpException {
        return this.menuSettingMapper.getByID(ID);
    }

    public List<MenuSettingData> getByParam(Map<String, Object> param) throws BottomUpException {
        return this.menuSettingMapper.getByParam(param);
    }

    public void delete (Map<String,Object> param) throws BottomUpException {
        this.menuSettingMapper.delete(param);
    }
}
