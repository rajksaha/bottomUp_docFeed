package com.bottomUp.service.migration;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.migration.DumpPatientHistory;
import com.bottomUp.myBatis.persistence.migration.DumpPatientHistoryMapper;
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
public class DumpPatientHistoryService {

    @Autowired
    private DumpPatientHistoryMapper dumpPatientHistoryMapper;


    public void create(DumpPatientHistory data) throws BottomUpException {
        dumpPatientHistoryMapper.create(data);
    }

    public void update(DumpPatientHistory data) throws BottomUpException {
        dumpPatientHistoryMapper.update(data);
    }

    public DumpPatientHistory getByID(Long ID)throws BottomUpException {
        return this.dumpPatientHistoryMapper.getByID(ID);
    }

    public DumpPatientHistory getByName(String name)throws BottomUpException {
        return this.dumpPatientHistoryMapper.getByName(name);
    }

    public List<DumpPatientHistory> getByParam(Map<String, Object> param) throws BottomUpException {
        return this.dumpPatientHistoryMapper.getByParam(param);
    }

    public void delete (Map<String,Object> param) throws BottomUpException {
        this.dumpPatientHistoryMapper.delete(param);
    }
}
