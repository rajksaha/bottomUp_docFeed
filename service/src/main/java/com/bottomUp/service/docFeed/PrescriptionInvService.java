package com.bottomUp.service.docFeed;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.AppointmentTypeData;
import com.bottomUp.domain.PrescriptionInvData;
import com.bottomUp.myBatis.persistence.AppointmentTypeMapper;
import com.bottomUp.myBatis.persistence.PrescriptionInvMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by raj on 09/08/2020.
 */

@Service
public class PrescriptionInvService {

    @Autowired
    private PrescriptionInvMapper PrescriptionInvMapper;

    public void create(PrescriptionInvData data) throws BottomUpException {
        PrescriptionInvMapper.create(data);
    }

    public void update(PrescriptionInvData  data) throws BottomUpException {
        PrescriptionInvMapper.update(data);
    }

    public PrescriptionInvData  getByID(Long ID)throws BottomUpException {
        return this.PrescriptionInvMapper.getByID(ID);
    }

    public List<PrescriptionInvData > getByParam(Map<String, Object> param) throws BottomUpException {
        return this.PrescriptionInvMapper.getByParam(param);
    }

    public void delete (Map<String,Object> param) throws BottomUpException {
        this.PrescriptionInvMapper.delete(param);
    }
}
