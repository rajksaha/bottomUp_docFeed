package com.bottomUp.service.migration;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.migration.DumpPatient;
import com.bottomUp.myBatis.persistence.migration.DumpPatientMapper;
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
public class DumpPatientService {

    @Autowired
    private DumpPatientMapper dumpPatientMapper;


    public void create(DumpPatient data) throws BottomUpException {
        dumpPatientMapper.create(data);
    }

    public void update(DumpPatient data) throws BottomUpException {
        dumpPatientMapper.update(data);
    }

    public DumpPatient getByID(Long ID)throws BottomUpException {
        return this.dumpPatientMapper.getByID(ID);
    }

    public DumpPatient getByName(String name)throws BottomUpException {
        return this.dumpPatientMapper.getByName(name);
    }

    public List<DumpPatient> getByParam(Map<String, Object> param) throws BottomUpException {
        return this.dumpPatientMapper.getByParam(param);
    }

    public void delete (Map<String,Object> param) throws BottomUpException {
        this.dumpPatientMapper.delete(param);
    }
}
