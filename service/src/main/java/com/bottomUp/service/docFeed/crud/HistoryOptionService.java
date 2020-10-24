package com.bottomUp.service.docFeed.crud;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.AppointmentTypeData;
import com.bottomUp.domain.HistoryOptionData;
import com.bottomUp.myBatis.persistence.AppointmentTypeMapper;
import com.bottomUp.myBatis.persistence.HistoryOptionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by raj on 09/08/2020.
 */

@Service
public class HistoryOptionService {

    @Autowired
    private HistoryOptionMapper historyOptionMapper;

    public void create(HistoryOptionData data) throws BottomUpException {
        historyOptionMapper.create(data);
    }

    public void update(HistoryOptionData  data) throws BottomUpException {
        historyOptionMapper.update(data);
    }

    public HistoryOptionData  getByID(Long ID)throws BottomUpException {
        return this.historyOptionMapper.getByID(ID);
    }

    public List<HistoryOptionData > getByParam(Map<String, Object> param) throws BottomUpException {
        return this.historyOptionMapper.getByParam(param);
    }

    public void delete (Map<String,Object> param) throws BottomUpException {
        this.historyOptionMapper.delete(param);
    }
}
