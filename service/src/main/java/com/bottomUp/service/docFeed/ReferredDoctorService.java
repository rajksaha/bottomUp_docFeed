package com.bottomUp.service.docFeed;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.AppointmentTypeData;
import com.bottomUp.domain.ReferredDoctorData;
import com.bottomUp.myBatis.persistence.ReferredDoctorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by raj on 09/08/2020.
 */

@Service
public class ReferredDoctorService {

    @Autowired
    private ReferredDoctorMapper refferedDoctorMapper;

    public void create(ReferredDoctorData data) throws BottomUpException {
        refferedDoctorMapper.create(data);
    }

    public void update(ReferredDoctorData data) throws BottomUpException {
        refferedDoctorMapper.update(data);
    }

    public ReferredDoctorData getByID(Long ID)throws BottomUpException {
        return this.refferedDoctorMapper.getByID(ID);
    }

    public List<ReferredDoctorData> getByParam(Map<String, Object> param) throws BottomUpException {
        return this.refferedDoctorMapper.getByParam(param);
    }

    public void delete (Map<String,Object> param) throws BottomUpException {
        this.refferedDoctorMapper.delete(param);
    }
}
