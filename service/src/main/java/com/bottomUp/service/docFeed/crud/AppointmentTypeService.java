package com.bottomUp.service.docFeed.crud;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.AppointmentTypeData;
import com.bottomUp.myBatis.persistence.AppointmentTypeMapper;
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
public class AppointmentTypeService {

    @Autowired
    private AppointmentTypeMapper appointmentTypeMapper;

    public void create(AppointmentTypeData data) throws BottomUpException {
        this.appointmentTypeMapper.create(data);
    }

    public void update(AppointmentTypeData data) throws BottomUpException {
        this.appointmentTypeMapper.update(data);
    }

    public AppointmentTypeData getByID(Long ID)throws BottomUpException {
        return this.appointmentTypeMapper.getByID(ID);
    }

    public List<AppointmentTypeData> getByParam(Map<String, Object> param) throws BottomUpException {
        return this.appointmentTypeMapper.getByParam(param);
    }

    public void delete (Map<String,Object> param) throws BottomUpException {
        this.appointmentTypeMapper.delete(param);
    }
}
