package com.bottomUp.service.docFeed.crud;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.ContentDurationTypeData;
import com.bottomUp.myBatis.persistence.ContentDurationTypeMapper;
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
public class ContentDurationTypeService {

    @Autowired
    private ContentDurationTypeMapper contentDayTypeMapper;

    public void create(ContentDurationTypeData data) throws BottomUpException {
        contentDayTypeMapper.create(data);
    }

    public void update(ContentDurationTypeData data) throws BottomUpException {
        contentDayTypeMapper.update(data);
    }

    public ContentDurationTypeData getByID(String ID)throws BottomUpException {
        return this. contentDayTypeMapper.getByID(ID);
    }

    public List<ContentDurationTypeData> getByParam(Map<String, Object> param) throws BottomUpException {
        return this. contentDayTypeMapper.getByParam(param);
    }

    public void delete (Map<String,Object> param) throws BottomUpException {
        this. contentDayTypeMapper.delete(param);
    }
}
