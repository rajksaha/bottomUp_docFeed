package com.bottomUp.service.migration;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.migration.DumpDrugadvicetype;
import com.bottomUp.myBatis.persistence.migration.DumpDrugadvicetypeMapper;
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
public class DumpDrugadvicetypeService {

    @Autowired
    private DumpDrugadvicetypeMapper dumpDrugadvicetypeMapper;


    public void create(DumpDrugadvicetype data) throws BottomUpException {
        dumpDrugadvicetypeMapper.create(data);
    }

    public void update(DumpDrugadvicetype data) throws BottomUpException {
        dumpDrugadvicetypeMapper.update(data);
    }

    public DumpDrugadvicetype getByID(Long ID)throws BottomUpException {
        return this.dumpDrugadvicetypeMapper.getByID(ID);
    }

    public DumpDrugadvicetype getByName(String name)throws BottomUpException {
        return this.dumpDrugadvicetypeMapper.getByName(name);
    }

    public List<DumpDrugadvicetype> getByParam(Map<String, Object> param) throws BottomUpException {
        return this.dumpDrugadvicetypeMapper.getByParam(param);
    }

    public void delete (Map<String,Object> param) throws BottomUpException {
        this.dumpDrugadvicetypeMapper.delete(param);
    }
}
