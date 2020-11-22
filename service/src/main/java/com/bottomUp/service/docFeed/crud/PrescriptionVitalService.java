package com.bottomUp.service.docFeed.crud;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.AppointmentTypeData;
import com.bottomUp.domain.DoctorVitalSettingData;
import com.bottomUp.domain.PrescriptionVitalData;
import com.bottomUp.domain.common.user.UserProfileData;
import com.bottomUp.myBatis.persistence.AppointmentTypeMapper;
import com.bottomUp.myBatis.persistence.PrescriptionVitalMapper;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by raj on 09/08/2020.
 */

@Service
@Transactional
public class PrescriptionVitalService {

    @Autowired
    private PrescriptionVitalMapper prescriptionVitalMapper;

    public void save(List<DoctorVitalSettingData> vitalDataList, Long appointmentID) throws BottomUpException{
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("appointmentID", appointmentID);
        prescriptionVitalMapper.delete(param);

        for(DoctorVitalSettingData settingData : vitalDataList){
            if(settingData.getVitalResult() != null && !settingData.getVitalResult().equals("")){
                PrescriptionVitalData vitalData = new PrescriptionVitalData();
                ModelMapper modelMapper = new ModelMapper();
                modelMapper.getConfiguration().setSkipNullEnabled(true).setMatchingStrategy(MatchingStrategies.STRICT);
                modelMapper.map(settingData, vitalData);
                vitalData.setAppointmentId(appointmentID);
                prescriptionVitalMapper.create(vitalData);
            }

        }
    }

    public void create(PrescriptionVitalData data) throws BottomUpException {
        prescriptionVitalMapper.create(data);
    }

    public void update(PrescriptionVitalData data) throws BottomUpException {
        prescriptionVitalMapper.update(data);
    }

    public PrescriptionVitalData getByID(Long ID)throws BottomUpException {
        return this.prescriptionVitalMapper.getByID(ID);
    }

    public List<PrescriptionVitalData> getByParam(Map<String, Object> param) throws BottomUpException {
        return this.prescriptionVitalMapper.getByParam(param);
    }

    public void delete (Map<String,Object> param) throws BottomUpException {
        this.prescriptionVitalMapper.delete(param);
    }
}
