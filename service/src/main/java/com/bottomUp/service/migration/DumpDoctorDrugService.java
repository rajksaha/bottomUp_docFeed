package com.bottomUp.service.migration;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.migration.DumpDoctorDrug;
import com.bottomUp.myBatis.persistence.migration.DumpDoctorDrugMapper;
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
public class DumpDoctorDrugService {

    @Autowired
    private DumpDoctorDrugMapper dumpDoctorDrugMapperr;


    public void create(DumpDoctorDrug data) throws BottomUpException {
        dumpDoctorDrugMapperr.create(data);
    }

    public void update(DumpDoctorDrug data) throws BottomUpException {
        dumpDoctorDrugMapperr.update(data);
    }

    public DumpDoctorDrug getByID(Long ID)throws BottomUpException {
        return this.dumpDoctorDrugMapperr.getByID(ID);
    }

    public DumpDoctorDrug getByName(String name)throws BottomUpException {
        return this.dumpDoctorDrugMapperr.getByName(name);
    }

    public List<DumpDoctorDrug> getByParam(Map<String, Object> param) throws BottomUpException {
        return this.dumpDoctorDrugMapperr.getByParam(param);
    }

    public void delete (Map<String,Object> param) throws BottomUpException {
        this.dumpDoctorDrugMapperr.delete(param);
    }
}
