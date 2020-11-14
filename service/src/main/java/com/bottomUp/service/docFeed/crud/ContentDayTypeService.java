package com.bottomUp.service.docFeed.crud;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.AppointmentTypeData;
import com.bottomUp.domain.ContentDayTypeData;
import com.bottomUp.myBatis.persistence.AppointmentTypeMapper;
import com.bottomUp.myBatis.persistence.ContentDayTypeMapper;
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
public class ContentDayTypeService {

    @Autowired
    private ContentDayTypeMapper contentDayTypeMapper;

    public void create(ContentDayTypeData data) throws BottomUpException {
        contentDayTypeMapper.create(data);
    }

    public void update(ContentDayTypeData data) throws BottomUpException {
        contentDayTypeMapper.update(data);
    }

    public ContentDayTypeData getByID(Long ID)throws BottomUpException {
        return this. contentDayTypeMapper.getByID(ID);
    }

    public List<ContentDayTypeData> getByParam(Map<String, Object> param) throws BottomUpException {
        return this. contentDayTypeMapper.getByParam(param);
    }

    public void delete (Map<String,Object> param) throws BottomUpException {
        this. contentDayTypeMapper.delete(param);
    }
}
