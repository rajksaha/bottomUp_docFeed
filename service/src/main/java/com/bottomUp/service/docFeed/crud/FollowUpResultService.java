package com.bottomUp.service.docFeed.crud;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.DoctorFollowUpSettingData;
import com.bottomUp.domain.FollowUpResultData;
import com.bottomUp.domain.common.FollowUpDetail;
import com.bottomUp.model.FollowUpResultViewData;
import com.bottomUp.myBatis.persistence.AppointmentTypeMapper;
import com.bottomUp.myBatis.persistence.DoctorFollowUpSettingMapper;
import com.bottomUp.myBatis.persistence.FollowUpResultMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import utility.JsonConverter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by raj on 09/08/2020.
 */

@Service
@Transactional
public class FollowUpResultService {

    @Autowired
    private FollowUpResultMapper followUpResultMapper;

    @Autowired
    private DoctorFollowUpSettingMapper doctorFollowUpSettingMapper;

    public FollowUpResultViewData generateFollowUpView(Long doctorID, Long patientID, Integer patientTypeID, Long appointmentID)throws BottomUpException{
        FollowUpResultViewData viewData = new FollowUpResultViewData();
        Map<String, Object> params = new HashMap<>();
        params.put("doctorID", doctorID);
        params.put("patientTypeID", patientTypeID);
        viewData.setDocFollowUpList(doctorFollowUpSettingMapper.getByParam(params));
        Map<Long, Integer> displayOrder = new HashMap<>();
        Map<Long, Boolean> headerMap = new HashMap<>();
        for(DoctorFollowUpSettingData data : viewData.getDocFollowUpList()){
            displayOrder.put(data.getFollowUpSettingID(), data.getDisplayOrder());
            headerMap.put(data.getFollowUpSettingID(), true);
        }
        params.put("patientID", patientID);
        params.put("appointmentID", appointmentID);
        viewData.setPatientFollowUpList(this.getByParam(params));
        for(FollowUpResultData result : viewData.getPatientFollowUpList()){
            Map<Long, Boolean> tempHeaderMap = new HashMap<>();
            List<FollowUpDetail> processedList = new ArrayList<>();
            tempHeaderMap.putAll(headerMap);
            for(FollowUpDetail detail: result.getFollowUpDetailList()){
                Boolean hasItem = tempHeaderMap.get(detail.getFollowUpID());
                if(hasItem != null && hasItem){
                    detail.setDisplayOrder(displayOrder.get(detail.getFollowUpID()));
                    processedList.add(detail);
                    tempHeaderMap.remove(detail.getFollowUpID());
                }
            }
            if(tempHeaderMap.size() > 0){
                for (Map.Entry<Long, Boolean> entry : tempHeaderMap.entrySet()) {
                    Long followUpID = Long.valueOf(entry.getKey().toString());
                    FollowUpDetail detail = new FollowUpDetail();
                    detail.setFollowUpID(followUpID);
                    detail.setDisplayOrder(displayOrder.get(followUpID));
                    processedList.add(detail);
                }
                tempHeaderMap.clear();
            }
            result.setFollowUpDetailList(processedList);
            result.setJsonData(JsonConverter.convertListToJson(result.getFollowUpDetailList(), false));
        }
        return  viewData;
    }


    public void create(FollowUpResultData data) throws BottomUpException {
        data.setJsonData(JsonConverter.convertListToJson(data.getFollowUpDetailList(), false));
        followUpResultMapper.create(data);
    }

    public void update(FollowUpResultData data) throws BottomUpException {
        data.setJsonData(JsonConverter.convertListToJson(data.getFollowUpDetailList(), false));
        followUpResultMapper.update(data);
    }

    public FollowUpResultData getByID(Long ID)throws BottomUpException {
        FollowUpResultData followUpResultData = this.followUpResultMapper.getByID(ID);
        followUpResultData.setFollowUpDetailList(JsonConverter.convertJsonToList(followUpResultData.getJsonData(),FollowUpDetail.class));
        return followUpResultData;
    }

    public List<FollowUpResultData> getByParam(Map<String, Object> param) throws BottomUpException {
        List<FollowUpResultData> list = this.followUpResultMapper.getByParam(param);
        for(FollowUpResultData data: list){
            data.setFollowUpDetailList(JsonConverter.convertJsonToList(data.getJsonData(),FollowUpDetail.class));
        }
        return list;
    }

    public void delete (Map<String,Object> param) throws BottomUpException {
        this.followUpResultMapper.delete(param);
    }
}
