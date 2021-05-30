package com.bottomUp.service.docFeed.crud;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.AppointmentTypeData;
import com.bottomUp.domain.ContentDrugTypeData;
import com.bottomUp.myBatis.persistence.AppointmentTypeMapper;
import com.bottomUp.myBatis.persistence.ContentDrugTypeMapper;
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
public class ContentDrugTypeService {

    @Autowired
    private ContentDrugTypeMapper contentDrugTypeMapper;

    public void create(ContentDrugTypeData data) throws BottomUpException {
        contentDrugTypeMapper.create(data);
    }

    public void update(ContentDrugTypeData data) throws BottomUpException {
        contentDrugTypeMapper.update(data);
    }

    public ContentDrugTypeData getByID(String ID)throws BottomUpException {
        return this.contentDrugTypeMapper.getByID(ID);
    }

    public List<ContentDrugTypeData> getByParam(Map<String, Object> param) throws BottomUpException {
        return this.contentDrugTypeMapper.getByParam(param);
    }

    public void delete (Map<String,Object> param) throws BottomUpException {
        this.contentDrugTypeMapper.delete(param);
    }
}
