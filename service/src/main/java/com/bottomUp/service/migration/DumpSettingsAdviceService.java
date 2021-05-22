package com.bottomUp.service.migration;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.migration.DumpSettingsAdvice;
import com.bottomUp.myBatis.persistence.migration.DumpSettingsAdviceMapper;
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
public class DumpSettingsAdviceService {

    @Autowired
    private DumpSettingsAdviceMapper dumpSettingsAdviceMapper;


    public void create(DumpSettingsAdvice data) throws BottomUpException {
        dumpSettingsAdviceMapper.create(data);
    }

    public void update(DumpSettingsAdvice data) throws BottomUpException {
        dumpSettingsAdviceMapper.update(data);
    }

    public DumpSettingsAdvice getByID(Long ID)throws BottomUpException {
        return this.dumpSettingsAdviceMapper.getByID(ID);
    }

    public DumpSettingsAdvice getByName(String name)throws BottomUpException {
        return this.dumpSettingsAdviceMapper.getByName(name);
    }

    public List<DumpSettingsAdvice> getByParam(Map<String, Object> param) throws BottomUpException {
        return this.dumpSettingsAdviceMapper.getByParam(param);
    }

    public void delete (Map<String,Object> param) throws BottomUpException {
        this.dumpSettingsAdviceMapper.delete(param);
    }
}
