package com.bottomUp.service.docFeed.crud;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.AppointmentTypeData;
import com.bottomUp.domain.DoctorFollowUpSettingData;
import com.bottomUp.myBatis.persistence.AppointmentTypeMapper;
import com.bottomUp.myBatis.persistence.DoctorFollowUpSettingMapper;
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
public class DoctorFollowUpSettingService {

    @Autowired
    private DoctorFollowUpSettingMapper doctorFollowUpSettingMapper;

    @Autowired
    private ContentInvService contentInvService;

    public void create(DoctorFollowUpSettingData data) throws BottomUpException {
        data.setInvID(contentInvService.getInsert(data.getInvName()));
        doctorFollowUpSettingMapper.create(data);
    }

    public void update(DoctorFollowUpSettingData data) throws BottomUpException {
        doctorFollowUpSettingMapper.update(data);
    }

    public void updateDisplayOrder(List<DoctorFollowUpSettingData> followUpList) throws BottomUpException{
        doctorFollowUpSettingMapper.updateDisplayOrder(followUpList);
    }

    public DoctorFollowUpSettingData getByID(String ID)throws BottomUpException {
        return this.doctorFollowUpSettingMapper.getByID(ID);
    }

    public List<DoctorFollowUpSettingData> getByParam(Map<String, Object> param) throws BottomUpException {
        return this.doctorFollowUpSettingMapper.getByParam(param);
    }

    public void delete (Map<String,Object> param) throws BottomUpException {
        this.doctorFollowUpSettingMapper.delete(param);
    }
}
