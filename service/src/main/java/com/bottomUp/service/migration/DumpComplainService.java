package com.bottomUp.service.migration;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.migration.DumpComplain;
import com.bottomUp.myBatis.persistence.migration.DumpComplainMapper;
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
public class DumpComplainService {

    @Autowired
    private DumpComplainMapper dumpComplainMapper;


    public void create(DumpComplain data) throws BottomUpException {
        dumpComplainMapper.create(data);
    }

    public void update(DumpComplain data) throws BottomUpException {
        dumpComplainMapper.update(data);
    }

    public DumpComplain getByID(Long ID)throws BottomUpException {
        return this.dumpComplainMapper.getByID(ID);
    }

    public DumpComplain getByName(String name)throws BottomUpException {
        return this.dumpComplainMapper.getByName(name);
    }

    public List<DumpComplain> getByParam(Map<String, Object> param) throws BottomUpException {
        return this.dumpComplainMapper.getByParam(param);
    }

    public void delete (Map<String,Object> param) throws BottomUpException {
        this.dumpComplainMapper.delete(param);
    }
}
