package com.bottomUp.service.docFeed.crud;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.ContentDoseTypeData;
import com.bottomUp.myBatis.persistence.ContentDoseTypeMapper;
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
public class ContentDoseTypeService {

    @Autowired
    private ContentDoseTypeMapper contentDoseTypeMapper;

    public void create(ContentDoseTypeData data) throws BottomUpException {
        contentDoseTypeMapper.create(data);
    }

    public void update(ContentDoseTypeData data) throws BottomUpException {
        contentDoseTypeMapper.update(data);
    }

    public ContentDoseTypeData getByID(Long ID)throws BottomUpException {
        return this.contentDoseTypeMapper.getByID(ID);
    }

    public List<ContentDoseTypeData> getByParam(Map<String, Object> param) throws BottomUpException {
        return this.contentDoseTypeMapper.getByParam(param);
    }

    public void delete (Map<String,Object> param) throws BottomUpException {
        this.contentDoseTypeMapper.delete(param);
    }
}
