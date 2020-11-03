package com.bottomUp.service.docFeed;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.AppointmentTypeData;
import com.bottomUp.domain.PrescriptionHistoryData;
import com.bottomUp.myBatis.persistence.AppointmentTypeMapper;
import com.bottomUp.myBatis.persistence.PrescriptionHistoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by raj on 09/08/2020.
 */

@Service
public class PrescriptionHistoryService {

    @Autowired
    private PrescriptionHistoryMapper prescriptionHistoryMapper;

    public void create(PrescriptionHistoryData data) throws BottomUpException {
        prescriptionHistoryMapper.create(data);
    }

    public void update(PrescriptionHistoryData data) throws BottomUpException {
        prescriptionHistoryMapper.update(data);
    }

    public PrescriptionHistoryData getByID(Long ID)throws BottomUpException {
        return this.prescriptionHistoryMapper.getByID(ID);
    }

    public List<PrescriptionHistoryData> getByParam(Map<String, Object> param) throws BottomUpException {
        return this.prescriptionHistoryMapper.getByParam(param);
    }

    public void delete (Map<String,Object> param) throws BottomUpException {
        this.prescriptionHistoryMapper.delete(param);
    }
}
