package com.bottomUp.service.docFeed;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.AppointmentTypeData;
import com.bottomUp.domain.DoctorData;
import com.bottomUp.myBatis.persistence.AppointmentTypeMapper;
import com.bottomUp.myBatis.persistence.DoctorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by raj on 09/08/2020.
 */

@Service
public class DoctorService {

    @Autowired
    private DoctorMapper doctorMapper;

    public DoctorData create(DoctorData data) throws BottomUpException {
        return this.doctorMapper.create(data);
    }

    public DoctorData update(DoctorData data) throws BottomUpException {
        return this.doctorMapper.update(data);
    }

    public DoctorData getByID(Long ID)throws BottomUpException {
        return this.doctorMapper.getByID(ID);
    }

    public List<DoctorData> getByParam(Map<String, Object> param) throws BottomUpException {
        return this.doctorMapper.getByParam(param);
    }

    public void delete (Map<String,Object> param) throws BottomUpException {
        this.doctorMapper.delete(param);
    }
}
