package com.bottomUp.service.migration;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.migration.DumpPrescriptionReference;
import com.bottomUp.myBatis.persistence.migration.DumpPrescriptionReferenceMapper;
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
public class DumpPrescriptionReferenceService {

    @Autowired
    private DumpPrescriptionReferenceMapper dumpPrescriptionReferenceMapper;


    public void create(DumpPrescriptionReference data) throws BottomUpException {
        dumpPrescriptionReferenceMapper.create(data);
    }

    public void update(DumpPrescriptionReference data) throws BottomUpException {
        dumpPrescriptionReferenceMapper.update(data);
    }

    public DumpPrescriptionReference getByID(Long ID)throws BottomUpException {
        return this.dumpPrescriptionReferenceMapper.getByID(ID);
    }

    public DumpPrescriptionReference getByName(String name)throws BottomUpException {
        return this.dumpPrescriptionReferenceMapper.getByName(name);
    }

    public List<DumpPrescriptionReference> getByParam(Map<String, Object> param) throws BottomUpException {
        return this.dumpPrescriptionReferenceMapper.getByParam(param);
    }

    public void delete (Map<String,Object> param) throws BottomUpException {
        this.dumpPrescriptionReferenceMapper.delete(param);
    }
}
