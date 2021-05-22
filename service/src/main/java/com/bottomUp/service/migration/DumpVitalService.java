package com.bottomUp.service.migration;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.migration.DumpVital;
import com.bottomUp.myBatis.persistence.migration.DumpVitalMapper;
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
public class DumpVitalService {

    @Autowired
    private DumpVitalMapper dumpVitalMapper;


    public void create(DumpVital data) throws BottomUpException {
        dumpVitalMapper.create(data);
    }

    public void update(DumpVital data) throws BottomUpException {
        dumpVitalMapper.update(data);
    }

    public DumpVital getByID(Long ID)throws BottomUpException {
        return this.dumpVitalMapper.getByID(ID);
    }

    public DumpVital getByName(String name)throws BottomUpException {
        return this.dumpVitalMapper.getByName(name);
    }

    public List<DumpVital> getByParam(Map<String, Object> param) throws BottomUpException {
        return this.dumpVitalMapper.getByParam(param);
    }

    public void delete (Map<String,Object> param) throws BottomUpException {
        this.dumpVitalMapper.delete(param);
    }
}
