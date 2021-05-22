package com.bottomUp.service.migration;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.migration.DumpDrugcompany;
import com.bottomUp.myBatis.persistence.migration.DumpDrugcompanyMapper;
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
public class DumpDrugcompanyService {

    @Autowired
    private DumpDrugcompanyMapper dumpDrugcompanyMapper;


    public void create(DumpDrugcompany data) throws BottomUpException {
        dumpDrugcompanyMapper.create(data);
    }

    public void update(DumpDrugcompany data) throws BottomUpException {
        dumpDrugcompanyMapper.update(data);
    }

    public DumpDrugcompany getByID(Long ID)throws BottomUpException {
        return this.dumpDrugcompanyMapper.getByID(ID);
    }

    public DumpDrugcompany getByName(String name)throws BottomUpException {
        return this.dumpDrugcompanyMapper.getByName(name);
    }

    public List<DumpDrugcompany> getByParam(Map<String, Object> param) throws BottomUpException {
        return this.dumpDrugcompanyMapper.getByParam(param);
    }

    public void delete (Map<String,Object> param) throws BottomUpException {
        this.dumpDrugcompanyMapper.delete(param);
    }
}
