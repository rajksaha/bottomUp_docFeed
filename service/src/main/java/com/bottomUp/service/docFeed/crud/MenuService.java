package com.bottomUp.service.docFeed.crud;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.AppointmentTypeData;
import com.bottomUp.domain.MenuData;
import com.bottomUp.myBatis.persistence.AppointmentTypeMapper;
import com.bottomUp.myBatis.persistence.MenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * Created by raj on 09/08/2020.
 */

@Service
@Transactional
public class MenuService {

    @Autowired
    private MenuMapper menuMapper;

    public void create(MenuData data) throws BottomUpException {
        if(data.getFunctionName().equals("HISTORY")){
            data.setMenuURL("#/history?historyType=" + data.getDefaultName());
        }
        menuMapper.create(data);
    }

    public void update(MenuData data) throws BottomUpException {
        menuMapper.update(data);
    }

    public MenuData getByID(String ID)throws BottomUpException {
        return this.menuMapper.getByID(ID);
    }

    public List<MenuData> getByParam(Map<String, Object> param) throws BottomUpException {
        return this.menuMapper.getByParam(param);
    }

    public void delete (Map<String,Object> param) throws BottomUpException {
        this.menuMapper.delete(param);
    }
}
