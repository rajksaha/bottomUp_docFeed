package com.bottomUp.service.docFeed;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.AppointmentTypeData;
import com.bottomUp.domain.InvReportDateData;
import com.bottomUp.myBatis.persistence.AppointmentTypeMapper;
import com.bottomUp.myBatis.persistence.InvReportDateMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by raj on 09/08/2020.
 */

@Service
public class InvReportDateService {

    @Autowired
    private InvReportDateMapper invReportDateMapper;

    public InvReportDateData create(InvReportDateData data) throws BottomUpException {
        return this.invReportDateMapper.create(data);
    }

    public InvReportDateData update(InvReportDateData data) throws BottomUpException {
        return this.invReportDateMapper.update(data);
    }

    public InvReportDateData getByID(Long ID)throws BottomUpException {
        return this. invReportDateMapper.getByID(ID);
    }

    public List<InvReportDateData> getByParam(Map<String, Object> param) throws BottomUpException {
        return this. invReportDateMapper.getByParam(param);
    }

    public void delete (Map<String,Object> param) throws BottomUpException {
        this. invReportDateMapper.delete(param);
    }
}
