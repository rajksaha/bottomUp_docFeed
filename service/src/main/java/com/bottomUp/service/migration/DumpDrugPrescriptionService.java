package com.bottomUp.service.migration;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.migration.DumpDrugPrescription;
import com.bottomUp.myBatis.persistence.migration.DumpDrugPrescriptionMapper;
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
public class DumpDrugPrescriptionService {

    @Autowired
    private DumpDrugPrescriptionMapper dumpDrugPrescriptionMapper;


    public void create(DumpDrugPrescription data) throws BottomUpException {
        dumpDrugPrescriptionMapper.create(data);
    }

    public void update(DumpDrugPrescription data) throws BottomUpException {
        dumpDrugPrescriptionMapper.update(data);
    }

    public DumpDrugPrescription getByID(Long ID)throws BottomUpException {
        return this.dumpDrugPrescriptionMapper.getByID(ID);
    }

    public DumpDrugPrescription getByName(String name)throws BottomUpException {
        return this.dumpDrugPrescriptionMapper.getByName(name);
    }

    public List<DumpDrugPrescription> getByParam(Map<String, Object> param) throws BottomUpException {
        return this.dumpDrugPrescriptionMapper.getByParam(param);
    }

    public void delete (Map<String,Object> param) throws BottomUpException {
        this.dumpDrugPrescriptionMapper.delete(param);
    }
}
