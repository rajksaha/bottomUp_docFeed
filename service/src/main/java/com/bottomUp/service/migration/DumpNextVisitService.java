package com.bottomUp.service.migration;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.migration.DumpNextVisit;
import com.bottomUp.myBatis.persistence.migration.DumpNextVisitMapper;
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
public class DumpNextVisitService {

    @Autowired
    private DumpNextVisitMapper dumpNextVisitMapper;


    public void create(DumpNextVisit data) throws BottomUpException {
        dumpNextVisitMapper.create(data);
    }

    public void update(DumpNextVisit data) throws BottomUpException {
        dumpNextVisitMapper.update(data);
    }

    public DumpNextVisit getByID(Long ID)throws BottomUpException {
        return this.dumpNextVisitMapper.getByID(ID);
    }

    public DumpNextVisit getByName(String name)throws BottomUpException {
        return this.dumpNextVisitMapper.getByName(name);
    }

    public List<DumpNextVisit> getByParam(Map<String, Object> param) throws BottomUpException {
        return this.dumpNextVisitMapper.getByParam(param);
    }

    public void delete (Map<String,Object> param) throws BottomUpException {
        this.dumpNextVisitMapper.delete(param);
    }
}
