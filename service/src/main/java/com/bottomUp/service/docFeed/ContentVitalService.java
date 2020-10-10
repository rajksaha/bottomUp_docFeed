package com.bottomUp.service.docFeed;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.AppointmentTypeData;
import com.bottomUp.domain.ContentVitalData;
import com.bottomUp.myBatis.persistence.AppointmentTypeMapper;
import com.bottomUp.myBatis.persistence.ContentVitalMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by raj on 09/08/2020.
 */

@Service
public class ContentVitalService {

    @Autowired
    private ContentVitalMapper contentVitalMapper;

    public void create(ContentVitalData data) throws BottomUpException {
        contentVitalMapper.create(data);
    }

    public void update(ContentVitalData  data) throws BottomUpException {
        contentVitalMapper.update(data);
    }

    public ContentVitalData  getByID(Long ID)throws BottomUpException {
        return this.contentVitalMapper.getByID(ID);
    }

    public List<ContentVitalData > getByParam(Map<String, Object> param) throws BottomUpException {
        return this.contentVitalMapper.getByParam(param);
    }

    public void delete (Map<String,Object> param) throws BottomUpException {
        this.contentVitalMapper.delete(param);
    }
}
