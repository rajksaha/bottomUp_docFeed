package com.bottomUp.service.migration;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.migration.DumpAppointment;
import com.bottomUp.myBatis.persistence.migration.DumpAppointmentMapper;
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
public class DumpAppointmentService {

    @Autowired
    private DumpAppointmentMapper dumpAppointmentMapper;


    public void create(DumpAppointment data) throws BottomUpException {
        dumpAppointmentMapper.create(data);
    }

    public void update(DumpAppointment data) throws BottomUpException {
        dumpAppointmentMapper.update(data);
    }

    public DumpAppointment getByID(Long ID)throws BottomUpException {
        return this.dumpAppointmentMapper.getByID(ID);
    }

    public DumpAppointment getByName(String name)throws BottomUpException {
        return this.dumpAppointmentMapper.getByName(name);
    }

    public List<DumpAppointment> getByParam(Map<String, Object> param) throws BottomUpException {
        return this.dumpAppointmentMapper.getByParam(param);
    }

    public void delete (Map<String,Object> param) throws BottomUpException {
        this.dumpAppointmentMapper.delete(param);
    }
}
