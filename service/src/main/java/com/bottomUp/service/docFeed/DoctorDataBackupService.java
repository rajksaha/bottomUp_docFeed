package com.bottomUp.service.docFeed;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.AppointmentTypeData;
import com.bottomUp.domain.DoctorDataBackupData;
import com.bottomUp.myBatis.persistence.AppointmentTypeMapper;
import com.bottomUp.myBatis.persistence.DoctorDataBackupMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by raj on 09/08/2020.
 */

@Service
public class DoctorDataBackupService {

    @Autowired
    private DoctorDataBackupMapper doctorDataBackupMapper;

    public DoctorDataBackupData create(DoctorDataBackupData data) throws BottomUpException {
        return this.doctorDataBackupMapper.create(data);
    }

    public DoctorDataBackupData update(DoctorDataBackupData data) throws BottomUpException {
        return this.doctorDataBackupMapper.update(data);
    }

    public DoctorDataBackupData getByID(Long ID)throws BottomUpException {
        return this.doctorDataBackupMapper.getByID(ID);
    }

    public List<DoctorDataBackupData> getByParam(Map<String, Object> param) throws BottomUpException {
        return this.doctorDataBackupMapper.getByParam(param);
    }

    public void delete (Map<String,Object> param) throws BottomUpException {
        this.doctorDataBackupMapper.delete(param);
    }
}
