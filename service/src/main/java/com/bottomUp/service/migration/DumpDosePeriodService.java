package com.bottomUp.service.migration;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.migration.DumpDosePeriod;
import com.bottomUp.myBatis.persistence.migration.DumpDosePeriodMapper;
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
public class DumpDosePeriodService {

    @Autowired
    private DumpDosePeriodMapper dumpDosePeriodMapper;


    public void create(DumpDosePeriod data) throws BottomUpException {
        dumpDosePeriodMapper.create(data);
    }

    public void update(DumpDosePeriod data) throws BottomUpException {
        dumpDosePeriodMapper.update(data);
    }

    public DumpDosePeriod getByID(Long ID)throws BottomUpException {
        return this.dumpDosePeriodMapper.getByID(ID);
    }

    public DumpDosePeriod getByName(String name)throws BottomUpException {
        return this.dumpDosePeriodMapper.getByName(name);
    }

    public List<DumpDosePeriod> getByParam(Map<String, Object> param) throws BottomUpException {
        return this.dumpDosePeriodMapper.getByParam(param);
    }

    public void delete (Map<String,Object> param) throws BottomUpException {
        this.dumpDosePeriodMapper.delete(param);
    }
}
