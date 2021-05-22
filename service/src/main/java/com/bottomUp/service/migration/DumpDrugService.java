package com.bottomUp.service.migration;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.migration.DumpDrug;
import com.bottomUp.myBatis.persistence.migration.DumpDrugMapper;
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
public class DumpDrugService {

    @Autowired
    private DumpDrugMapper dumpDrugMapper;


    public void create(DumpDrug data) throws BottomUpException {
        dumpDrugMapper.create(data);
    }

    public void update(DumpDrug data) throws BottomUpException {
        dumpDrugMapper.update(data);
    }

    public DumpDrug getByID(Long ID)throws BottomUpException {
        return this.dumpDrugMapper.getByID(ID);
    }

    public DumpDrug getByName(String name)throws BottomUpException {
        return this.dumpDrugMapper.getByName(name);
    }

    public List<DumpDrug> getByParam(Map<String, Object> param) throws BottomUpException {
        return this.dumpDrugMapper.getByParam(param);
    }

    public void delete (Map<String,Object> param) throws BottomUpException {
        this.dumpDrugMapper.delete(param);
    }
}
