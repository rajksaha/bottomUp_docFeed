package com.bottomUp.service.docFeed.crud;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.AppointmentData;
import com.bottomUp.model.AppointmentViewData;
import com.bottomUp.myBatis.persistence.AppointmentMapper;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Time;
import java.util.List;
import java.util.Map;

/**
 * Created by raj on 09/08/2020.
 */

@Service
@Transactional
public class AppointmentService {

    @Autowired
    private AppointmentMapper appointmentMapper;

    public void create(AppointmentData data) throws BottomUpException {

        if(data.getAppDate() == null ){
            DateTime now = new DateTime();
            data.setAppDate(now.toDate());
            data.setAppTime(Time.valueOf(now.toString()));
        }
        this.appointmentMapper.create(data);
    }

    public void update(AppointmentData data) throws BottomUpException {
        this.appointmentMapper.update(data);
    }

    public void updateStatusByID(Long appointmentID, Integer appointmentType) throws BottomUpException {
        AppointmentData appointmentData = new AppointmentData();
        appointmentData.setAppointmentID(appointmentID);
        appointmentData.setAppointmentType(appointmentType);
        this.appointmentMapper.updateAppTypeByID(appointmentData);
    }

    public AppointmentData getByID(Long ID)throws BottomUpException {
        return this.appointmentMapper.getByID(ID);
    }

    public List<AppointmentData> getByParam(Map<String, Object> param) throws BottomUpException {
        return this.appointmentMapper.getByParam(param);
    }

    public Integer getCountByParam(Map<String, Object> param) throws BottomUpException{
        return this.appointmentMapper.getCountByParam(param);
    }

    public List<AppointmentViewData> getAppPatientDetail(Map<String, Object> param) throws BottomUpException{
        return this.appointmentMapper.getAppPatientDetail(param);
    }

    public void delete (Map<String,Object> param) throws BottomUpException {
        this.appointmentMapper.delete(param);
    }
}
