package com.bottomUp.service.migration;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.migration.DumpPatientFollowUP;
import com.bottomUp.myBatis.persistence.migration.DumpPatientFollowUpMapper;
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
public class DumpPatientFollowUpService {

    @Autowired
    private DumpPatientFollowUpMapper dumpPatientFollowUpMapper;


    public void create(DumpPatientFollowUP data) throws BottomUpException {
        dumpPatientFollowUpMapper.create(data);
    }

    public void update(DumpPatientFollowUP data) throws BottomUpException {
        dumpPatientFollowUpMapper.update(data);
    }

    public DumpPatientFollowUP getByID(Long ID)throws BottomUpException {
        return this.dumpPatientFollowUpMapper.getByID(ID);
    }

    public DumpPatientFollowUP getByName(String name)throws BottomUpException {
        return this.dumpPatientFollowUpMapper.getByName(name);
    }

    public List<DumpPatientFollowUP> getByParam(Map<String, Object> param) throws BottomUpException {
        return this.dumpPatientFollowUpMapper.getByParam(param);
    }

    public void delete (Map<String,Object> param) throws BottomUpException {
        this.dumpPatientFollowUpMapper.delete(param);
    }
}
