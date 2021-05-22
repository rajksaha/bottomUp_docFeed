package com.bottomUp.service.migration;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.migration.DumpDoctorVitalSettings;
import com.bottomUp.myBatis.persistence.migration.DumpDoctorVitalSettingsMapper;
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
public class DumpDoctorVitalSettingsService {

    @Autowired
    private DumpDoctorVitalSettingsMapper dumpDoctorVitalSettingsMapper;


    public void create(DumpDoctorVitalSettings data) throws BottomUpException {
        dumpDoctorVitalSettingsMapper.create(data);
    }

    public void update(DumpDoctorVitalSettings data) throws BottomUpException {
        dumpDoctorVitalSettingsMapper.update(data);
    }

    public DumpDoctorVitalSettings getByID(Long ID)throws BottomUpException {
        return this.dumpDoctorVitalSettingsMapper.getByID(ID);
    }

    public DumpDoctorVitalSettings getByName(String name)throws BottomUpException {
        return this.dumpDoctorVitalSettingsMapper.getByName(name);
    }

    public List<DumpDoctorVitalSettings> getByParam(Map<String, Object> param) throws BottomUpException {
        return this.dumpDoctorVitalSettingsMapper.getByParam(param);
    }

    public void delete (Map<String,Object> param) throws BottomUpException {
        this.dumpDoctorVitalSettingsMapper.delete(param);
    }
}
