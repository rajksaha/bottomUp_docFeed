package com.bottomUp.myBatis.persistence.migration;


import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.migration.DumpAppointment;

import java.util.List;
import java.util.Map;

/**
 * Created by raj on 09/08/2020.
 */
public interface DumpAppointmentMapper {

    public void create(DumpAppointment data) throws BottomUpException;

    public void update(DumpAppointment data) throws BottomUpException;

    public DumpAppointment getByID(Long ID) throws BottomUpException;

    public DumpAppointment getByName(String name)throws BottomUpException;

    public List<DumpAppointment> getByParam(Map<String, Object> param) throws BottomUpException;

    public void delete(Map<String, Object> param) throws BottomUpException;
}
