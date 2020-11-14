package com.bottomUp.service.docFeed.crud;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.AppointmentTypeData;
import com.bottomUp.domain.HistoryData;
import com.bottomUp.myBatis.persistence.AppointmentTypeMapper;
import com.bottomUp.myBatis.persistence.HistoryMapper;
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
public class HistoryService {

    @Autowired
    private HistoryMapper historyMapper;

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
