package com.bottomUp.service.migration;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.migration.DumpPatientType;
import com.bottomUp.myBatis.persistence.migration.DumpPatientTypeMapper;
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
public class DumpPatientTypeService {

    @Autowired
    private DumpPatientTypeMapper dumpPatientTypeMapper;


    public void create(DumpPatientType data) throws BottomUpException {
        dumpPatientTypeMapper.create(data);
    }

    public void update(DumpPatientType data) throws BottomUpException {
        dumpPatientTypeMapper.update(data);
    }

    public DumpPatientType getByID(Long ID)throws BottomUpException {
        return this.dumpPatientTypeMapper.getByID(ID);
    }

    public DumpPatientType getByName(String name)throws BottomUpException {
        return this.dumpPatientTypeMapper.getByName(name);
    }

    public List<DumpPatientType> getByParam(Map<String, Object> param) throws BottomUpException {
        return this.dumpPatientTypeMapper.getByParam(param);
    }

    public void delete (Map<String,Object> param) throws BottomUpException {
        this.dumpPatientTypeMapper.delete(param);
    }
}
