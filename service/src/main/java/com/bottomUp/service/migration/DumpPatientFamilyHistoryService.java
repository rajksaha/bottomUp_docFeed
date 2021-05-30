package com.bottomUp.service.migration;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.migration.DumpPatientFamilyHistory;
import com.bottomUp.myBatis.persistence.migration.DumpPatientFamilyHistoryMapper;
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
public class DumpPatientFamilyHistoryService {

    @Autowired
    private DumpPatientFamilyHistoryMapper dumpPatientFamilyHistoryMapper;


    public void create(DumpPatientFamilyHistory data) throws BottomUpException {
        dumpPatientFamilyHistoryMapper.create(data);
    }

    public void update(DumpPatientFamilyHistory data) throws BottomUpException {
        dumpPatientFamilyHistoryMapper.update(data);
    }

    public DumpPatientFamilyHistory getByID(Long ID)throws BottomUpException {
        return this.dumpPatientFamilyHistoryMapper.getByID(ID);
    }

    public DumpPatientFamilyHistory getByName(String name)throws BottomUpException {
        return this.dumpPatientFamilyHistoryMapper.getByName(name);
    }

    public List<DumpPatientFamilyHistory> getByParam(Map<String, Object> param) throws BottomUpException {
        return this.dumpPatientFamilyHistoryMapper.getByParam(param);
    }

    public void delete (Map<String,Object> param) throws BottomUpException {
        this.dumpPatientFamilyHistoryMapper.delete(param);
    }
}
