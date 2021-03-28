package com.bottomUp.service.docFeed.crud;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.DoseData;
import com.bottomUp.myBatis.persistence.DoctorDrugDoseSettingMapper;
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
public class DoctorDrugDoseSettingService {

    @Autowired
    private DoctorDrugDoseSettingMapper doctorDrugDoseSettingMapper;

    public void create(DoseData data) throws BottomUpException {
        doctorDrugDoseSettingMapper.create(data);
    }

    public void update(DoseData data) throws BottomUpException {
        doctorDrugDoseSettingMapper.update(data);
    }

    public DoseData getByID(Long ID)throws BottomUpException {
        return this.doctorDrugDoseSettingMapper.getByID(ID);
    }

    public List<DoseData> getByParam(Map<String, Object> param) throws BottomUpException {
        return this.doctorDrugDoseSettingMapper.getByParam(param);
    }

    public void delete (Map<String,Object> param) throws BottomUpException {
        this.doctorDrugDoseSettingMapper.delete(param);
    }
}
