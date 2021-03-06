package com.bottomUp.service.docFeed.crud;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.AppointmentTypeData;
import com.bottomUp.domain.ContentWhenTypeData;
import com.bottomUp.myBatis.persistence.AppointmentTypeMapper;
import com.bottomUp.myBatis.persistence.ContentWhenTypeMapper;
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
public class ContentWhenTypeService {

    @Autowired
    private ContentWhenTypeMapper contentWhenTypeMapper;

    public void create(ContentWhenTypeData data) throws BottomUpException {
        contentWhenTypeMapper.create(data);
    }

    public void update(ContentWhenTypeData data) throws BottomUpException {
        contentWhenTypeMapper.update(data);
    }

    public ContentWhenTypeData getByID(String ID)throws BottomUpException {
        return this.contentWhenTypeMapper.getByID(ID);
    }

    public List<ContentWhenTypeData> getByParam(Map<String, Object> param) throws BottomUpException {
        return this.contentWhenTypeMapper.getByParam(param);
    }

    public void delete (Map<String,Object> param) throws BottomUpException {
        this.contentWhenTypeMapper.delete(param);
    }
}
