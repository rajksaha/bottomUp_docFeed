package com.bottomUp.service.migration;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.migration.DumpFollowUpResult;
import com.bottomUp.myBatis.persistence.migration.DumpFollowUpResultMapper;
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
public class DumpFollowUpResultService {

    @Autowired
    private DumpFollowUpResultMapper dumpFollowUpResultMapper;


    public void create(DumpFollowUpResult data) throws BottomUpException {
        dumpFollowUpResultMapper.create(data);
    }

    public void update(DumpFollowUpResult data) throws BottomUpException {
        dumpFollowUpResultMapper.update(data);
    }

    public DumpFollowUpResult getByID(Long ID)throws BottomUpException {
        return this.dumpFollowUpResultMapper.getByID(ID);
    }

    public DumpFollowUpResult getByName(String name)throws BottomUpException {
        return this.dumpFollowUpResultMapper.getByName(name);
    }

    public List<DumpFollowUpResult> getByParam(Map<String, Object> param) throws BottomUpException {
        return this.dumpFollowUpResultMapper.getByParam(param);
    }

    public void delete (Map<String,Object> param) throws BottomUpException {
        this.dumpFollowUpResultMapper.delete(param);
    }
}
