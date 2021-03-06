package com.bottomUp.service.docFeed.crud;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.AppointmentTypeData;
import com.bottomUp.domain.DoctorHistorySettingData;
import com.bottomUp.myBatis.persistence.AppointmentTypeMapper;
import com.bottomUp.myBatis.persistence.DoctorHistorySettingMapper;
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
public class DoctorHistorySettingService {

    @Autowired
    private DoctorHistorySettingMapper doctorHistorySettingMapper;

    @Autowired
    private HistoryService historyService;

    public void create(DoctorHistorySettingData data) throws BottomUpException {
        data.setHistoryID(historyService.getInsert(data.getName(), data.getTypeCode()));
        doctorHistorySettingMapper.create(data);
    }

    public void update(DoctorHistorySettingData data) throws BottomUpException {
        doctorHistorySettingMapper.update(data);
    }

    public DoctorHistorySettingData getByID(String ID)throws BottomUpException {
        return this.doctorHistorySettingMapper.getByID(ID);
    }

    public List<DoctorHistorySettingData> getByParam(Map<String, Object> param) throws BottomUpException {
        return this.doctorHistorySettingMapper.getByParam(param);
    }

    public void delete (Map<String,Object> param) throws BottomUpException {
        this.doctorHistorySettingMapper.delete(param);
    }
}
