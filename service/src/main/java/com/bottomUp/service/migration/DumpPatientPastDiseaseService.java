package com.bottomUp.service.migration;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.migration.DumpPatientPastDisease;
import com.bottomUp.myBatis.persistence.migration.DumpPatientPastDiseaseMapper;
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
public class DumpPatientPastDiseaseService {

    @Autowired
    private DumpPatientPastDiseaseMapper dumpPatientPastDiseaseMapper;


    public void create(DumpPatientPastDisease data) throws BottomUpException {
        dumpPatientPastDiseaseMapper.create(data);
    }

    public void update(DumpPatientPastDisease data) throws BottomUpException {
        dumpPatientPastDiseaseMapper.update(data);
    }

    public DumpPatientPastDisease getByID(Long ID)throws BottomUpException {
        return this.dumpPatientPastDiseaseMapper.getByID(ID);
    }

    public DumpPatientPastDisease getByName(String name)throws BottomUpException {
        return this.dumpPatientPastDiseaseMapper.getByName(name);
    }

    public List<DumpPatientPastDisease> getByParam(Map<String, Object> param) throws BottomUpException {
        return this.dumpPatientPastDiseaseMapper.getByParam(param);
    }

    public void delete (Map<String,Object> param) throws BottomUpException {
        this.dumpPatientPastDiseaseMapper.delete(param);
    }
}
