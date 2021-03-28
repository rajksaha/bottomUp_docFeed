package com.bottomUp.service.docFeed.crud;

import com.bottomUp.common.exception.BottomUpException;
import com.bottomUp.domain.AppointmentTypeData;
import com.bottomUp.domain.ContentDrugData;
import com.bottomUp.domain.ContentDrugGenericData;
import com.bottomUp.myBatis.persistence.AppointmentTypeMapper;
import com.bottomUp.myBatis.persistence.ContentDrugGenericMapper;
import com.bottomUp.myBatis.persistence.ContentDrugMapper;
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
public class ContentDrugService {

    @Autowired
    private ContentDrugMapper contentDrugMapper;

    @Autowired
    private ContentDrugGenericMapper contentDrugGenericMapper;

    public void create(ContentDrugData data) throws BottomUpException {
        this.getGenericID(data);
        contentDrugMapper.create(data);
    }

    public void update(ContentDrugData data) throws BottomUpException {
        this.getGenericID(data);
        contentDrugMapper.update(data);
    }

    private void getGenericID(ContentDrugData data) throws BottomUpException{
        if(data.getGenericDrugName() != null){
            ContentDrugGenericData genericData = contentDrugGenericMapper.getByName(data.getGenericDrugName());
            if(genericData != null){
                data.setGenericID(genericData.getGenericID());
            }else{
                genericData = new ContentDrugGenericData();
                genericData.setGenericDrugName(data.getGenericDrugName());
                genericData.setTypeID(data.getTypeID());
                contentDrugGenericMapper.create(genericData);
                data.setGenericID(genericData.getGenericID());
            }
        }
    }

    public ContentDrugData getByID(Long ID)throws BottomUpException {
        return this.contentDrugMapper.getByID(ID);
    }

    public List<ContentDrugData> getByParam(Map<String, Object> param) throws BottomUpException {
        return this.contentDrugMapper.getByParam(param);
    }

    public Integer getCountByParam(Map<String, Object> param) throws BottomUpException{
        return this.contentDrugMapper.getCountByParam(param);
    }

    public void delete (Map<String,Object> param) throws BottomUpException {
        this.contentDrugMapper.delete(param);
    }
}
