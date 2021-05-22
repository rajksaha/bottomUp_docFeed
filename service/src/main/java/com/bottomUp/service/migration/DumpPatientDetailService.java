package com.bottomUp.service.migration;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.migration.DumpPatientDetail;
import com.bottomUp.myBatis.persistence.migration.DumpPatientDetailMapper;
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
public class DumpPatientDetailService {

    @Autowired
    private DumpPatientDetailMapper dumpPatientDetailMapper;


    public void create(DumpPatientDetail data) throws BottomUpException {
        dumpPatientDetailMapper.create(data);
    }

    public void update(DumpPatientDetail data) throws BottomUpException {
        dumpPatientDetailMapper.update(data);
    }

    public DumpPatientDetail getByID(Long ID)throws BottomUpException {
        return this.dumpPatientDetailMapper.getByID(ID);
    }

    public DumpPatientDetail getByName(String name)throws BottomUpException {
        return this.dumpPatientDetailMapper.getByName(name);
    }

    public List<DumpPatientDetail> getByParam(Map<String, Object> param) throws BottomUpException {
        return this.dumpPatientDetailMapper.getByParam(param);
    }

    public void delete (Map<String,Object> param) throws BottomUpException {
        this.dumpPatientDetailMapper.delete(param);
    }
}
