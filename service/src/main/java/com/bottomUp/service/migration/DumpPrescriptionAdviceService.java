package com.bottomUp.service.migration;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.migration.DumpPrescriptionAdvice;
import com.bottomUp.myBatis.persistence.migration.DumpPrescriptionAdviceMapper;
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
public class DumpPrescriptionAdviceService {

    @Autowired
    private DumpPrescriptionAdviceMapper dumpPrescriptionAdviceMapper;


    public void create(DumpPrescriptionAdvice data) throws BottomUpException {
        dumpPrescriptionAdviceMapper.create(data);
    }

    public void update(DumpPrescriptionAdvice data) throws BottomUpException {
        dumpPrescriptionAdviceMapper.update(data);
    }

    public DumpPrescriptionAdvice getByID(Long ID)throws BottomUpException {
        return this.dumpPrescriptionAdviceMapper.getByID(ID);
    }

    public DumpPrescriptionAdvice getByName(String name)throws BottomUpException {
        return this.dumpPrescriptionAdviceMapper.getByName(name);
    }

    public List<DumpPrescriptionAdvice> getByParam(Map<String, Object> param) throws BottomUpException {
        return this.dumpPrescriptionAdviceMapper.getByParam(param);
    }

    public void delete (Map<String,Object> param) throws BottomUpException {
        this.dumpPrescriptionAdviceMapper.delete(param);
    }
}
