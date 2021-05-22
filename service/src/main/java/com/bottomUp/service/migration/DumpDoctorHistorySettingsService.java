package com.bottomUp.service.migration;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.migration.DumpDoctorHistorySettings;
import com.bottomUp.myBatis.persistence.migration.DumpDoctorHistorySettingsMapper;
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
public class DumpDoctorHistorySettingsService {

    @Autowired
    private DumpDoctorHistorySettingsMapper dumpDoctorHistorySettingsMapper;


    public void create(DumpDoctorHistorySettings data) throws BottomUpException {
        dumpDoctorHistorySettingsMapper.create(data);
    }

    public void update(DumpDoctorHistorySettings data) throws BottomUpException {
        dumpDoctorHistorySettingsMapper.update(data);
    }

    public DumpDoctorHistorySettings getByID(Long ID)throws BottomUpException {
        return this.dumpDoctorHistorySettingsMapper.getByID(ID);
    }

    public DumpDoctorHistorySettings getByName(String name)throws BottomUpException {
        return this.dumpDoctorHistorySettingsMapper.getByName(name);
    }

    public List<DumpDoctorHistorySettings> getByParam(Map<String, Object> param) throws BottomUpException {
        return this.dumpDoctorHistorySettingsMapper.getByParam(param);
    }

    public void delete (Map<String,Object> param) throws BottomUpException {
        this.dumpDoctorHistorySettingsMapper.delete(param);
    }
}
