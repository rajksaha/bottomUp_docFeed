package com.bottomUp.service.migration;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.migration.DumpVitalOption;
import com.bottomUp.myBatis.persistence.migration.DumpVitalOptionMapper;
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
public class DumpVitalOptionService {

    @Autowired
    private DumpVitalOptionMapper dumpVitalOptionMapper;


    public void create(DumpVitalOption data) throws BottomUpException {
        dumpVitalOptionMapper.create(data);
    }

    public void update(DumpVitalOption data) throws BottomUpException {
        dumpVitalOptionMapper.update(data);
    }

    public DumpVitalOption getByID(Long ID)throws BottomUpException {
        return this.dumpVitalOptionMapper.getByID(ID);
    }

    public DumpVitalOption getByName(String name)throws BottomUpException {
        return this.dumpVitalOptionMapper.getByName(name);
    }

    public List<DumpVitalOption> getByParam(Map<String, Object> param) throws BottomUpException {
        return this.dumpVitalOptionMapper.getByParam(param);
    }

    public void delete (Map<String,Object> param) throws BottomUpException {
        this.dumpVitalOptionMapper.delete(param);
    }
}
