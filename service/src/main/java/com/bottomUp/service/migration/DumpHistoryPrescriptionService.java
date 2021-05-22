package com.bottomUp.service.migration;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.migration.DumpHistoryPrescription;
import com.bottomUp.myBatis.persistence.migration.DumpHistoryPrescriptionMapper;
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
public class DumpHistoryPrescriptionService {

    @Autowired
    private DumpHistoryPrescriptionMapper dumpHistoryPrescriptionMapper;


    public void create(DumpHistoryPrescription data) throws BottomUpException {
        dumpHistoryPrescriptionMapper.create(data);
    }

    public void update(DumpHistoryPrescription data) throws BottomUpException {
        dumpHistoryPrescriptionMapper.update(data);
    }

    public DumpHistoryPrescription getByID(Long ID)throws BottomUpException {
        return this.dumpHistoryPrescriptionMapper.getByID(ID);
    }

    public DumpHistoryPrescription getByName(String name)throws BottomUpException {
        return this.dumpHistoryPrescriptionMapper.getByName(name);
    }

    public List<DumpHistoryPrescription> getByParam(Map<String, Object> param) throws BottomUpException {
        return this.dumpHistoryPrescriptionMapper.getByParam(param);
    }

    public void delete (Map<String,Object> param) throws BottomUpException {
        this.dumpHistoryPrescriptionMapper.delete(param);
    }
}
