package com.bottomUp.service.migration;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.migration.DumpContentdetail;
import com.bottomUp.myBatis.persistence.migration.DumpContentdetailMapper;
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
public class DumpContentdetailService {

    @Autowired
    private DumpContentdetailMapper dumpContentdetailMapper;


    public void create(DumpContentdetail data) throws BottomUpException {
        dumpContentdetailMapper.create(data);
    }

    public void update(DumpContentdetail data) throws BottomUpException {
        dumpContentdetailMapper.update(data);
    }

    public DumpContentdetail getByID(Long ID)throws BottomUpException {
        return this.dumpContentdetailMapper.getByID(ID);
    }

    public DumpContentdetail getByName(String name)throws BottomUpException {
        return this.dumpContentdetailMapper.getByName(name);
    }

    public List<DumpContentdetail> getByParam(Map<String, Object> param) throws BottomUpException {
        return this.dumpContentdetailMapper.getByParam(param);
    }

    public void delete (Map<String,Object> param) throws BottomUpException {
        this.dumpContentdetailMapper.delete(param);
    }
}
