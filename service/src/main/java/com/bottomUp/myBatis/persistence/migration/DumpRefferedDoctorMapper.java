package com.bottomUp.myBatis.persistence.migration;


import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.migration.DumpAdvice;
import com.bottomUp.domain.migration.DumpRefferedDoctor;

import java.util.List;
import java.util.Map;

/**
 * Created by raj on 09/08/2020.
 */
public interface DumpRefferedDoctorMapper {

    public void create(DumpRefferedDoctor data) throws BottomUpException;

    public void update(DumpRefferedDoctor data) throws BottomUpException;

    public DumpRefferedDoctor getByID(Long ID) throws BottomUpException;

    public DumpRefferedDoctor getByName(String name)throws BottomUpException;

    public List<DumpRefferedDoctor> getByParam(Map<String, Object> param) throws BottomUpException;

    public void delete(Map<String, Object> param) throws BottomUpException;
}
