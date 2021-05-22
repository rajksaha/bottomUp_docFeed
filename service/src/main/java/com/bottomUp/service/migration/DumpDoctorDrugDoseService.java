package com.bottomUp.service.migration;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.migration.DumpDoctorDrugDose;
import com.bottomUp.myBatis.persistence.migration.DumpDoctorDrugDoseMapper;
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
public class DumpDoctorDrugDoseService {

    @Autowired
    private DumpDoctorDrugDoseMapper dumpDoctorDrugDoseMapper;


    public void create(DumpDoctorDrugDose data) throws BottomUpException {
        dumpDoctorDrugDoseMapper.create(data);
    }

    public void update(DumpDoctorDrugDose data) throws BottomUpException {
        dumpDoctorDrugDoseMapper.update(data);
    }

    public DumpDoctorDrugDose getByID(Long ID)throws BottomUpException {
        return this.dumpDoctorDrugDoseMapper.getByID(ID);
    }

    public DumpDoctorDrugDose getByName(String name)throws BottomUpException {
        return this.dumpDoctorDrugDoseMapper.getByName(name);
    }

    public List<DumpDoctorDrugDose> getByParam(Map<String, Object> param) throws BottomUpException {
        return this.dumpDoctorDrugDoseMapper.getByParam(param);
    }

    public void delete (Map<String,Object> param) throws BottomUpException {
        this.dumpDoctorDrugDoseMapper.delete(param);
    }
}
