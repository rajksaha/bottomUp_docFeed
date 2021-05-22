package com.bottomUp.service.migration;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.migration.DumpPatientFamilyHistory;
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
    private DumpPatientFamilyHistoryService dumpPatientFamilyHistoryService;


    public void create(DumpPatientFamilyHistory data) throws BottomUpException {
        dumpPatientFamilyHistoryService.create(data);
    }

    public void update(DumpPatientFamilyHistory data) throws BottomUpException {
        dumpPatientFamilyHistoryService.update(data);
    }

    public DumpPatientFamilyHistory getByID(Long ID)throws BottomUpException {
        return this.dumpPatientFamilyHistoryService.getByID(ID);
    }

    public DumpPatientFamilyHistory getByName(String name)throws BottomUpException {
        return this.dumpPatientFamilyHistoryService.getByName(name);
    }

    public List<DumpPatientFamilyHistory> getByParam(Map<String, Object> param) throws BottomUpException {
        return this.dumpPatientFamilyHistoryService.getByParam(param);
    }

    public void delete (Map<String,Object> param) throws BottomUpException {
        this.dumpPatientFamilyHistoryService.delete(param);
    }
}
