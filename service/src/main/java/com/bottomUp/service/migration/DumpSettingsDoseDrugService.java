package com.bottomUp.service.migration;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.migration.DumpSettingsDoseDrug;
import com.bottomUp.myBatis.persistence.migration.DumpSettingsDoseDrugMapper;
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
public class DumpSettingsDoseDrugService {

    @Autowired
    private DumpSettingsDoseDrugMapper dumpSettingsDoseDrugMapper;


    public void create(DumpSettingsDoseDrug data) throws BottomUpException {
        dumpSettingsDoseDrugMapper.create(data);
    }

    public void update(DumpSettingsDoseDrug data) throws BottomUpException {
        dumpSettingsDoseDrugMapper.update(data);
    }

    public DumpSettingsDoseDrug getByID(Long ID)throws BottomUpException {
        return this.dumpSettingsDoseDrugMapper.getByID(ID);
    }

    public DumpSettingsDoseDrug getByName(String name)throws BottomUpException {
        return this.dumpSettingsDoseDrugMapper.getByName(name);
    }

    public List<DumpSettingsDoseDrug> getByParam(Map<String, Object> param) throws BottomUpException {
        return this.dumpSettingsDoseDrugMapper.getByParam(param);
    }

    public void delete (Map<String,Object> param) throws BottomUpException {
        this.dumpSettingsDoseDrugMapper.delete(param);
    }
}
