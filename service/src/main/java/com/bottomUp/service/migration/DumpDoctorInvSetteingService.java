package com.bottomUp.service.migration;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.migration.DumpDoctorInvSetteing;
import com.bottomUp.myBatis.persistence.migration.DumpDoctorInvSetteingMapper;
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
public class DumpDoctorInvSetteingService {

    @Autowired
    private DumpDoctorInvSetteingMapper dumpDoctorInvSetteing;


    public void create(DumpDoctorInvSetteing data) throws BottomUpException {
        dumpDoctorInvSetteing.create(data);
    }

    public void update(DumpDoctorInvSetteing data) throws BottomUpException {
        dumpDoctorInvSetteing.update(data);
    }

    public DumpDoctorInvSetteing getByID(Long ID)throws BottomUpException {
        return this.dumpDoctorInvSetteing.getByID(ID);
    }

    public DumpDoctorInvSetteing getByName(String name)throws BottomUpException {
        return this.dumpDoctorInvSetteing.getByName(name);
    }

    public List<DumpDoctorInvSetteing> getByParam(Map<String, Object> param) throws BottomUpException {
        return this.dumpDoctorInvSetteing.getByParam(param);
    }

    public void delete (Map<String,Object> param) throws BottomUpException {
        this.dumpDoctorInvSetteing.delete(param);
    }
}
