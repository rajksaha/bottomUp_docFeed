package com.bottomUp.service.docFeed;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.AppointmentData;
import com.bottomUp.myBatis.persistence.AppointmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        appointmentMapper.create(data);
    }

    public void update(AppointmentData data) throws BottomUpException {
        appointmentMapper.update(data);
    }

    public AppointmentData getByID(Long ID)throws BottomUpException {
        return this.appointmentMapper.getByID(ID);
    }

    public List<AppointmentData> getByParam(Map<String, Object> param) throws BottomUpException {
        return this.appointmentMapper.getByParam(param);
    }

    public void delete (Map<String,Object> param) throws BottomUpException {
        this.appointmentMapper.delete(param);
    }
}
