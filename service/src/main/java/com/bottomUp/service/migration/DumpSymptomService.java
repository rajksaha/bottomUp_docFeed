package com.bottomUp.service.migration;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.migration.DumpSymptom;
import com.bottomUp.myBatis.persistence.migration.DumpSymptomMapper;
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
public class DumpSymptomService {

    @Autowired
    private DumpSymptomMapper dumpSymptomMapper;


    public void create(DumpSymptom data) throws BottomUpException {
        dumpSymptomMapper.create(data);
    }

    public void update(DumpSymptom data) throws BottomUpException {
        dumpSymptomMapper.update(data);
    }

    public DumpSymptom getByID(Long ID)throws BottomUpException {
        return this.dumpSymptomMapper.getByID(ID);
    }

    public DumpSymptom getByName(String name)throws BottomUpException {
        return this.dumpSymptomMapper.getByName(name);
    }

    public List<DumpSymptom> getByParam(Map<String, Object> param) throws BottomUpException {
        return this.dumpSymptomMapper.getByParam(param);
    }

    public void delete (Map<String,Object> param) throws BottomUpException {
        this.dumpSymptomMapper.delete(param);
    }
}
