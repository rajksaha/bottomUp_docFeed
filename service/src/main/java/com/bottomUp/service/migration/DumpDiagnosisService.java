package com.bottomUp.service.migration;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.migration.DumpDiagnosis;
import com.bottomUp.myBatis.persistence.migration.DumpDiagnosisMapper;
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
public class DumpDiagnosisService {

    @Autowired
    private DumpDiagnosisMapper dumpDiagnosisMapper;


    public void create(DumpDiagnosis data) throws BottomUpException {
        dumpDiagnosisMapper.create(data);
    }

    public void update(DumpDiagnosis data) throws BottomUpException {
        dumpDiagnosisMapper.update(data);
    }

    public DumpDiagnosis getByID(Long ID)throws BottomUpException {
        return this.dumpDiagnosisMapper.getByID(ID);
    }

    public DumpDiagnosis getByName(String name)throws BottomUpException {
        return this.dumpDiagnosisMapper.getByName(name);
    }

    public List<DumpDiagnosis> getByParam(Map<String, Object> param) throws BottomUpException {
        return this.dumpDiagnosisMapper.getByParam(param);
    }

    public void delete (Map<String,Object> param) throws BottomUpException {
        this.dumpDiagnosisMapper.delete(param);
    }
}
