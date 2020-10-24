package com.bottomUp.service.docFeed.crud;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.AppointmentTypeData;
import com.bottomUp.domain.DoctorPreferenceAdviceData;
import com.bottomUp.myBatis.persistence.AppointmentTypeMapper;
import com.bottomUp.myBatis.persistence.DoctorPreferenceAdviceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by raj on 09/08/2020.
 */

@Service
public class DoctorPreferenceAdviceService {

    @Autowired
    private DoctorPreferenceAdviceMapper doctorPreferenceAdviceMapper;

    public void create(DoctorPreferenceAdviceData data) throws BottomUpException {
        doctorPreferenceAdviceMapper.create(data);
    }

    public void update(DoctorPreferenceAdviceData  data) throws BottomUpException {
        doctorPreferenceAdviceMapper.update(data);
    }

    public DoctorPreferenceAdviceData  getByID(Long ID)throws BottomUpException {
        return this.doctorPreferenceAdviceMapper.getByID(ID);
    }

    public List<DoctorPreferenceAdviceData > getByParam(Map<String, Object> param) throws BottomUpException {
        return this.doctorPreferenceAdviceMapper.getByParam(param);
    }

    public void delete (Map<String,Object> param) throws BottomUpException {
        this.doctorPreferenceAdviceMapper.delete(param);
    }
}
