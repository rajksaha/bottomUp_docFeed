package com.bottomUp.service.migration;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.migration.DumpInvPrescription;
import com.bottomUp.myBatis.persistence.migration.DumpInvPrescriptionMapper;
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
public class DumpInvPrescriptionService {

    @Autowired
    private DumpInvPrescriptionMapper dumpInvPrescriptionMapper;


    public void create(DumpInvPrescription data) throws BottomUpException {
        dumpInvPrescriptionMapper.create(data);
    }

    public void update(DumpInvPrescription data) throws BottomUpException {
        dumpInvPrescriptionMapper.update(data);
    }

    public DumpInvPrescription getByID(Long ID)throws BottomUpException {
        return this.dumpInvPrescriptionMapper.getByID(ID);
    }

    public DumpInvPrescription getByName(String name)throws BottomUpException {
        return this.dumpInvPrescriptionMapper.getByName(name);
    }

    public List<DumpInvPrescription> getByParam(Map<String, Object> param) throws BottomUpException {
        return this.dumpInvPrescriptionMapper.getByParam(param);
    }

    public void delete (Map<String,Object> param) throws BottomUpException {
        this.dumpInvPrescriptionMapper.delete(param);
    }
}
