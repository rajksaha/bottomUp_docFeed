package com.bottomUp.service.migration;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.migration.DumpDoctorFollowupSetteing;
import com.bottomUp.myBatis.persistence.migration.DumpDoctorFollowupSetteingMapper;
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
public class DumpDoctorFollowupSetteingService {

    @Autowired
    private DumpDoctorFollowupSetteingMapper dumpDoctorFollowupSetteingMapper;


    public void create(DumpDoctorFollowupSetteing data) throws BottomUpException {
        dumpDoctorFollowupSetteingMapper.create(data);
    }

    public void update(DumpDoctorFollowupSetteing data) throws BottomUpException {
        dumpDoctorFollowupSetteingMapper.update(data);
    }

    public DumpDoctorFollowupSetteing getByID(Long ID)throws BottomUpException {
        return this.dumpDoctorFollowupSetteingMapper.getByID(ID);
    }

    public DumpDoctorFollowupSetteing getByName(String name)throws BottomUpException {
        return this.dumpDoctorFollowupSetteingMapper.getByName(name);
    }

    public List<DumpDoctorFollowupSetteing> getByParam(Map<String, Object> param) throws BottomUpException {
        return this.dumpDoctorFollowupSetteingMapper.getByParam(param);
    }

    public void delete (Map<String,Object> param) throws BottomUpException {
        this.dumpDoctorFollowupSetteingMapper.delete(param);
    }
}
