package com.bottomUp.service.migration;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.migration.DumpVitalPrescription;
import com.bottomUp.myBatis.persistence.migration.DumpVitalPrescriptionMapper;
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
public class DumpVitalPrescriptionService {

    @Autowired
    private DumpVitalPrescriptionMapper dumpVitalPrescriptionMapper;


    public void create(DumpVitalPrescription data) throws BottomUpException {
        dumpVitalPrescriptionMapper.create(data);
    }

    public void update(DumpVitalPrescription data) throws BottomUpException {
        dumpVitalPrescriptionMapper.update(data);
    }

    public DumpVitalPrescription getByID(Long ID)throws BottomUpException {
        return this.dumpVitalPrescriptionMapper.getByID(ID);
    }

    public DumpVitalPrescription getByName(String name)throws BottomUpException {
        return this.dumpVitalPrescriptionMapper.getByName(name);
    }

    public List<DumpVitalPrescription> getByParam(Map<String, Object> param) throws BottomUpException {
        return this.dumpVitalPrescriptionMapper.getByParam(param);
    }

    public void delete (Map<String,Object> param) throws BottomUpException {
        this.dumpVitalPrescriptionMapper.delete(param);
    }
}
