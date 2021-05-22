package com.bottomUp.service.migration;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.migration.DumpInv;
import com.bottomUp.myBatis.persistence.migration.DumpInvMapper;
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
public class DumpInvService {

    @Autowired
    private DumpInvMapper dumpInvMapper;


    public void create(DumpInv data) throws BottomUpException {
        dumpInvMapper.create(data);
    }

    public void update(DumpInv data) throws BottomUpException {
        dumpInvMapper.update(data);
    }

    public DumpInv getByID(Long ID)throws BottomUpException {
        return this.dumpInvMapper.getByID(ID);
    }

    public DumpInv getByName(String name)throws BottomUpException {
        return this.dumpInvMapper.getByName(name);
    }

    public List<DumpInv> getByParam(Map<String, Object> param) throws BottomUpException {
        return this.dumpInvMapper.getByParam(param);
    }

    public void delete (Map<String,Object> param) throws BottomUpException {
        this.dumpInvMapper.delete(param);
    }
}
