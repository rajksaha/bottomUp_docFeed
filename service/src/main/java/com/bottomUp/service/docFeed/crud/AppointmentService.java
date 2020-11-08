package com.bottomUp.service.docFeed.crud;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.AppointmentData;
import com.bottomUp.model.AppointmentViewData;
import com.bottomUp.myBatis.persistence.AppointmentMapper;
import org.apache.commons.lang3.time.DateUtils;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by raj on 09/08/2020.
 */

@Service
public class AppointmentService {

    @Autowired
    private AppointmentMapper appointmentMapper;

    public void create(AppointmentData data) throws BottomUpException {

        if(data.getDate() == null ){
            DateTime now = new DateTime();
            data.setDate(now.toDate());
            data.setTime(Time.valueOf(now.toString()));
        }
        this.appointmentMapper.create(data);
    }

    public void update(AppointmentData data) throws BottomUpException {
        this.appointmentMapper.update(data);
    }

    public void updateStatusByID(Map<String, Object> param) throws BottomUpException {
        this.appointmentMapper.updateStatusByID(param);
    }

    public AppointmentData getByID(Long ID)throws BottomUpException {
        return this.appointmentMapper.getByID(ID);
    }

    public List<AppointmentData> getByParam(Map<String, Object> param) throws BottomUpException {
        return this.appointmentMapper.getByParam(param);
    }

    public List<AppointmentViewData> getAppPatientDetail(Map<String, Object> param) throws BottomUpException{
        return this.appointmentMapper.getAppPatientDetail(param);
    }

    public void delete (Map<String,Object> param) throws BottomUpException {
        this.appointmentMapper.delete(param);
    }
}
