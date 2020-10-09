package com.bottomUp.service.docFeed;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.AppointmentTypeData;
import com.bottomUp.domain.MenuData;
import com.bottomUp.myBatis.persistence.AppointmentTypeMapper;
import com.bottomUp.myBatis.persistence.MenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by raj on 09/08/2020.
 */

@Service
public class MenuService {

    @Autowired
    private MenuMapper menuMapper;

    public MenuData create(MenuData data) throws BottomUpException {
        return this.menuMapper.create(data);
    }

    public MenuData update(MenuData data) throws BottomUpException {
        return this.menuMapper.update(data);
    }

    public MenuData getByID(Long ID)throws BottomUpException {
        return this.menuMapper.getByID(ID);
    }

    public List<MenuData> getByParam(Map<String, Object> param) throws BottomUpException {
        return this.menuMapper.getByParam(param);
    }

    public void delete (Map<String,Object> param) throws BottomUpException {
        this.menuMapper.delete(param);
    }
}
