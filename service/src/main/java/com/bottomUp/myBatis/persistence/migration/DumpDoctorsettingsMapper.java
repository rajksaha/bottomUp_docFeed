package com.bottomUp.myBatis.persistence.migration;


import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.migration.DumpAdvice;
import com.bottomUp.domain.migration.DumpDoctorsettings;

import java.util.List;
import java.util.Map;

/**
 * Created by raj on 09/08/2020.
 */
public interface DumpDoctorsettingsMapper {

    public void create(DumpDoctorsettings data) throws BottomUpException;

    public void update(DumpDoctorsettings data) throws BottomUpException;

    public DumpDoctorsettings getByID(Long ID) throws BottomUpException;

    public DumpDoctorsettings getByName(String name)throws BottomUpException;

    public List<DumpDoctorsettings> getByParam(Map<String, Object> param) throws BottomUpException;

    public void delete(Map<String, Object> param) throws BottomUpException;
}
