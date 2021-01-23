package com.bottomUp.service.docFeed.crud;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.AppointmentTypeData;
import com.bottomUp.domain.HistoryData;
import com.bottomUp.myBatis.persistence.AppointmentTypeMapper;
import com.bottomUp.myBatis.persistence.HistoryMapper;
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
public class HistoryService {

    @Autowired
    private HistoryMapper historyMapper;

    public Long getInsert(String historyName, String typeCode)throws BottomUpException{
        Map<String, Object> params = new HashMap<>();
        params.put("name", historyName);
        params.put("typeCode", typeCode);
        List<HistoryData> historyList = historyMapper.getByParam(params);
        HistoryData historyData = null;
        if(historyList != null && historyList.size() > 0){
            historyData = historyList.get(0);
        }else {
            historyData = new HistoryData();
            historyData.setName(historyName);
            historyData.setShortName(historyName);
            historyData.setTypeCode(typeCode);
            historyMapper.create(historyData);
        }

        return historyData.getHistoryID();
    }

    public void create(HistoryData data) throws BottomUpException {
        historyMapper.create(data);
    }

    public void update(HistoryData data) throws BottomUpException {
        historyMapper.update(data);
    }

    public HistoryData getByID(Long ID)throws BottomUpException {
        return this.historyMapper.getByID(ID);
    }

    public List<HistoryData> getByParam(Map<String, Object> param) throws BottomUpException {
        return this.historyMapper.getByParam(param);
    }

    public void delete (Map<String,Object> param) throws BottomUpException {
        this.historyMapper.delete(param);
    }
}
