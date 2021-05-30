package com.bottomUp.service.docFeed.crud;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.ContentDrugGenericData;
import com.bottomUp.myBatis.persistence.ContentDrugGenericMapper;
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
public class ContentDrugGenericService {

    @Autowired
    private ContentDrugGenericMapper contentDrugGenericMapper;

    public void create(ContentDrugGenericData data) throws BottomUpException {
        contentDrugGenericMapper.create(data);
    }

    public void update(ContentDrugGenericData data) throws BottomUpException {
        contentDrugGenericMapper.update(data);
    }

    public ContentDrugGenericData getByID(String ID)throws BottomUpException {
        return this.contentDrugGenericMapper.getByID(ID);
    }

    public List<ContentDrugGenericData> getByParam(Map<String, Object> param) throws BottomUpException {
        return this.contentDrugGenericMapper.getByParam(param);
    }

    public void delete (Map<String,Object> param) throws BottomUpException {
        this.contentDrugGenericMapper.delete(param);
    }
}
