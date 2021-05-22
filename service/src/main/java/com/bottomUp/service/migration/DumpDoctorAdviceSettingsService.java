package com.bottomUp.service.migration;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.migration.DumpDoctorAdviceSettings;
import com.bottomUp.myBatis.persistence.migration.DumpDoctorAdviceSettingsMapper;
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
public class DumpDoctorAdviceSettingsService {

    @Autowired
    private DumpDoctorAdviceSettingsMapper dumpDoctorAdviceSettings;


    public void create(DumpDoctorAdviceSettings data) throws BottomUpException {
        dumpDoctorAdviceSettings.create(data);
    }

    public void update(DumpDoctorAdviceSettings data) throws BottomUpException {
        dumpDoctorAdviceSettings.update(data);
    }

    public DumpDoctorAdviceSettings getByID(Long ID)throws BottomUpException {
        return this.dumpDoctorAdviceSettings.getByID(ID);
    }

    public DumpDoctorAdviceSettings getByName(String name)throws BottomUpException {
        return this.dumpDoctorAdviceSettings.getByName(name);
    }

    public List<DumpDoctorAdviceSettings> getByParam(Map<String, Object> param) throws BottomUpException {
        return this.dumpDoctorAdviceSettings.getByParam(param);
    }

    public void delete (Map<String,Object> param) throws BottomUpException {
        this.dumpDoctorAdviceSettings.delete(param);
    }
}
