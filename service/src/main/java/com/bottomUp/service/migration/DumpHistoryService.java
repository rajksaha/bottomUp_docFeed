package com.bottomUp.service.migration;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.migration.DumpHistory;
import com.bottomUp.myBatis.persistence.migration.DumpHistoryMapper;
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
public class DumpHistoryService {

    @Autowired
    private DumpHistoryMapper dumpHistoryMapper;


    public void create(DumpHistory data) throws BottomUpException {
        dumpHistoryMapper.create(data);
    }

    public void update(DumpHistory data) throws BottomUpException {
        dumpHistoryMapper.update(data);
    }

    public DumpHistory getByID(Long ID)throws BottomUpException {
        return this.dumpHistoryMapper.getByID(ID);
    }

    public DumpHistory getByName(String name)throws BottomUpException {
        return this.dumpHistoryMapper.getByName(name);
    }

    public List<DumpHistory> getByParam(Map<String, Object> param) throws BottomUpException {
        return this.dumpHistoryMapper.getByParam(param);
    }

    public void delete (Map<String,Object> param) throws BottomUpException {
        this.dumpHistoryMapper.delete(param);
    }
}
