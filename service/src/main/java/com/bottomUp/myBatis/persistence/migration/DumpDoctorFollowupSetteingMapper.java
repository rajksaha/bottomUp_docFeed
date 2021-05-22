package com.bottomUp.myBatis.persistence.migration;


import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.migration.DumpAdvice;
import com.bottomUp.domain.migration.DumpDoctorFollowupSetteing;

import java.util.List;
import java.util.Map;

/**
 * Created by raj on 09/08/2020.
 */
public interface DumpDoctorFollowupSetteingMapper {

    public void create(DumpDoctorFollowupSetteing data) throws BottomUpException;

    public void update(DumpDoctorFollowupSetteing data) throws BottomUpException;

    public DumpDoctorFollowupSetteing getByID(Long ID) throws BottomUpException;

    public DumpDoctorFollowupSetteing getByName(String name)throws BottomUpException;

    public List<DumpDoctorFollowupSetteing> getByParam(Map<String, Object> param) throws BottomUpException;

    public void delete(Map<String, Object> param) throws BottomUpException;
}
