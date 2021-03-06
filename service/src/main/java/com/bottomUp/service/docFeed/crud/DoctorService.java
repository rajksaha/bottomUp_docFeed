package com.bottomUp.service.docFeed.crud;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.AppointmentTypeData;
import com.bottomUp.domain.DoctorData;
import com.bottomUp.myBatis.persistence.AppointmentTypeMapper;
import com.bottomUp.myBatis.persistence.DoctorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by raj on 09/08/2020.
 */

@Service
@Transactional
public class DoctorService {

    @Autowired
    private DoctorMapper doctorMapper;

    public void create(DoctorData data) throws BottomUpException {
        this.doctorMapper.create(data);
    }

    public void update(DoctorData data) throws BottomUpException {
        this.doctorMapper.update(data);
    }

    public DoctorData getByID(String ID)throws BottomUpException {
        return this.doctorMapper.getByID(ID);
    }

    public DoctorData getByUser(String userID)throws BottomUpException {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("userID", userID);
        List<DoctorData> doctorDataList = this.doctorMapper.getByParam(param);
        if(doctorDataList != null && doctorDataList.size() == 1){
            return doctorDataList.get(0);
        }
        return null;
    }

    public List<DoctorData> getByParam(Map<String, Object> param) throws BottomUpException {
        return this.doctorMapper.getByParam(param);
    }

    public void delete (Map<String,Object> param) throws BottomUpException {
        this.doctorMapper.delete(param);
    }
}
