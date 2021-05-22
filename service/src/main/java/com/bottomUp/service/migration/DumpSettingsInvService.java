package com.bottomUp.service.migration;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.migration.DumpSettingsInv;
import com.bottomUp.myBatis.persistence.migration.DumpSettingsInvMapper;
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
public class DumpSettingsInvService {

    @Autowired
    private DumpSettingsInvMapper dumpSettingsInvMapper;


    public void create(DumpSettingsInv data) throws BottomUpException {
        dumpSettingsInvMapper.create(data);
    }

    public void update(DumpSettingsInv data) throws BottomUpException {
        dumpSettingsInvMapper.update(data);
    }

    public DumpSettingsInv getByID(Long ID)throws BottomUpException {
        return this.dumpSettingsInvMapper.getByID(ID);
    }

    public DumpSettingsInv getByName(String name)throws BottomUpException {
        return this.dumpSettingsInvMapper.getByName(name);
    }

    public List<DumpSettingsInv> getByParam(Map<String, Object> param) throws BottomUpException {
        return this.dumpSettingsInvMapper.getByParam(param);
    }

    public void delete (Map<String,Object> param) throws BottomUpException {
        this.dumpSettingsInvMapper.delete(param);
    }
}
