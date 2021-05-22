package com.bottomUp.service.migration;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.migration.DumpPrescriptionPastDisease;
import com.bottomUp.myBatis.persistence.migration.DumpPrescriptionPastDiseaseMapper;
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
public class DumpPrescriptionPastDiseaseService {

    @Autowired
    private DumpPrescriptionPastDiseaseMapper dumpPrescriptionPastDiseaseMapper;


    public void create(DumpPrescriptionPastDisease data) throws BottomUpException {
        dumpPrescriptionPastDiseaseMapper.create(data);
    }

    public void update(DumpPrescriptionPastDisease data) throws BottomUpException {
        dumpPrescriptionPastDiseaseMapper.update(data);
    }

    public DumpPrescriptionPastDisease getByID(Long ID)throws BottomUpException {
        return this.dumpPrescriptionPastDiseaseMapper.getByID(ID);
    }

    public DumpPrescriptionPastDisease getByName(String name)throws BottomUpException {
        return this.dumpPrescriptionPastDiseaseMapper.getByName(name);
    }

    public List<DumpPrescriptionPastDisease> getByParam(Map<String, Object> param) throws BottomUpException {
        return this.dumpPrescriptionPastDiseaseMapper.getByParam(param);
    }

    public void delete (Map<String,Object> param) throws BottomUpException {
        this.dumpPrescriptionPastDiseaseMapper.delete(param);
    }
}
