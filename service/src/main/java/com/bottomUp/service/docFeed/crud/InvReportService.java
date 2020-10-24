package com.bottomUp.service.docFeed.crud;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.AppointmentTypeData;
import com.bottomUp.domain.InvReportData;
import com.bottomUp.myBatis.persistence.AppointmentTypeMapper;
import com.bottomUp.myBatis.persistence.InvReportMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by raj on 09/08/2020.
 */

@Service
public class InvReportService {

    @Autowired
    private InvReportMapper invReportMapper;

    public void create(InvReportData data) throws BottomUpException {
        invReportMapper.create(data);
    }

    public void update(InvReportData data) throws BottomUpException {
        invReportMapper.update(data);
    }

    public InvReportData getByID(Long ID)throws BottomUpException {
        return this.invReportMapper.getByID(ID);
    }

    public List<InvReportData> getByParam(Map<String, Object> param) throws BottomUpException {
        return this.invReportMapper.getByParam(param);
    }

    public void delete (Map<String,Object> param) throws BottomUpException {
        this.invReportMapper.delete(param);
    }
}
