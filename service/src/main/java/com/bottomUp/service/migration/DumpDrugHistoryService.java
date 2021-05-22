package com.bottomUp.service.migration;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.migration.DumpDrugHistory;
import com.bottomUp.myBatis.persistence.migration.DumpDrugHistoryMapper;
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
public class DumpDrugHistoryService {

    @Autowired
    private DumpDrugHistoryMapper dumpDrugHistoryMapper;


    public void create(DumpDrugHistory data) throws BottomUpException {
        dumpDrugHistoryMapper.create(data);
    }

    public void update(DumpDrugHistory data) throws BottomUpException {
        dumpDrugHistoryMapper.update(data);
    }

    public DumpDrugHistory getByID(Long ID)throws BottomUpException {
        return this.dumpDrugHistoryMapper.getByID(ID);
    }

    public DumpDrugHistory getByName(String name)throws BottomUpException {
        return this.dumpDrugHistoryMapper.getByName(name);
    }

    public List<DumpDrugHistory> getByParam(Map<String, Object> param) throws BottomUpException {
        return this.dumpDrugHistoryMapper.getByParam(param);
    }

    public void delete (Map<String,Object> param) throws BottomUpException {
        this.dumpDrugHistoryMapper.delete(param);
    }
}
