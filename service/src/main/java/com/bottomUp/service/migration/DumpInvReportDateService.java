package com.bottomUp.service.migration;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.migration.DumpInvReportDate;
import com.bottomUp.myBatis.persistence.migration.DumpInvReportDateMapper;
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
public class DumpInvReportDateService {

    @Autowired
    private DumpInvReportDateMapper dumpInvReportDateMapper;


    public void create(DumpInvReportDate data) throws BottomUpException {
        dumpInvReportDateMapper.create(data);
    }

    public void update(DumpInvReportDate data) throws BottomUpException {
        dumpInvReportDateMapper.update(data);
    }

    public DumpInvReportDate getByID(Long ID)throws BottomUpException {
        return this.dumpInvReportDateMapper.getByID(ID);
    }

    public DumpInvReportDate getByName(String name)throws BottomUpException {
        return this.dumpInvReportDateMapper.getByName(name);
    }

    public List<DumpInvReportDate> getByParam(Map<String, Object> param) throws BottomUpException {
        return this.dumpInvReportDateMapper.getByParam(param);
    }

    public void delete (Map<String,Object> param) throws BottomUpException {
        this.dumpInvReportDateMapper.delete(param);
    }
}
