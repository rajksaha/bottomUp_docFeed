package com.bottomUp.service.docFeed;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.AppointmentTypeData;
import com.bottomUp.domain.PrescriptionAdviceData;
import com.bottomUp.myBatis.persistence.AppointmentTypeMapper;
import com.bottomUp.myBatis.persistence.PrescriptionAdviceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by raj on 09/08/2020.
 */

@Service
public class PrescriptionAdviceService {

    @Autowired
    private PrescriptionAdviceMapper prescriptionAdviceMapper;

    public void create(PrescriptionAdviceData data) throws BottomUpException {
        prescriptionAdviceMapper.create(data);
    }

    public void update(PrescriptionAdviceData data) throws BottomUpException {
        prescriptionAdviceMapper.update(data);
    }

    public PrescriptionAdviceData getByID(Long ID)throws BottomUpException {
        return this.prescriptionAdviceMapper.getByID(ID);
    }

    public List<PrescriptionAdviceData> getByParam(Map<String, Object> param) throws BottomUpException {
        return this.prescriptionAdviceMapper.getByParam(param);
    }

    public void delete (Map<String,Object> param) throws BottomUpException {
        this.prescriptionAdviceMapper.delete(param);
    }
}
