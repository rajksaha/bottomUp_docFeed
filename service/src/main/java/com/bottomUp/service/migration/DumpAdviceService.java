package com.bottomUp.service.migration;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.migration.DumpAdvice;
import com.bottomUp.myBatis.persistence.migration.DumpAdviceMapper;
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
public class DumpAdviceService {

    @Autowired
    private DumpAdviceMapper dumpAdviceMapper;


    public void create(DumpAdvice data) throws BottomUpException {
        dumpAdviceMapper.create(data);
    }

    public void update(DumpAdvice data) throws BottomUpException {
        dumpAdviceMapper.update(data);
    }

    public DumpAdvice getByID(Long ID)throws BottomUpException {
        return this.dumpAdviceMapper.getByID(ID);
    }

    public DumpAdvice getByName(String name)throws BottomUpException {
        return this.dumpAdviceMapper.getByName(name);
    }

    public List<DumpAdvice> getByParam(Map<String, Object> param) throws BottomUpException {
        return this.dumpAdviceMapper.getByParam(param);
    }

    public void delete (Map<String,Object> param) throws BottomUpException {
        this.dumpAdviceMapper.delete(param);
    }
}
