package com.bottomUp.service.docFeed.crud;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.AppointmentTypeData;
import com.bottomUp.domain.DoctorDataBackupData;
import com.bottomUp.myBatis.persistence.AppointmentTypeMapper;
import com.bottomUp.myBatis.persistence.DoctorDataBackupMapper;
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
public class DoctorDataBackupService {

    @Autowired
    private DoctorDataBackupMapper doctorDataBackupMapper;

    public void create(DoctorDataBackupData data) throws BottomUpException {
        doctorDataBackupMapper.create(data);
    }

    public void update(DoctorDataBackupData data) throws BottomUpException {
        doctorDataBackupMapper.update(data);
    }

    public DoctorDataBackupData getByID(String ID)throws BottomUpException {
        return this.doctorDataBackupMapper.getByID(ID);
    }

    public List<DoctorDataBackupData> getByParam(Map<String, Object> param) throws BottomUpException {
        return this.doctorDataBackupMapper.getByParam(param);
    }

    public void delete (Map<String,Object> param) throws BottomUpException {
        this.doctorDataBackupMapper.delete(param);
    }
}
