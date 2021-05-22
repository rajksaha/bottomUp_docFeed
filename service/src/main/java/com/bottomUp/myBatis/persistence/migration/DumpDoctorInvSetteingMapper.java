package com.bottomUp.myBatis.persistence.migration;


import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.migration.DumpAdvice;
import com.bottomUp.domain.migration.DumpDoctorInvSetteing;

import java.util.List;
import java.util.Map;

/**
 * Created by raj on 09/08/2020.
 */
public interface DumpDoctorInvSetteingMapper {

    public void create(DumpDoctorInvSetteing data) throws BottomUpException;

    public void update(DumpDoctorInvSetteing data) throws BottomUpException;

    public DumpDoctorInvSetteing getByID(Long ID) throws BottomUpException;

    public DumpDoctorInvSetteing getByName(String name)throws BottomUpException;

    public List<DumpDoctorInvSetteing> getByParam(Map<String, Object> param) throws BottomUpException;

    public void delete(Map<String, Object> param) throws BottomUpException;
}
