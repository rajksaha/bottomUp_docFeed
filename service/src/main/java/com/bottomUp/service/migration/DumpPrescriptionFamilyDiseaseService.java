package com.bottomUp.service.migration;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.migration.DumpPrescriptionFamilyDisease;
import com.bottomUp.myBatis.persistence.migration.DumpPrescriptionFamilyDiseaseMapper;
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
public class DumpPrescriptionFamilyDiseaseService {

    @Autowired
    private DumpPrescriptionFamilyDiseaseMapper dumpPrescriptionFamilyDiseaseMapper;


    public void create(DumpPrescriptionFamilyDisease data) throws BottomUpException {
        dumpPrescriptionFamilyDiseaseMapper.create(data);
    }

    public void update(DumpPrescriptionFamilyDisease data) throws BottomUpException {
        dumpPrescriptionFamilyDiseaseMapper.update(data);
    }

    public DumpPrescriptionFamilyDisease getByID(Long ID)throws BottomUpException {
        return this.dumpPrescriptionFamilyDiseaseMapper.getByID(ID);
    }

    public DumpPrescriptionFamilyDisease getByName(String name)throws BottomUpException {
        return this.dumpPrescriptionFamilyDiseaseMapper.getByName(name);
    }

    public List<DumpPrescriptionFamilyDisease> getByParam(Map<String, Object> param) throws BottomUpException {
        return this.dumpPrescriptionFamilyDiseaseMapper.getByParam(param);
    }

    public void delete (Map<String,Object> param) throws BottomUpException {
        this.dumpPrescriptionFamilyDiseaseMapper.delete(param);
    }
}
