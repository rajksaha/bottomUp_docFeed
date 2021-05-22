package com.bottomUp.service.migration;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.migration.DumpRefferedDoctor;
import com.bottomUp.myBatis.persistence.migration.DumpRefferedDoctorMapper;
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
public class DumpRefferedDoctorService {

    @Autowired
    private DumpRefferedDoctorMapper dumpRefferedDoctorMapper;


    public void create(DumpRefferedDoctor data) throws BottomUpException {
        dumpRefferedDoctorMapper.create(data);
    }

    public void update(DumpRefferedDoctor data) throws BottomUpException {
        dumpRefferedDoctorMapper.update(data);
    }

    public DumpRefferedDoctor getByID(Long ID)throws BottomUpException {
        return this.dumpRefferedDoctorMapper.getByID(ID);
    }

    public DumpRefferedDoctor getByName(String name)throws BottomUpException {
        return this.dumpRefferedDoctorMapper.getByName(name);
    }

    public List<DumpRefferedDoctor> getByParam(Map<String, Object> param) throws BottomUpException {
        return this.dumpRefferedDoctorMapper.getByParam(param);
    }

    public void delete (Map<String,Object> param) throws BottomUpException {
        this.dumpRefferedDoctorMapper.delete(param);
    }
}
