package com.bottomUp.service.migration;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.migration.DumpHistoryOption;
import com.bottomUp.myBatis.persistence.migration.DumpHistoryOptionMapper;
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
public class DumpHistoryOptionService {

    @Autowired
    private DumpHistoryOptionMapper dumpHistoryOptionMapper;


    public void create(DumpHistoryOption data) throws BottomUpException {
        dumpHistoryOptionMapper.create(data);
    }

    public void update(DumpHistoryOption data) throws BottomUpException {
        dumpHistoryOptionMapper.update(data);
    }

    public DumpHistoryOption getByID(Long ID)throws BottomUpException {
        return this.dumpHistoryOptionMapper.getByID(ID);
    }

    public DumpHistoryOption getByName(String name)throws BottomUpException {
        return this.dumpHistoryOptionMapper.getByName(name);
    }

    public List<DumpHistoryOption> getByParam(Map<String, Object> param) throws BottomUpException {
        return this.dumpHistoryOptionMapper.getByParam(param);
    }

    public void delete (Map<String,Object> param) throws BottomUpException {
        this.dumpHistoryOptionMapper.delete(param);
    }
}
