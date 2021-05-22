package com.bottomUp.service.migration;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.migration.DumpDoctorsettings;
import com.bottomUp.myBatis.persistence.migration.DumpDoctorsettingsMapper;
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
public class DumpDoctorsettingsService {

    @Autowired
    private DumpDoctorsettingsMapper dumpDoctorsettingsMapper;


    public void create(DumpDoctorsettings data) throws BottomUpException {
        dumpDoctorsettingsMapper.create(data);
    }

    public void update(DumpDoctorsettings data) throws BottomUpException {
        dumpDoctorsettingsMapper.update(data);
    }

    public DumpDoctorsettings getByID(Long ID)throws BottomUpException {
        return this.dumpDoctorsettingsMapper.getByID(ID);
    }

    public DumpDoctorsettings getByName(String name)throws BottomUpException {
        return this.dumpDoctorsettingsMapper.getByName(name);
    }

    public List<DumpDoctorsettings> getByParam(Map<String, Object> param) throws BottomUpException {
        return this.dumpDoctorsettingsMapper.getByParam(param);
    }

    public void delete (Map<String,Object> param) throws BottomUpException {
        this.dumpDoctorsettingsMapper.delete(param);
    }
}
