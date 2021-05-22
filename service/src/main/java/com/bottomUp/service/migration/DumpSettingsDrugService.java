package com.bottomUp.service.migration;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.migration.DumpSettingsDrug;
import com.bottomUp.myBatis.persistence.migration.DumpSettingsDrugMapper;
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
public class DumpSettingsDrugService {

    @Autowired
    private DumpSettingsDrugMapper dumpSettingsDrugMapper;


    public void create(DumpSettingsDrug data) throws BottomUpException {
        dumpSettingsDrugMapper.create(data);
    }

    public void update(DumpSettingsDrug data) throws BottomUpException {
        dumpSettingsDrugMapper.update(data);
    }

    public DumpSettingsDrug getByID(Long ID)throws BottomUpException {
        return this.dumpSettingsDrugMapper.getByID(ID);
    }

    public DumpSettingsDrug getByName(String name)throws BottomUpException {
        return this.dumpSettingsDrugMapper.getByName(name);
    }

    public List<DumpSettingsDrug> getByParam(Map<String, Object> param) throws BottomUpException {
        return this.dumpSettingsDrugMapper.getByParam(param);
    }

    public void delete (Map<String,Object> param) throws BottomUpException {
        this.dumpSettingsDrugMapper.delete(param);
    }
}
