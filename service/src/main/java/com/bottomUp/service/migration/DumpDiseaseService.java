package com.bottomUp.service.migration;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.migration.DumpAdvice;
import com.bottomUp.domain.migration.DumpDisease;
import com.bottomUp.myBatis.persistence.migration.DumpAdviceMapper;
import com.bottomUp.myBatis.persistence.migration.DumpDiseaseMapper;
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
public class DumpDiseaseService {

    @Autowired
    private DumpDiseaseMapper dumpDiseaseMapper;


    public void create(DumpDisease data) throws BottomUpException {
        dumpDiseaseMapper.create(data);
    }

    public void update(DumpDisease data) throws BottomUpException {
        dumpDiseaseMapper.update(data);
    }

    public DumpDisease getByID(Long ID)throws BottomUpException {
        return this.dumpDiseaseMapper.getByID(ID);
    }

    public DumpDisease getByName(String name)throws BottomUpException {
        return this.dumpDiseaseMapper.getByName(name);
    }

    public List<DumpDisease> getByParam(Map<String, Object> param) throws BottomUpException {
        return this.dumpDiseaseMapper.getByParam(param);
    }

    public void delete (Map<String,Object> param) throws BottomUpException {
        this.dumpDiseaseMapper.delete(param);
    }
}
