package com.bottomUp.service.docFeed.crud;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.AppointmentTypeData;
import com.bottomUp.domain.DoctorPreferenceInvData;
import com.bottomUp.myBatis.persistence.AppointmentTypeMapper;
import com.bottomUp.myBatis.persistence.DoctorPreferenceInvMapper;
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
public class DoctorPreferenceInvService {

    @Autowired
    private DoctorPreferenceInvMapper doctorPreferenceInvMapper;

    @Autowired
    private ContentInvService contentInvService;

    public void create(DoctorPreferenceInvData data) throws BottomUpException {
        if(data != null && data.getInvID() == null){
            data.setInvID(contentInvService.getInsert(data.getInvName()));
        }
        doctorPreferenceInvMapper.create(data);
    }

    public void update(DoctorPreferenceInvData data) throws BottomUpException {
        if(data != null && data.getInvID() == null){
            data.setInvID(contentInvService.getInsert(data.getInvName()));
        }
        doctorPreferenceInvMapper.update(data);
    }

    public DoctorPreferenceInvData getByID(Long ID)throws BottomUpException {
        return this.doctorPreferenceInvMapper.getByID(ID);
    }

    public List<DoctorPreferenceInvData> getByParam(Map<String, Object> param) throws BottomUpException {
        return this.doctorPreferenceInvMapper.getByParam(param);
    }

    public void delete (Map<String,Object> param) throws BottomUpException {
        this.doctorPreferenceInvMapper.delete(param);
    }
}
