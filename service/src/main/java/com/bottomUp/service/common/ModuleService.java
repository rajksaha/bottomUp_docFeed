package com.bottomUp.service.common;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.common.ModuleData;
import com.bottomUp.myBatis.persistence.ModuleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by raj on 6/1/2016.
 */

@Service
public class ModuleService {

    @Autowired
    private ModuleMapper moduleMapper;

    public void create(ModuleData data) throws BottomUpException {
        moduleMapper.create(data);
    }

    public void update(ModuleData data) throws BottomUpException {
        moduleMapper.update(data);
    }

    public ModuleData getByID(String ID)throws BottomUpException {
        return this.moduleMapper.getByID(ID);
    }

    public List<ModuleData> getByParam(Map<String, Object> param) throws BottomUpException {
        return this.moduleMapper.getByParam(param);
    }

    public void delete (Map<String,Object> param) throws BottomUpException {
        this.moduleMapper.delete(param);
    }
}
